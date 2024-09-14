package DynamicProgramming;

public class CountingCoin {
    public static int coutnCoins(int coins[], int sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];
        dp[0][0] =1;    
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]+=dp[i-1][j];
                if(j-coins[i-1]>=0){
                    dp[i][j]+=dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String args[]){
        int coins[] = {2,5,3,6};
        int sum = 10;
        System.out.println("No of ways is :: "+coutnCoins(coins,  sum));
    }
}
