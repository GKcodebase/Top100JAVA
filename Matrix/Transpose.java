package Matrix;

public class Transpose {

    public static void getTranspose(int matrix[][]) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int mat[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        getTranspose(mat);
    }
}
