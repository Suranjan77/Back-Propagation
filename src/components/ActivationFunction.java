package components;

/**
 * Activation functions used by the Neural Network
 *
 * @author Suranjan Poudel
 */
public class ActivationFunction {
    /**
     * Applies sigmoid function on given input
     *
     * @param x input should be a double value
     * @return result of sigmoid activation function on input
     */
    public double sigmoid(double x) {
        return Math.exp(x) / (1 + Math.exp(x));
    }

    /**
     * Applies derivative of sigmoid function on given input
     *
     * @param x input should be double value
     * @return result of derivative of sigmoid function on input
     */
    public double sigmoidDerivative(double x) {
        return sigmoid(x) * (1 - sigmoid(x));
    }
}
