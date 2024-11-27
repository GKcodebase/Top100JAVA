package StackAndQueue;

import java.util.Stack;

public class LongestParanthesisSubstring {
    static int maxLength(String s){
        Stack<Integer> st = new Stack<>();
        
        st.push(-1);
        int maxLength = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                st.push(i);
            else{
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                else{
                    maxLength = Math.max(maxLength, i-st.peek());
                }
            }
        }
        return maxLength;
    }
    public static void main(String args[]){
        String s = "((((()(((";
        System.out.println(maxLength(s));
    }
}
