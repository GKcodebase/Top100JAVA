package Array;
import java.util.*;
public class PairWithGivenSum {
    
    //Using HashSet Solution -> O(n) , O(n)
    public static void getPair(int[] arr, int target){
        HashSet set = new HashSet<>();
        for(int i:arr){
            set.add(i);
            if(set.contains(target-i)){
                System.out.println("Pairs are :: "+i+" , "+(target-i));
                return;
            }
        }
        System.out.println("No pairs found."); 
    }

    //Using sorting and two pointer based solution O(n*logn) and O(1)
    public static void getPairTwoPointer(int arr[],int target){
        Arrays.sort(arr);
        int left =0, right = arr.length-1;
        while(left<right){
            int sum = arr[right]+arr[left];
            if(target==sum){
                System.out.println("Pairs are :: "+arr[left]+" , "+arr[right]);
                return;
            }
            else if(sum<target){
                left++;
            }else
                right--;
        }
        System.out.println("No pairs found."); 
    }

    public static void main(String args[]){
        int arr[] = {0,-9,11,12,2,38,4,5,6,19,20,34};
        getPair(arr, 34);
        getPairTwoPointer(arr, 9);

    }
}
