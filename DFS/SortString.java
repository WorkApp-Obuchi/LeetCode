package LeetCode.DFS;

public class SortString {
    public String sortString(String s) {
        // ①カウント配列を作成する
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // ②ルールに従って文字列を構築
        StringBuilder result = new StringBuilder();

        while(result.length() < s.length()){
            // 昇順走査a→z
            for(int i = 0; i < 26; i++) {
                if(count[i] > 0) {
                    result.append((char) ('a' + i));
                    count[i]--;
                }
            }
            // 昇順走査z→a
            for(int i = 25; i >= 0; i--) {
                if(count[i] > 0) {
                    result.append((char) ('a' + i));
                    count[i]--;
                }
            }
        }
        return result.toString();
    }
}
