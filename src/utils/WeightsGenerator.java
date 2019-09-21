package utils;

import java.util.Random;

/**
 * Utility for weights generation for the Neural Network
 *
 * @author Suranjan Poudel
 */
public class WeightsGenerator {
    /**
     * Generates weights
     *
     * @param size_m number of rows
     * @param size_n number of columns
     * @return random weights array of size size_m x size_n
     */
    public double[][] initWeights(int size_m, int size_n) {
        double[][] weights = new double[size_m][size_n];
        Random random = new Random();
        for (int i = 0; i < size_m; i++) {
            for (int j = 0; j < size_n; j++) {
                weights[i][j] = random.nextDouble();
            }
        }
        return weights;
    }
}
