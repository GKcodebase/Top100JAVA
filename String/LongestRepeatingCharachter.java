package String;

public class LongestRepeatingCharachter {
    static void getCharachter(String s) {
        // aabecccccd
        int n = s.length();
        char temp = s.charAt(0);
        char longChar = s.charAt(0);
        int count = 1;
        int tempCount = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == temp) {
                tempCount++;
            } else {
                if (tempCount > count) {
                    count = tempCount;
                    longChar = temp;
                }
                temp = s.charAt(i);
                tempCount = 1;
            }
        }
        System.out.println("longets repeating char :: " + longChar + " with count :: " + count);
    }

    public static void main(String args[]) {
        String str = "cabbaaaabbcbbb";
        getCharachter(str);
    }
}
