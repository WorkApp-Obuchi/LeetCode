package LeetCode;

public class ReverseString {
    public void reverseString(char[] s) {
        if(s == null) return;

        int front = 0;
        int end = s.length - 1;

        while(front < end) {
            swap(s, front, end);
            front++;
            end--;
        }
    }
    private void swap(char[] s, int front, int end){
        char tmp = s[front];
        s[front] = s[end];
        s[end] = tmp;
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();

        char[] s1 = {'h','e','l','l','o'};
        char[] s2 = {'H','a','n','n','a','h'};

        System.out.println("Before : " + String.valueOf(s1));
        solution.reverseString(s1);
        System.out.println("After : " + String.valueOf(s1));
        solution.reverseString(s1);
        System.out.println("Restore : " + String.valueOf(s1));

        System.out.println("Before : " + String.valueOf(s2));
        solution.reverseString(s2);
        System.out.println("After : " + String.valueOf(s2));
        solution.reverseString(s2);
        System.out.println("Restore : " + String.valueOf(s2));
    }

}
