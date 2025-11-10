package LeetCode;

import java.util.Deque;
import java.util.ArrayDeque;

public class ValidParentheses {
    public boolean isValid(String s) {
        // 引数チェック
        if(s == null || s.isEmpty()) return false;

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                deque.push(c);
            } else {
                if(deque.isEmpty()) return false;

                char top = deque.pop();

                if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();

        String s = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";
        String s5 = "([)]";

        System.out.println("() :" +  v.isValid(s));
        System.out.println("()[]{} :" +  v.isValid(s2));
        System.out.println("(] :" +  v.isValid(s3));
        System.out.println("([]) :" +  v.isValid(s4));
        System.out.println("([)] :" +  v.isValid(s5));
    }
}
