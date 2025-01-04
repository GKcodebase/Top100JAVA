package Amazon.Top;

import java.util.Arrays;
import java.util.HashSet;

/**
 * The Pythagorean triplet.
 */
public class PythagoreanTriplet {


    /**
     * O(n^2)  time and O(n) spaace
     *
     * @param arr the arr
     * @return the boolean
     */
    public static boolean isTripletPresentUsingHashing(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            if (set.contains((arr[i]) * arr[i])) return true;
            for (int j = i; j < l; j++) {
                if (set.contains((arr[j]) * arr[j])) return true;
                set.add(arr[i] * arr[i] + arr[j] * arr[j]);
            }
        }

        for (int i = 0; i < l; i++)
            if (set.contains((arr[i]) * arr[i])) return true;

        return false;
    }

    /**
     * O(n^2)  time and O(1) spaace
     *
     * @param arr the arr
     * @return the boolean
     */
    public static boolean isTripletPresentUsingPointer(int[] arr) {
        int l = arr.length;
        for(int i=0;i<l;i++)
            arr[i] = arr[i]*arr[i];

        Arrays.sort(arr);

        for(int i=l-1;i>=0;i--){
            int start=0;
            int end=i-1;

            while(start<end){
                if(arr[start]+arr[end] == arr[i])
                    return true;
                else if(arr[start]+arr[end] < arr[i])
                    start++;
                else
                    end--;
            }

        }

        return false;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 3, 4, 10, 8};
        System.out.println("isTripletPresent " + isTripletPresentUsingPointer(arr));
    }
}
