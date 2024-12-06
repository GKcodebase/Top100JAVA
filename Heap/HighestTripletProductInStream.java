package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HighestTripletProductInStream {

    static void getTripletProduct(int arr[]) {

        int l = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < l; i++) {
            pq.add(arr[i]);

            if (pq.size() < 3)
                System.out.println("-1");
            else {
                int x = pq.poll();
                int y = pq.poll();
                int z = pq.poll();

                int ans = x * y * z;
                System.out.println(ans);
                pq.add(x);
                pq.add(y);
                pq.add(z);
            }

        }

    }

    public static void main(String args[]) {
        int arr[] = { 5, 2, 3, 4, 1, 6 };
        getTripletProduct(arr);
    }
}
