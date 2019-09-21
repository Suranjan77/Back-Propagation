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
     * @throws Exception occurs when dimension of A and B are mismatched
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
     * Multiplies elements of two matrices
     *
     * @param A first matrix
     * @param B second matrix
     * @return multiplication of elements of two matrices
     * @throws Exception occurs when dimension of A and B are mismatched
     */
    //todo: broadcast in multiple cases
    public static double[][] multiply(double[][] A, double[][] B) throws Exception {
        double[][] C = new double[A.length][A[0].length];
        boolean error = true;
        //B has only one element
        if (B.length == 1) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] * B[0][0];
                }
            }
            error = false;
        }
        //Column of B is equal to A
        if (A[0].length == B[0].length && B.length == 1) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] * B[0][j];
                }
            }
            error = false;
        }
        //A and B have equal dimensions
        if (A[0].length == B[0].length && A.length == B.length) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] * B[i][j];
                }
            }
            error = false;
        }
        //Rows of A is equal to rows of B
        if (A.length == B.length && B[0].length == 1) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] * B[i][0];
                }
            }
            error = false;
        }
        if (error) {
            throw new Exception("Invalid dimensions " + shape(A) + " and " + shape(B));
        }
        return C;
    }

    /**
     * prints the shape of given matrix
     *
     * @param A Matrix
     * @return shape of given matrix
     */
    public static String shape(double[][] A) {
        System.out.println("(" + A.length + ", " + A[0].length + ")");
        return "(" + A.length + ", " + A[0].length + ")";
    }

    /**
     * Adds elements of two matrices
     *
     * @param A first matrix
     * @param B second matrix
     * @return addition of elements of two matrices
     * @throws Exception occurs when dimension of A and B are mismatched
     */
    public static double[][] add(double[][] A, double[][] B) throws Exception {
        if (A[0].length != B[0].length || A.length != B.length) {
            throw new Exception("Invalid dimensions " + shape(A) + " and " + shape(B));
        }
        double[][] C = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    /**
     * Subtracts elements of two matrices
     *
     * @param A first matrix
     * @param B second matrix
     * @return subtraction of elements of two matrices
     * @throws Exception occurs when dimension of A and B are mismatched
     */
    public static double[][] subtract(double[][] A, double[][] B) throws Exception {
        if (A[0].length != B[0].length || A.length != B.length) {
            throw new Exception("Invalid dimensions " + shape(A) + " and " + shape(B));
        }
        double[][] C = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    /**
     * Calculates transpose of a matrix
     *
     * @param A matrix
     * @return transpose of the matrix
     */
    public static double[][] transpose(double[][] A) {
        double[][] C = new double[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = A[j][i];
            }
        }
        return C;
    }

    /**
     * Calculates sum of elements of a matrix
     *
     * @param A matrix
     * @return sum of elements of a matrix
     */
    public static double sum(double[][] A) {
        double s = 0.0;
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                s += A[j][i];
            }
        }
        return s;
    }

    /**
     * @param A displays the matrix in formatted form
     */
    public static void display(double[][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print("|");
            for (int j = 0; j < A[0].length; j++) {
                System.out.print("\t" + A[i][j]);
            }
            System.out.print("\t|");
            System.out.println("");
        }
    }
}