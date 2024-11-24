package String;

import java.util.HashMap;

public class SmallestWindow {

    public static String smallestWindow(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();

        if (len1 < len2)
            return null;

        HashMap<Character, Integer> hashP = new HashMap<>();
        HashMap<Character, Integer> hashS = new HashMap<>();

        for (int i = 0; i < len2; i++) {
            hashP.put(p.charAt(i), hashP.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start = 0, start_indx = -1, min_len = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < len1; i++) {
            char currentChar = s.charAt(i);
            hashS.put(currentChar, hashS.getOrDefault(currentChar, 0) + 1);

            if (hashP.containsKey(currentChar) && hashS.get(currentChar) <= hashP.get(currentChar))
                count++;

            if (count == len2) {
                while (hashS.getOrDefault(s.charAt(start), 0) > hashP.getOrDefault(s.charAt(start), 0)
                        || !hashP.containsKey(s.charAt(start))) {
                    if (hashS.get(s.charAt(start)) > hashP.getOrDefault(s.charAt(start), 0)) {
                        hashS.put(s.charAt(start), hashS.get(s.charAt(start)) - 1);
                    }
                    start++;
                }
                int len = i - start + 1;
                if (min_len > len) {
                    min_len = len;
                    start_indx = start;
                }
            }
        }
        if (start_indx == -1)
            return "-1";

        return s.substring(start_indx, start_indx + min_len);
    }

    public static void main(String args[]) {
        String s = "timetopractice";
        String p = "toc";

        String result = smallestWindow(s, p);
        System.out.println(result);
    }
}
