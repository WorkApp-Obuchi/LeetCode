package LeetCode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 文字列の配列の中から最も長い共通プレフィックス文字列を見つける関数を作成する

        // strsに値が入っていない場合には、空文字を返す
        if(strs == null || strs.length == 0) return "";
        // 最初の文字列を prefix として仮置きする
        String prefix = strs[0];
        // 配列の2番目以降の文字列と順番に比較する
        for(int i = 1; i < strs.length; i++) {
            String current = strs[i];

            int j = 0;
            int minLength = Math.min(prefix.length(), current.length());

            // 現在の文字列と prefix を 0 文字目から順に比較して一致する長さをカウント
            while(j < minLength && prefix.charAt(j) == current.charAt(j)) {
                j++;
            }
            // prefix を一致する部分までに短縮
            prefix = prefix.substring(0, j);

            // 途中で共通部分がなくなったら (prefix.isEmpty()) ループを終了
            if(prefix.isEmpty()) break;

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
