package String;

import java.util.Arrays;

public class PallindromeSubstringCount {

    static int isPalindrome(int i, int j, String s, int dp[][]) {
        if (i == j)
            return 1;
        if (j == i + 1 && s.charAt(i) == s.charAt(j))
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == s.charAt(j) &&
                isPalindrome(i + 1, j - 1, s, dp) == 1)
            dp[i][j] = 1;
        else
            dp[i][j] = 0;
        return dp[i][j];

    }

    public static int countPs(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPalindrome(i, j, s, dp) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        String s = "abaab";
        System.out.println(countPs(s));
    }
}
