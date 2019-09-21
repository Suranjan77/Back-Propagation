package components;

import utils.MatrixOperations;

/**
 * Single unit of a Neural Network
 *
 * @author Suranjan Poudel
 */
public class Neuron {
    /**
     * Calculates the sum of product of weights and input
     *
     * @param weights weights linked with the neuron
     * @param input   input to the neuron
     * @return sum of product of weights and input
     * @throws Exception occurs when dimension of weight and input are not same
     */
    public double calculateNet(double[][] weights, double[][] input) throws Exception {
        return MatrixOperations.sum(MatrixOperations.multiply(weights, input));
    }

    /**
     * Applies activation function to sum of product of weights and input
     *
     * @param net sum of product of weights and input
     * @return applies activation function to squash output
     */
    public double squash(double net) {
        ActivationFunction activationFunction = new ActivationFunction();
        return activationFunction.sigmoid(net);
    }
}
