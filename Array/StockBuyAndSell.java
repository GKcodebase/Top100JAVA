package Array;

public class StockBuyAndSell {
    
    // O(n) time and space O(1)
    public static int maxProfit(int arr[]){
        int minSoFar = arr[0];
        int res = 0;
        for(int i=1;i<arr.length;i++){
            minSoFar = Math.min(arr[i],minSoFar);
            res = Math.max(res, arr[i]-minSoFar);
        }
        return res;
    }
    public static void main(String args[]){
        int[] prices = {7, 10, 8, 3, 6, 9, 2};
        System.out.println(maxProfit(prices));
    }
}
