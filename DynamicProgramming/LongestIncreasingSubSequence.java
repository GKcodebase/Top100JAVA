package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    static int getMaxLength(int arr[]) {
        int n = arr.length;
        int maxLength = 0;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(getMaxLength(arr));
    }
}
