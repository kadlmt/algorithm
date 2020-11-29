package introductionAlgorithm.divideAndConquer;

/**
 * @author liumt
 * @date Created in 2020/11/24 13:00
 * 使用strassen算法矩阵相乘,假设n是2的幂
 * O(n^2.81)
 */
public class SquareMatrixMultiply4_2_1 {
    public static int[][] squareMatrixMultiplyRecursive(int[][] A, int[][] B) {
        int rows = A.length;
        int[][] C = new int[rows][rows];
        if (rows == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        } else {
            int halfSize = rows / 2;
            int[][] A00 = new int[halfSize][halfSize];
            int[][] A01 = new int[halfSize][halfSize];
            int[][] A10 = new int[halfSize][halfSize];
            int[][] A11 = new int[halfSize][halfSize];
            int[][] B00 = new int[halfSize][halfSize];
            int[][] B01 = new int[halfSize][halfSize];
            int[][] B10 = new int[halfSize][halfSize];
            int[][] B11 = new int[halfSize][halfSize];
            for (int i = 0; i < halfSize; i++) {
                for (int j = 0; j < halfSize; j++) {
                    A00[i][j] = A[i][j];
                    A01[i][j] = A[i][halfSize + j];
                    A10[i][j] = A[i + halfSize][j];
                    A11[i][j] = A[i + halfSize][j + halfSize];

                    B00[i][j] = B[i][j];
                    B01[i][j] = B[i][halfSize + j];
                    B10[i][j] = B[i + halfSize][j];
                    B11[i][j] = B[i + halfSize][j + halfSize];
                }
            }
            int[][] S1 = matrixSub(B01, B11);
            int[][] S2 = matrixAdd(A00, A01);
            int[][] S3 = matrixAdd(A10, A11);
            int[][] S4 = matrixSub(B10, B00);
            int[][] S5 = matrixAdd(A00, A11);
            int[][] S6 = matrixAdd(B00, B11);
            int[][] S7 = matrixSub(A01, A11);
            int[][] S8 = matrixAdd(B10, B11);
            int[][] S9 = matrixSub(A00, A10);
            int[][] S10 = matrixAdd(B00, B01);

            int[][] P1 = squareMatrixMultiplyRecursive(A00, S1);
            int[][] P2 = squareMatrixMultiplyRecursive(S2, B11);
            int[][] P3 = squareMatrixMultiplyRecursive(S3, B00);
            int[][] P4 = squareMatrixMultiplyRecursive(A11, S4);
            int[][] P5 = squareMatrixMultiplyRecursive(S5, S6);
            int[][] P6 = squareMatrixMultiplyRecursive(S7, S8);
            int[][] P7 = squareMatrixMultiplyRecursive(S9, S10);

            int[][] C00 = matrixAdd(matrixSub(matrixAdd(P5, P4), P2), P6);
            int[][] C01 = matrixAdd(P1, P2);
            int[][] C10 = matrixAdd(P3, P4);
            int[][] C11 = matrixSub(matrixSub(matrixAdd(P5, P1), P3), P7);
            for (int i = 0; i < halfSize; i++) {
                for (int j = 0; j < halfSize; j++) {
                    C[i][j] = C00[i][j];
                    C[i][j + halfSize] = C01[i][j];
                    C[i + halfSize][j] = C10[i][j];
                    C[i + halfSize][j + halfSize] = C11[i][j];
                }
            }
        }
        return C;
    }

    /**
     * 矩阵相减
     */
    public static int[][] matrixSub(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    /**
     * 矩阵相加
     */
    public static int[][] matrixAdd(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = new int[2][2];
        int[][] B = new int[2][2];
        A[0][0] = 1;
        A[1][0] = 7;
        A[0][1] = 3;
        A[1][1] = 5;
        B[0][0] = 6;
        B[1][0] = 4;
        B[0][1] = 8;
        B[1][1] = 2;
        int[][] C = squareMatrixMultiplyRecursive(A, B);
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.println(C[i][j]);
            }
        }
    }
}
