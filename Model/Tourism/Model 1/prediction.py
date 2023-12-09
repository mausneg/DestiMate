import pandas as pd
import tensorflow as tf
import numpy as np
import os

curr_dir = os.path.dirname(os.path.realpath(__file__))
model_path = os.path.join(curr_dir, './model/model.h5')
tourism_path = os.path.join(curr_dir, './pickles/df_tourism.pkl')
tourism_rating_path = os.path.join(curr_dir, './pickles/df_tourism_rating.pkl')
place_id_path = os.path.join(curr_dir, './pickles/place_id_encoded.pkl')
user_id_path = os.path.join(curr_dir, './pickles/user_id_encoded.pkl')  

df_tourism = pd.read_pickle(tourism_path)
df_tourism_rating = pd.read_pickle(tourism_rating_path)
place_id_encoded = pd.read_pickle(place_id_path)
user_id_encoded = pd.read_pickle(user_id_path)
model = tf.keras.models.load_model(model_path)

user_id = 1
place_visited = df_tourism_rating[df_tourism_rating['User_Id'] == user_id]
place_not_visited = df_tourism[~df_tourism['Place_Id'].isin(place_visited['Place_Id'])]['Place_Id']
place_not_visited = list(set(place_not_visited).intersection(set(place_id_encoded.keys())))
place_not_visited = [[place_id_encoded.get(x)] for x in place_not_visited]
user_encoder = user_id_encoded.get(user_id)
user_place_array = np.hstack(([[user_encoder]] * len(place_not_visited), place_not_visited))
ratings = model.predict(user_place_array).flatten()
top_ratings_indices = ratings.argsort()[-10:][::-1]
recommended_place_ids = [place_id_encoded.get(place_not_visited[x][0]) for x in top_ratings_indices]
print(f"\nRecommended places for user id {user_id}")
recommended_place = df_tourism[df_tourism['Place_Id'].isin(recommended_place_ids)]
for row in recommended_place.itertuples():
  print("-",row.Place_Id, ":", row.Place_Name)
