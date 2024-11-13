package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
   
    private static List<Integer> printSpiral(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        List<Integer> result = new ArrayList<>();


        boolean[][] seen = new boolean[m][n];

        int[] dr = {0, 1, 0, -1};

        int[] dc = {1, 0, -1, 0};

        int r = 0, c = 0;
        int di = 0;

        for (int i = 0; i < m * n; ++i) {

            result.add(mat[r][c]);
            seen[r][c] = true;

            int newR = r + dr[di];
            int newC = c + dc[di];

            if (0 <= newR && newR < m && 0 <= newC && newC < n
                    && !seen[newR][newC]) {
                r = newR;
                c = newC;
            } else {

                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return result;
    }

    public static void main(String ars[]) {
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 12, 13, 14, 5 },
                { 11, 16, 15, 6 },
                { 10, 9, 8, 7 }
        };
        
        List<Integer> result = printSpiral(mat);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
