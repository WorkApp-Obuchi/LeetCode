class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); //後入れ先出し 

        for(char c :s.toCharArray()){ //文字列を一つずつ確認
            if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}