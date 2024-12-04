package DynamicProgramming;

public class MaxProductOfCuttingRope {

    static int getMaxLength(int length){
        int dp[] = new int[length+1];
        dp[0]=dp[1]=0;
        for(int i=1;i<=length;i++){
            int tempMax =0;
            for(int j=1;j<=i;j++){
                tempMax=Math.max(tempMax,Math.max((i-j)*j,j*dp[i-j]));
            }
            dp[i]=tempMax;
        }

        return dp[length];
    }
    public static void main(String args[]){
        System.out.println(getMaxLength(10));
    }
}
