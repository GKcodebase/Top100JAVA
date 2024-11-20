package Array;

public class TrappingRainWater {

    static int findWater(int arr[]) {
        int n = arr.length;

        int left[] = new int[n];
        int right[] = new int[n];

        int res = 0;

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > arr[i])
                res += min - arr[i];
        }
        return res;
    }

    public static void main(String args[]) {
        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(findWater(arr));
    }
}
