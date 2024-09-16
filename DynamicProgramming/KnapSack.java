package DynamicProgramming;

public class KnapSack {
    public static int getMaxProfit(int weight[], int profit[], int capacity){
        int n=profit.length;
        int i,w;
        int dp[][] = new int[n+1][capacity+1];
        for(i=0;i<=n;i++){
            for(w=0;w<=capacity;w++){
                if(i==0||w==0)
                    dp[i][w]=0;
                else if(weight[i-1]<=w){
                    dp[i][w] = Math.max(profit[i-1]+dp[i-1][w-weight[i-1]], dp[i-1][w]);
                }else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String args[]){
        int profit[] = new int[] { 60, 100, 120,250 };
        int weight[] = new int[] { 1, 2, 3,5 };
        int W = 6   ;
        System.out.println(getMaxProfit( weight, profit, W));

}
    
}