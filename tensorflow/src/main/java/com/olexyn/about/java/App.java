package com.olexyn.about.java;

import org.tensorflow.DataType;
import org.tensorflow.Graph;
import org.tensorflow.Operation;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

/**
 * This class demonstrates creating and executing a simple TensorFlow graph in Java.
 * It performs a computation defined as z = a*x + b*y, where a and b are constants,
 * and x and y are variables fed at runtime.
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Create a new TensorFlow graph
        Graph graph = new Graph();

        // Define constant 'a' with a value of 3.0
        Operation a = graph.opBuilder("Const", "a")
                .setAttr("dtype", DataType.fromClass(Double.class))
                .setAttr("value", Tensor.create(3.0, Double.class))
                .build();

        // Define constant 'b' with a value of 2.0
        Operation b = graph.opBuilder("Const", "b")
                .setAttr("dtype", DataType.fromClass(Double.class))
                .setAttr("value", Tensor.create(2.0, Double.class))
                .build();

        // Define placeholder 'x' to input a value at runtime
        Operation x = graph.opBuilder("Placeholder", "x")
                .setAttr("dtype", DataType.fromClass(Double.class))
                .build();

        // Define placeholder 'y' to input a value at runtime
        Operation y = graph.opBuilder("Placeholder", "y")
                .setAttr("dtype", DataType.fromClass(Double.class))
                .build();

        // Define operation to multiply 'a' and 'x'
        Operation ax = graph.opBuilder("Mul", "ax")
                .addInput(a.output(0))
                .addInput(x.output(0))
                .build();

        // Define operation to multiply 'b' and 'y'
        Operation by = graph.opBuilder("Mul", "by")
                .addInput(b.output(0))
                .addInput(y.output(0))
                .build();

        // Define operation to add the results of 'ax' and 'by'
        Operation z = graph.opBuilder("Add", "z")
                .addInput(ax.output(0))
                .addInput(by.output(0))
                .build();

        // Print the output tensor reference (not the value)
        System.out.println(z.output(0));

        // Execute the graph
        try (Session session = new Session(graph)) {
            // Run the session, fetch the result of 'z', and feed 'x' and 'y' with specific values
            Tensor<Double> tensor = session.runner().fetch("z")
                    .feed("x", Tensor.create(3.0, Double.class))
                    .feed("y", Tensor.create(6.0, Double.class))
                    .run().get(0).expect(Double.class);

            // Print the computed value of 'z'
            System.out.println("Computed value of z: " + tensor.doubleValue());
        }

        // Note: Code to save TensorProto to file "tensor.pb" should go here if needed
    }
}
