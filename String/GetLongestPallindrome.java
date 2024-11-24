package String;

public class GetLongestPallindrome {

    public static String getString(String s) {
        int n = s.length();
        if (n == 0)
            return "";
        int start = 0, maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int currLen = high - low + 1;
                    if (currLen > maxLength) {
                        start = low;
                        maxLength = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String args[]) {
        String s = "malayalam";
        System.out.println(getString(s));
    }
}
