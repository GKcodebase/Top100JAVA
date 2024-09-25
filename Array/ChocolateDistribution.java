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
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;
 
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
