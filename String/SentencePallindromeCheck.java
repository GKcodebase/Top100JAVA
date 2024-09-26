package String;

public class SentencePallindromeCheck {
    public static void checkIfPalindrome(String s){
        int l=s.length();
        int i=0,j=l-1;
        s=s.toLowerCase();
        while(i<=j){
            if(!Character.isLetter(s.charAt(i))){
                i++;
            }
            if(!Character.isLetter(s.charAt(j))){
                j--;
            }
            if(s.charAt(i) != s.charAt(j)){
                System.out.println("Not Palindrome "+i+" "+j);
                return;
            }else{
                i++;j--;
            }

        }
        System.out.println("Palindrome");

    }
    public static void main(String args[]){
        checkIfPalindrome("Too hot to hoot.");
    }
}
