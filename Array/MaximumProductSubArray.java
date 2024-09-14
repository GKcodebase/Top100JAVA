package Array;

public class MaximumProductSubArray {
    //Using modified kadane algorithm ,O(n) time
    public static void maxProduct(int arr[]){
        int n = arr.length;
        long maxProduct = Integer.MIN_VALUE;
        long leftToRight =1;
        long rightToLeft =1;
        for(int i=0;i<n;i++){
            if(leftToRight==0)leftToRight=1;
            if(rightToLeft==0)rightToLeft=1;

            leftToRight *= arr[i];
            rightToLeft *= arr[(n-1)-i];

            maxProduct = Math.max(maxProduct,Math.max(leftToRight, rightToLeft));
        }
        System.out.println("Maximum product of continous subarray :: "+maxProduct);
    }
    public static void main(String args[]){
        int arr[]={ 1, -2, -3,100, 0, 7, -8, -2 };
        maxProduct(arr);
    }
}
