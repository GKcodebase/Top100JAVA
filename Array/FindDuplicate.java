package Array;
import java.util.*;
public class FindDuplicate {

    //Using Hashset O(n) , O(n)
    public static void findDupliacte(int arr[]){
        HashSet set = new HashSet<>();
        for(int i : arr){
            if(set.contains(i)){
                System.out.println(i);
            }else{
                set.add(i);
            }
        }
    }
    //Using index = arr[i]%n , arr[index] +=n , find arr[i]/n>=2 , i is diplicate
    // O(1) space and O(n) time;
    //Only workes in sorted case
    public static void getDupliacteMath(int arr[]){
        int n = arr.length;
        for( int i:arr){
            int index = i%n;
            arr[index] += n;
        }
        for(int i=0;i<n;i++){
            if(arr[i]/n>=2){
                System.out.println(i);
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,3,4,5,6,6,7};
        getDupliacteMath(arr);
    }
}
