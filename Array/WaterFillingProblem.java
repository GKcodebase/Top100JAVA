package Array;

public class WaterFillingProblem {
    public static int maxWater(int[] arr){
        int l=0;
        int r = arr.length-1;
        int maxWater=0;
        while(l<r){
            maxWater=Math.max(maxWater,Math.min(arr[l],arr[r])*(r-l));
            if(arr[l]<arr[r])
                l++;
            else    
                r--;
        }
        return maxWater;
    }
    public static void main(String args[]){
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};
     
        System.out.print( maxWater(a)+"\n" );
     
        System.out.print( maxWater(b) );
    }
}
