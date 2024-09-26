package String;
import java.util.*;
public class AllAnagrams {

    private static int getHashCode(String s) {
        int hashCode = 0;
        for(char c: s.toCharArray()){
            hashCode+= (int)c;
        }
        return hashCode;
    }

    public static void printAllAnagramTogether(List<String> lists){
        int l = lists.size();
        HashMap<Integer,List<String>> hash = new HashMap<>();
        for(String s:lists){
            // Arrays.sort(temp);
            // int hashCode = new String(temp).hashCode();
            int hashCode = getHashCode(s);
            List<String> tempList = hash.getOrDefault(hashCode, new ArrayList<String>() {{ }});
            tempList.add(s);
            hash.put(hashCode,tempList );
        }
        for(List<String> list : hash.values()){
            for(String s: list){
                System.out.print(s+" ");
            }
            System.err.println(" ");
        }

    }

public static void main(String args[]){
    String wordArr[]
    = { "cat", "dog", "tac", "god", "act" };
    ArrayList<String> list = new ArrayList<>(Arrays.asList(wordArr));
    printAllAnagramTogether(list);
   }
}
