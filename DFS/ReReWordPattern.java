package LeetCode.DFS;

import java.util.HashMap;
import java.util.Map;

public class ReReWordPattern {
    public boolean wordPattern(String pattern, String s) {
        // 単語配列を作成する
        String[] words = s.split(" ");

        // 最初の長さチェック
        if(pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // 文字→単語
            if(charToWord.containsKey(c)) {
                if(!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            // 単語→文字
            if(wordToChar.containsKey(word)) {
                if(wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }
        return true;
    }
}
