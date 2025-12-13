package LeetCode.ArrayString;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null) return false;

        // 空文字の場合はtrue
        if(s.isEmpty()) return true;

        // 全ての大文字を小文字に変換
        String sl = s.toLowerCase();
        // 英数字以外の文字を全て削除
        sl = sl.replaceAll("[^a-z0-9]", "");
        System.out.println("処理後の文字列: " + sl);

        int left = 0;
        int right = sl.length() - 1;

        while(left < right) {
            if(sl.charAt(left) != sl.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome solution = new IsPalindrome();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        // 結果も出力
        System.out.println("Test 1: \"" + s1 + "\"");
        System.out.println("結果: " + solution.isPalindrome(s1) + "\n");

        System.out.println("Test 2: \"" + s2 + "\"");
        System.out.println("結果: " + solution.isPalindrome(s2) + "\n");

        System.out.println("Test 3: \"" + s3 + "\"");
        System.out.println("結果: " + solution.isPalindrome(s3) + "\n");
    }
}
