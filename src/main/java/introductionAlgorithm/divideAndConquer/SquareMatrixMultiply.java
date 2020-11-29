package introductionAlgorithm.divideAndConquer;

/**
 * @author liumt
 * @date Created in 2020/11/24 12:22
 * 两个n * n矩阵乘法
 */
public class SquareMatrixMultiply {
    /**
     * 暴力解法O(n^3)
     */
    public static int[][] squareMatrixMultiply(int[][] A, int[][] B) {
        int rows = A.length;
        int[][] C = new int[rows][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < rows; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
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
        int[][] C = squareMatrixMultiply(A, B);
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.println(C[i][j]);
            }
        }
    }
}
