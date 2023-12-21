import tensorflow as tf
import os

curr_dir = os.path.dirname(os.path.realpath(__file__))
model_path = os.path.join(curr_dir, './model/model.h5')

model = tf.keras.models.load_model(model_path)
converter = tf.lite.TFLiteConverter.from_keras_model(model)
tflite_model = converter.convert()
open(os.path.join(curr_dir, './model/model.tflite'), "wb").write(tflite_model)
