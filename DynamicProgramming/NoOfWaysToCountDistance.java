package DynamicProgramming;

public class NoOfWaysToCountDistance {

    public static int getNoOfWays(int distance){
        int dp[] = new int[distance+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<=distance;i++)
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        return dp[distance];
    }
    public static void main(String args[]){
        int dist = 4;
        System.out.println(getNoOfWays(dist));
    }
}
