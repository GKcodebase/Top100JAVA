package Matrix;

public class WordSearch {
    static boolean search2D(char[][] grid, int row, int col, String word) {
        int m = grid.length;
        int n = grid[0].length;

        // return false if the given coordinate
        // does not match with first index char.
        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        // x and y are used to set the direction in which
        // word needs to be searched.
        int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // This loop will search in all the 8 directions
        for (int dir = 0; dir < 8; dir++) {
            int k, currX = row + x[dir],
                    currY = col + y[dir];

            // First character is already checked, match
            // remaining
            for (k = 1; k < len; k++) {
                if (currX >= m || currX < 0 || currY >= n
                        || currY < 0)
                    break;

                if (grid[currX][currY] != word.charAt(k))
                    break;

                currX += x[dir];
                currY += y[dir];
            }

            if (k == len)
                return true;
        }

        return false;
    }

    static int[][] searchWord(char[][] grid, String word) {
        int m = grid.length;
        int n = grid[0].length;

        int ans[][] = new int[m * n][2];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search2D(grid, i, j, word)) {
                    ans[count][0] = i;
                    ans[count][1] = j;
                    count++;
                }
            }
        }
        int[][] result = new int[count][2];
        for (int i = 0; i < count; i++) {
            result[i] = ans[i];
        }

        return result;
    }

    public static void main(String args[]) {
        char[][] grid = { { 'a', 'b', 'a', 'b' },
                { 'a', 'b', 'e', 'b' },
                { 'e', 'b', 'e', 'b' } };
        String word = "abe";

        int[][] ans = searchWord(grid, word);

        for (int[] coords : ans) {
            System.out.print("{" + coords[0] + "," + coords[1] + "}" + " ");
            System.out.println();
        }
    }
}
