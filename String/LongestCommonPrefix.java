package String;

import java.util.Arrays;

public class LongestCommonPrefix {
    static String getLingestPrefix(String[] arr) {
        Arrays.sort(arr);
        String f = arr[0];
        String l = arr[arr.length - 1];
        int minLength = Math.min(f.length(), l.length());

        int i = 0;
        while (i < minLength &&
                f.charAt(i) == l.charAt(i))
            i++;
        return f.substring(0, i);
    }

    public static void main(String args[]) {
        String[] arr = { "zxy", "zxyjjjh",
                "zxyjjv", "zxaa" };
        System.out.println(getLingestPrefix(arr));
    }
}
