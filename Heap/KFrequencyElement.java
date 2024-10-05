package Heap;
import java.util.*;
public class KFrequencyElement {
    public static void getFrequency(int arr[], int k){
        Map<Integer,Integer> mp = new HashMap();
        for(int i:arr){
            mp.put(i,mp.getOrDefault(i, 0)+1);

        }
        mp.forEach((K,v)->{
            if(v==k){
                System.out.println(K);
            }});
    }
    public static void main(String args[]){
        int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int K = 2;

        // Function call
        System.out.println(
            K + " numbers with most occurrences are:");
            getFrequency(arr, K);
    }
}
