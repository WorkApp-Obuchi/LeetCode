package LeetCode;

public class ReverseWordsInaStringIII {
    public String reverseWords(String s) {
        if(s == null) return null;
        if(s.isEmpty()) return s;

        int front = 0;
        int end = 0;

        char[] c = s.toCharArray();

        while(end < s.length()) {
            if(c[end] == ' ') {
                reverse(c, front, end - 1);
                front = end + 1;
            } else if (end == s.length() - 1){
                reverse(c, front, end);
            }
            end++;
        }
        return new String(c);
    }
    private void reverse(char[] c, int front, int end) {
        while(front < end) {
            char tmp = c[front];
            c[front] = c[end];
            c[end] = tmp;
            front++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInaStringIII solution = new ReverseWordsInaStringIII();
        String s1 = "Let's take LeetCode contest";
        String s2 = "Mr Ding";

        String result1 = solution.reverseWords(s1);
        String result2 = solution.reverseWords(s2);

        System.out.println("testcase1(result1) : " + result1); // Output: "s'teL ekat edoCteeL tsetnoc"
        System.out.println("testcase1(result2) : " + result2); // Output: "rM gniD"
    }
}
