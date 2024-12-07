package DynamicProgramming;

public class MaxSumOfNonAdjacentElements {

    static int getMaxLoot(int arr[]) {
        int l = arr.length;

        int dp[] = new int[l + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i <=l; i++)
            dp[i] = Math.max(dp[i - 1], arr[i - 1] + dp[i - 2]);

        return dp[l];

    }

    public static void main(String args[]) {
        int[] hval = { 6, 7, 1, 3, 8, 2, 4 };
        System.out.println(getMaxLoot(hval));
    }
}
