package BitOperation;

public class NumberOfOneBits {

    public static void getBits(int n){
        int count =0;
        while(n>0){
            if(n%2==1)
                count++;
            n=n/2;
        }
        System.out.println("Count of bits in n :: "+count);
    }
    public static void main(String args[]){
        getBits(13);
    }
}
