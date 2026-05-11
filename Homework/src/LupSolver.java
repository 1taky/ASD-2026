public class LupSolver {

    public static void lupDecompose(double[][] A, double[][] L, double[][] U, int[] P, int n) {
        double[][] tempA = new double[n][n];
        for (int i = 0; i < n; i++) {
            P[i] = i;
            System.arraycopy(A[i], 0, tempA[i], 0, n);
        }

        for (int i = 0; i < n; i++) {
            double maxPivot = 0;
            int pivotRow = i;
            for (int j = i; j < n; j++) {
                if (Math.abs(tempA[P[j]][i]) > maxPivot) {
                    maxPivot = Math.abs(tempA[P[j]][i]);
                    pivotRow = j;
                }
            }

            int tempP = P[i];
            P[i] = P[pivotRow];
            P[pivotRow] = tempP;

            for (int j = i + 1; j < n; j++) {
                tempA[P[j]][i] /= tempA[P[i]][i];
                for (int k = i + 1; k < n; k++) {
                    tempA[P[j]][k] -= tempA[P[j]][i] * tempA[P[i]][k];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) L[i][j] = tempA[P[i]][j];
                else if (i == j) { L[i][j] = 1.0; U[i][j] = tempA[P[i]][j]; }
                else U[i][j] = tempA[P[i]][j];
            }
        }
    }

    public static double[] lupSolve(double[][] L, double[][] U, int[] P, double[] b, int n) {
        double[] y = new double[n];
        double[] x = new double[n];

        for (int i = 0; i < n; i++) {
            y[i] = b[P[i]];
            for (int j = 0; j < i; j++) {
                y[i] -= L[i][j] * y[j];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            x[i] = y[i];
            for (int j = i + 1; j < n; j++) {
                x[i] -= U[i][j] * x[j];
            }
            x[i] /= U[i][i];
        }
        return x;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.4f ", val);
            }
            System.out.println();
        }
    }
}