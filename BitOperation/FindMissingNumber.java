package BitOperation;

public class FindMissingNumber {


    public static void getMissingNumber(int n, int arr[]){
        int xor1 =0 , xor2=0;
        for(int i : arr){
            xor1^=i;
        }
        for(int i=1;i<=n;i++){
            xor2^=i;
        }
        System.out.println("Missing number is :: " + (xor1^xor2));
    }
    public static void main(String args[]){
        int[] arr = { 1, 2, 3,6,7,8,10,9,4 };
        int n = 10;
        getMissingNumber(n,arr);
    }
}
