package com.olexyn.about.java;

import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.evaluation.classification.Evaluation;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions;

/**
 * The KerasHello example is a simple example of using the Keras API to train a simple neural network.
 * The example is based on the Keras Hello World example.
 * <p>
 *
 */
public class KerasHello {
    public static void main(String[] args) throws Exception {
        int batchSize = 1024;
        int numEpochs = 10;
        int seed = 123;

        // Load the MNIST dataset
        DataSetIterator mnistTrain = new MnistDataSetIterator(batchSize, true, seed);

        // Define the neural network architecture
        MultiLayerConfiguration config = new NeuralNetConfiguration.Builder()
            .seed(seed)
            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
            .list()
            .layer(new DenseLayer.Builder().nIn(28 * 28).nOut(256).activation(Activation.RELU).build())
            .layer(new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                .nIn(256).nOut(10).activation(Activation.SOFTMAX).build())
            .build();

        // Create a new MultiLayerNetwork from the configuration
        MultiLayerNetwork net = new MultiLayerNetwork(config);
        net.init();

        // Train the model
        net.setListeners(new ScoreIterationListener(10));
        for (int i = 0; i < numEpochs; i++) {
            net.fit(mnistTrain);
        }

        // Evaluate the model
        DataSetIterator mnistTest = new MnistDataSetIterator(batchSize, false, seed);
        Evaluation eval = net.evaluate(mnistTest);
        System.out.println(eval.stats());
    }
}
