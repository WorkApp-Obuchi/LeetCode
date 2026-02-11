package LeetCode.DFS;

public class ReReSortString {
    public String sortString(String s) {

        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        while(result.length() < s.length()) {

            //昇順
            for(int i = 0; i < s.length(); i++) {
                if(count[i] > 0) {
                    result.append((char) ('a' + i));
                    count[i]--;
                }
            }
            //降順
            for(int i = 25; i > 0; i--) {
                if(count[i] > 0) {
                    result.append((char) (i + 1));
                    count[i]--;
                }
            }
        }
        return result.toString();
    }
}
