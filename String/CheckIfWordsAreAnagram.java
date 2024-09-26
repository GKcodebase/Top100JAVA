package String;

public class CheckIfWordsAreAnagram {
    public static void checkAnagram(String s1 , String s2){
        int hashCode =0;
        for(char c : s1.toCharArray()){
            hashCode += (int)c;
        }
        for(char c : s2.toCharArray()){
            hashCode -= (int)c;
        }
        if(hashCode != 0){
            System.out.println("Its not an anagram.");
            return;
        }
        System.out.println("Its an anagram.");
    }
    public static void main(String args[]){
        checkAnagram("cat","tac");
        checkAnagram("Dog", "Cat");
    }
}
