package DynamicProgramming;

public class MaxProductAfterCuttingRope {
    public static int maxProduct(int length){
        int maxProd[] = new int[length+1];
        maxProd[0]=maxProd[1]=0;
        for(int i=1;i<=length;i++){
            int max_Value=0;
            for(int j=1;j<=i;j++){
                max_Value=Math.max(max_Value,Math.max((i-j)*j,maxProd[i-j]*j));
            }
            maxProd[i]=max_Value;
        }
        return maxProd[length];
    }
    public static void main(String args[]){
        System.out.println("Maximum Product is "
        + maxProduct(10));
    }
}
