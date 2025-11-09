package LeetCode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 文字列の配列の中から最も長い共通プレフィックス文字列を見つける関数を作成する
        if(strs == null || strs.length == 0) {
            throw new IllegalArgumentException("配列が空です。");
        }

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++) {
            String current = strs[i];

            int j = 0;
            int minLength = Math.min(prefix.length(), current.length());

            while(j < minLength && prefix.charAt(j) == current.charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);

            if(prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix cop = new LongestCommonPrefix();

        String[] strs = {"flower","flow","flight"};
        String result = cop.longestCommonPrefix(strs);
        System.out.println("result1:　" + result);

        String[] strs2 = {"dog","racecar","car"};
        String result2 = cop.longestCommonPrefix(strs2);
        System.out.println("result2:　" + result2);
    }
}
