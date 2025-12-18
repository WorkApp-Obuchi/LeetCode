import java.util.HashMap;
import java.util.Map;
/*
 * 290. Word Pattern
 * pattern の各文字と、文字列 s の各単語が1対1（双方向）で対応しているかを判定する。
 * @param pattern 文字の並び
 * @param s スペース区切りの単語
 * @return 対応が正しければtrue 矛盾があればfalse
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); //スペースで分割して単語配列にする
        if(pattern.length() != words.length) return false; //文字数と単語数が違う場合すぐにfalseを返す

        //pattern の文字 → 単語 の対応表
        Map<Character , String> charToWord = new HashMap<>();
        //単語 → pattern の文字の対応表
        Map<String , Character> wordToChar = new HashMap<>();
        //左から順番に確認
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i); //pattern 側の i 番目の文字
            String w = words[i]; //s 側の i 番目の単語
            //すでにこの文字 c が登録されているかの確認
            if(charToWord.containsKey(c)){
                //登録済みの単語と今回の単語が違えば矛盾
                if(!charToWord.get(c).equals(w)) return false;
            }else{
                //文字 c は初登場
                if(wordToChar.containsKey(w)) return false;
                // 双方向に対応関係を登録
                charToWord.put(c,w);
                wordToChar.put(w,c);
            }
        }
        // 最後まで矛盾がなければ true
        return true;
    }
    public static void main(String[] args) {

        WordPattern wordPattern = new WordPattern();

        // Example 1
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println("Example 1: " + wordPattern.wordPattern(pattern1, s1));
        // expected: true

        // Example 2
        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println("Example 2: " + wordPattern.wordPattern(pattern2, s2));
        // expected: false

        // Example 3
        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println("Example 3: " + wordPattern.wordPattern(pattern3, s3));
        // expected: false
    }
}
