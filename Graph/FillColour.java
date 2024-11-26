package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FillColour {

    static void floodFill(List<List<Integer>> img, int x, int y, int newClr) {
        int prevClr = img.get(x).get(y);

        if (newClr == prevClr)
            return;

        modifiedDfs(img, x, y, prevClr, newClr);
    }

    private static void modifiedDfs(List<List<Integer>> img, int x, int y, int prevClr, int newClr) {
        if (img.get(x).get(y) != prevClr)
            return;

        img.get(x).set(y, newClr);
        int m = img.size();
        int n = img.get(0).size();

        if (x - 1 >= 0) {
            modifiedDfs(img, x - 1, y, prevClr, newClr);
        }
        if (x + 1 < m) {
            modifiedDfs(img, x + 1, y, prevClr, newClr);
        }
        if (y - 1 >= 0) {
            modifiedDfs(img, x, y - 1, prevClr, newClr);
        }
        if (y + 1 < n) {
            modifiedDfs(img, x, y + 1, prevClr, newClr);
        }
    }

    public static void main(String args[]) {
        List<List<Integer>> img = new ArrayList<>();
        img.add(Arrays.asList(1, 1, 1));
        img.add(Arrays.asList(1, 1, 0));
        img.add(Arrays.asList(1, 0, 1));

        // Co-ordinate provided by the user
        int x = 1;
        int y = 1;

        // New color that has to be filled
        int newClr = 2;
        floodFill(img, x, y, newClr);

        // Printing the updated img
        for (List<Integer> row : img) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
