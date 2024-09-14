package Array;

import java.util.*;;

public class TripletPairSum {
    public static List<int[]> findPairs(int[] arr, int start, int target, int firstEle) {
        Set<Integer> st = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for (int i = start; i < arr.length; i++) {
            int thirdEle = target - arr[i];
            if (st.contains(thirdEle)) {
                result.add(new int[] { firstEle, arr[i], thirdEle });
            }
            st.add(arr[i]);
        }
        return result;
    }

    public static List<int[]> findTriplets(int arr[]) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int target = -arr[i];
            List<int[]> pairs = findPairs(arr, i + 1, target, arr[i]);
            result.addAll(pairs);
        }
        return result;
    }

    public static void main(String args[]) {
        int[] arr = { 0, -1, 2, -3, 1 };
        List<int[]> result = findTriplets(arr);

        if (result.isEmpty()) {
            System.out.println("No Triplet Found");
        } else {
            // Print each triplet
            for (int[] t : result) {
                System.out.println(t[0] + " " + t[1] + " " + t[2]);
            }
        }
    }
}
