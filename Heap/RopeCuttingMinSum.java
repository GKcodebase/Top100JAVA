package Heap;

import java.util.PriorityQueue;

public class RopeCuttingMinSum {

    static int getMinCost(int arr[]) {
        int l = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cost = 0;
        for (int i = 0; i < l; i++)
            pq.add(arr[i]);

        while (!pq.isEmpty() && pq.size() >= 2) {
            int x = pq.poll();
            int y = pq.poll();

            int temp = x + y;
            cost += temp;
            pq.add(temp);
        }
        return cost;
    }

    public static void main(String args[]) {
        int len[] = { 4, 3, 2, 6 };
        System.out.println("Total cost for connecting"
                + " ropes is "
                + getMinCost(len));
    }
}
