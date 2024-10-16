package LinkedList;

public class LongestSubStringWithOutRepetition {

    public static int getSubString(String s){
        int l = s.length();
        int res = 0;
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }
        int start = 0;

        // Move end of current window
        for (int end = 0; end < l; end++) {
          
            start = Math.max(start, lastIndex[s.charAt(end)] + 1);

            // Update result if we get a larger window
            res = Math.max(res, end - start + 1);

            // Update last index of s[end]
            lastIndex[s.charAt(end)] = end;
        }
        return res;
    }
    public static void main(String args[]){
        String s = "geeksforgeeks";
        System.out.println(getSubString(s));
    }
}
