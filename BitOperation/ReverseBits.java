package BitOperation;

public class ReverseBits {
    public static void reverse(int n){
            int rev =0;
            while(n>0){
                rev<<=1;
                if((int)(n&1)==1){
                    rev^=1;
                }
                n>>=1;
            }
            System.out.println("Rversed Number :: "+rev);
    }
    public static void main(String args[]){
        int n = 11;
        reverse(11);
    }
}
