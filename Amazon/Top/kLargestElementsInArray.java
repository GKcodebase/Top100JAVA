package Amazon.Top;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find the k first elements in the given bigArray.
 */
public class kLargestElementsInArray {

    /**
     * Solution using Max Heap
     * Space O(n), Time O(n*log(n)) heapify will take log(n) time
     *
     * @param arr the arr
     * @param k   the k
     * @return the int [ ]
     */
    public static int[] getKElementsWithMaxHeap(int arr[], int k){
        int result[] = new int[k];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            pq.add(i);
        }
        int i=0;
        while(k-->0)
            result[i++] = pq.poll();

        return result;
    }

    /**
     * Solution using Min Heap
     * Space O(k), Time O(n*log(k)) heapify will take log(k) time
     *
     * @param arr the arr
     * @param k   the k
     * @return the int [ ]
     */
    public static int[] getKElementsWithMinHeap(int arr[], int k){
        int result[] = new int[k];

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if( arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        k--;
        while(k>=0)
            result[k--] = pq.poll();

        return result;
    }

    //TODO Quick Select algorithm




    /**
     * Main.
     *
     * @param args the args
     */
//Driver
    public static void main(String args[]){
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        int[] res = getKElementsWithMaxHeap(arr, k);
        for (int ele : res)
            System.out.print(ele + " ");

        System.out.println();


        res = getKElementsWithMinHeap(arr, k);
        for (int ele : res)
            System.out.print(ele + " ");
    }
}
