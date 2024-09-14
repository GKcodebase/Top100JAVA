package Array;

public class ProductArrayExceptItself{
    
    public static int[] getSolution(int arr[]){
        int product = 1;
        int nonZeroProduct =1;
        for(int i:arr){
            if(i!=0)  
            nonZeroProduct*=i;
            product*=i;
        }
        for(int i=0;i<arr.length;i++){
            if(product!=0 && arr[i]!=0) 
             arr[i] = product/arr[i];
            else if(arr[i]==0)
             arr[i]=nonZeroProduct;
            else
             arr[i]=0;
            // arr[i] = product/arr[i];

        }
        return arr;
    }
    public static void main(String args[]){

        int arr[] = {2,4,6,8,10,1,-1,};
        arr = getSolution(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}