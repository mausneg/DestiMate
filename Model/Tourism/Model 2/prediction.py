import tensorflow_recommenders as tfrs
import tensorflow as tf
import pickle as pkl
import os
import numpy as np

curr_dir = os.path.dirname(os.path.realpath(__file__))
user_vocab_path = os.path.join(curr_dir, 'pickles/user_vocab.pkl')
tourism_vocab_path = os.path.join(curr_dir, 'pickles/tourism_vocab.pkl')

with open(user_vocab_path, 'rb') as file:
    user_vocab = pkl.load(file)

with open(tourism_vocab_path, 'rb') as file:
    tourism_vocab = pkl.load(file)

user_vocab = tf.keras.layers.IntegerLookup(vocabulary=user_vocab, mask_token=None)
tourism_vocab = tf.keras.layers.IntegerLookup(vocabulary=tourism_vocab, mask_token=None)

tourism_path = os.path.join(curr_dir, 'tensor/tourism')
tourism = tf.data.Dataset.load(tourism_path)

class CollaborativeModel(tfrs.Model):
    def __init__(self):
        super().__init__()
        self.user_model = tf.keras.Sequential([
            user_vocab,
            tf.keras.layers.Embedding(user_vocab.vocabulary_size(), 16)
        ])
        self.tourism_model = tf.keras.Sequential([
            tourism_vocab,
            tf.keras.layers.Embedding(tourism_vocab.vocabulary_size(), 16)
        ])
        self.task = tfrs.tasks.Retrieval(
            metrics=tfrs.metrics.FactorizedTopK(
                candidates=tourism.batch(128).map(self.tourism_model)
            )
        )
    def compute_loss(self, features, training=False):
        user_embeddings = self.user_model(features["user_id"])
        tourism_embeddings = self.tourism_model(features["place_id"])
        return self.task(user_embeddings, tourism_embeddings)

model = CollaborativeModel()
weights_path = os.path.join(curr_dir, './weights/model_weights')
model.load_weights(weights_path).expect_partial()
index = tfrs.layers.factorized_top_k.BruteForce (model.user_model)
no_user = 1
index.index_from_dataset(tourism.batch(100).map(lambda place: (place,model.tourism_model(place))))
_, titles = index(np.array([no_user]))
print(f"Recommendations for user {no_user}: {titles[0,:10]}")