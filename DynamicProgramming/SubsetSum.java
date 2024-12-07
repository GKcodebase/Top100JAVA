package DynamicProgramming;

public class SubsetSum {
    static boolean isSubsetSum(int arr[], int sum) {
        int l = arr.length;

        boolean dp[][] = new boolean[l + 1][sum + 1];

        for (int i = 0; i <= l; i++)
            dp[i][0] = true;

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[l][sum];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;

        if (isSubsetSum(arr, sum)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
