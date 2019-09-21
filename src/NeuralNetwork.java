import components.ActivationFunction;
import config.NeuralNetworkProperties;
import utils.MatrixOperations;
import utils.WeightsGenerator;

/**
 * A neural network
 *
 * @author Suranjan Poudel
 */
public class NeuralNetwork {
    private double[][] WEIGHTS_IH;
    private double[][] WEIGHTS_HO;
    private ActivationFunction activationFunction = new ActivationFunction();

    /**
     * Initializes weights for the neural network
     *
     * @return list of weights matrix
     */
    public void initWeights() {
        WeightsGenerator weightsGenerator = new WeightsGenerator();
        this.WEIGHTS_IH = weightsGenerator.initWeights(NeuralNetworkProperties.INPUT_LAYER_NODES, NeuralNetworkProperties.HIDDEN_LAYER_NODES);
        this.WEIGHTS_HO = weightsGenerator.initWeights(NeuralNetworkProperties.HIDDEN_LAYER_NODES, NeuralNetworkProperties.OUTPUT_LAYER_NODES);
    }

    public double[][] gradientDescent(double[][] input, double[][] actualOutput) throws Exception {
        double[][] output = new double[input.length][actualOutput[0].length];
        for (int i = 0; i < NeuralNetworkProperties.NUMBER_OF_EPOCHS; i++) {
            double[][] net = calculateSigmoidOfMatrix(MatrixOperations.dot(input, WEIGHTS_IH));
            output = calculateSigmoidOfMatrix(MatrixOperations.dot(net, WEIGHTS_HO));

            double[][] hiddenToOutputGradient = MatrixOperations.dot(
                    MatrixOperations.transpose(output),
                    MatrixOperations.multiply(
                            calculateSigmoidDerivativeOfMatrix(MatrixOperations.dot(output, MatrixOperations.transpose(WEIGHTS_HO))),
                            MatrixOperations.subtract(actualOutput, output)
                    )
            );

            double[][] inputToHiddenGradient = MatrixOperations.dot(
                    MatrixOperations.transpose(input),
                    MatrixOperations.multiply(
                            calculateSigmoidDerivativeOfMatrix(MatrixOperations.dot(input, WEIGHTS_IH)),
                            MatrixOperations.dot(
                                    MatrixOperations.multiply(
                                            calculateSigmoidDerivativeOfMatrix(MatrixOperations.dot(output, MatrixOperations.transpose(WEIGHTS_HO))),
                                            MatrixOperations.subtract(actualOutput, output)
                                    ),
                                    WEIGHTS_HO
                            )
                    )

            );

            //Update Input to Hidden layer weights
            WEIGHTS_IH = MatrixOperations.add(
                    WEIGHTS_IH,
                    MatrixOperations.multiply(
                            inputToHiddenGradient,
                            new double[][]{{NeuralNetworkProperties.LEARNING_RATE}}
                    )
            );
            //Update Hidden to Output layer weights
            WEIGHTS_HO = MatrixOperations.add(
                    WEIGHTS_HO,
                    MatrixOperations.transpose(
                            MatrixOperations.multiply(
                                    hiddenToOutputGradient,
                                    new double[][]{{NeuralNetworkProperties.LEARNING_RATE}}
                            )
                    )
            );
        }
        return output;
    }

    private double[][] calculateSigmoidOfMatrix(double[][] A) {
        double[][] C = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = activationFunction.sigmoid(A[i][j]);
            }
        }
        return C;
    }

    private double[][] calculateSigmoidDerivativeOfMatrix(double[][] A) {
        double[][] C = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = activationFunction.sigmoid(A[i][j]);
            }
        }
        return C;
    }

    public static void main(String[] args) {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        neuralNetwork.initWeights();
        double[][] input = {
                {8, 2, 8},
                {8, 2, 8},
                {1, 0, 1},
                {8, 2, 8},
                {8, 2, 8},
                {1, 0, 1},
                {1, 0, 1}
        };
        double[][] output = {
                {1},
                {1},
                {0},
                {1},
                {1},
                {0},
                {0}
        };
        try {
            double[][] predictedOutput = neuralNetwork.gradientDescent(input, output);
            System.out.println("Final Output: ");
            MatrixOperations.display(predictedOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
