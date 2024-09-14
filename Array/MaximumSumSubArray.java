package Array;

public class MaximumSumSubArray {
    //Kadanes Algortim
    public static void maximumSubArray(int arr[]){
        int maxSum = Integer.MIN_VALUE, tempMax =0;
        for(int i:arr){
            tempMax+=i;
            maxSum = Math.max(maxSum, tempMax);
            tempMax=Math.max(0, tempMax);
        }
        System.out.println("Maximum sum is :: "+maxSum);
    }
    public static void main(String args[]){
        int[] a = {10, -2, -3, -2, -1, -2, -9, -99, -30 ,100};
        maximumSubArray(a);
    }
}
