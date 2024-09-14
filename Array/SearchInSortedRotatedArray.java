package Array;
import java.util.*;
public class SearchInSortedRotatedArray {
    public static void search(int arr[], int target){
        int n = arr.length;
        int left =0;int right =n-1;
        while(left<=right){
            int mid =left+(right-left)/2;
            //Case 1 
            if(arr[mid]==target){ System.out.println(target+" is present at :: "+mid);
            return;
        }
            //Case 2 :: If left side is sorted
            if(arr[left]<=arr[mid]){
                if(arr[mid]> target && arr[left]<=target){
                    right=mid-1;
                }else
                    left = mid+1;
            }
            //case 3: Right side is sorted
            else{
                if(arr[right]>=target && arr[mid]>target){
                    left=mid+1;
                }else
                    right=mid-1;
            }
        }
        System.out.println(target+" is Not present.");
    }
    public static void main(String args[]){
        int [] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int key1 = 0;
        search(arr1, key1);

        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        int key2 = 3;
        search(arr2, key2);
    }
}
