package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static void freeInterval(int arr[][]) {
        int l = arr.length;
        ArrayList<Interval> p = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 1; i < l; i++) {

            int prevEnd = arr[i - 1][1];
            int currStart = arr[i][0];

            if (prevEnd<currStart ) {
                Interval interval = new Interval(prevEnd, currStart);
                p.add(interval);
            }
        }
        for (int i = 0; i < p.size(); i++) {
            System.out.println("[" + p.get(i).start +
                    ", " + p.get(i).end + "]");
        }

    }

    public static void main(String args[]) {
        int[][] arr = { { 1, 3 },
                { 2, 4 },
                { 3, 5 },
                { 7, 9 } };
        freeInterval(arr);
    }
}
