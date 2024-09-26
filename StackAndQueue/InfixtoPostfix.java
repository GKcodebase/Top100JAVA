package StackAndQueue;
import java.util.*;
public class InfixtoPostfix {
    static char associativity(char c) {
        if (c == '^')
            return 'R';
        return 'L'; // Default to left-associative
    }
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
    public static void getCoversion(String s){
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if((c>='a' && c<='z')|| (c>='A'&&c<='Z')||(c>='0'&&c<='9'))
                result.append(c);
            else if(c=='(')
                stack.push(c);
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && (prec(c)<prec(stack.peek()) || prec(c)==prec(stack.peek())&& associativity(c) == 'L')){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result);
    }
    public static void main(String args[]){
        String exp = "a+b*(c^d-e)^(f+g*h)-i";

        getCoversion(exp);  
    }
}
