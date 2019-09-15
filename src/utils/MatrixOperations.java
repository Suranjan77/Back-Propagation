package utils;

/**
 * Utility to perform various operations on matrix
 *
 * @author Suranjan Poudel
 */
public class MatrixOperations {

    /**
     * Calculates dot product of two matrices
     *
     * @param A first matrix
     * @param B second matrix
     * @return dot product of two matrices
     */
    //todo: testing
    public static double[][] dot(double[][] A, double[][] B) throws Exception {
        if (A[0].length != B.length) {
            throw new Exception("Number of column of first matrix is not equal to number of rows of second matrix");
        }
        double[][] C = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < B.length; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }
        return C;
    }

    /**
     * Multiplies elements of two matrices by broadcasting
     *
     * @param A first matrix
     * @param B second matrix
     * @return multiplication of elements of two matrices
     */
    //todo: number of columns/rows of both matrix must be same or one of them should have only one column/rows
    //todo: broadcast in multiple cases
    public static double[][] multiplyBroadcast(double[][] A, double[][] B) {
        double[][] C = new double[A.length][A[0].length];
        if (B.length == 1) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] * B[0][0];
                }
            }
        }
        if (A[0].length == B[0].length && B.length == 1) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] * B[0][j];
                }
            }
        }
        return null;
    }

    /**
     * Adds elements of two matrices by broadcasting
     *
     * @param A first matrix
     * @param B second matrix
     * @return addition of elements of two matrices
     */
    //todo: number of columns/rows of both matrix must be same or one of them should have only one column/rows
    public static double[][] add(double[][] A, double[][] B) {
        return null;
    }

    /**
     * Subtracts elements of two matrices by broadcasting
     *
     * @param A first matrix
     * @param B second matrix
     * @return subtraction of elements of two matrices
     */
    //todo: number of columns/rows of both matrix must be same or one of them should have only one column/rows
    public static double[][] subtract(double[][] A, double[][] B) {
        return null;
    }

    /**
     * Calculates transpose of a matrix
     *
     * @param A matrix
     * @return transpose of the matrix
     */
    public static double[][] transpose(double[][] A) {
        return null;
    }

    /**
     * Calculates sum of elements of a matrix
     *
     * @param A matrix
     * @return sum of elements of a matrix
     */
    public static double[][] sum(double[][] A) {
        return null;
    }
}