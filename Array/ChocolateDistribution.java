package Array;
import java.util.*;

public class ChocolateDistribution {

    public static int chocolateDistribution(int arr[],int m){
        if(arr.length==0||m==0)
            return 0;
        if(arr.length-1<m)
            return -1;

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int nextWindow = i+m-1;
            if(nextWindow>=arr.length)
                break;
            int diff = arr[nextWindow]-arr[i];
            min = Math.min(min, diff);
        }
        return min;

    }
    public static void main(String args[]){
        int arr[] = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        // 2,3,4,7,9,12,56
        // 4-2 =2, 7-3=4, 9-4=5, 12-7=5, 56-9=47
        
        // Calculate the result using the chocolateDistribution method
        int result = chocolateDistribution(arr, m);
 
        // Print the result or indicate an invalid input
        if (result != -1) {
            System.out.println("Minimum difference is " + result);
        } else {
            System.out.println("Invalid input");
        }
    }
}
