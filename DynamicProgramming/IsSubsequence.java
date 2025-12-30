/*
 * 392. Is Subsequence
 * 文字列 s が、文字列 t の部分列（subsequence）かどうかを判定するクラス。
 * @param s 判定対象となる短い文字列
 * @param t 探索対象となる長い文字列
 * @return s が t の部分列であれば true、そうでなければ false
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        //sの文字を指すポインタ
        int i =  0 ;
        //tの文字を左から順に確認していく
        for(int j = 0;j < t.length(); j++){
             //sのすべての文字を見つけ終わったら終了
            if(i == s.length()){
                return true;
            }
            //s[i] と t[j] が一致したら
            if (s.charAt(i) == t.charAt(j)) {
                //sの次の文字を探す
                i++;
            }
        }
        //ループ終了後、sを全部見つけられたか判定
        return i == s.length();
    }
    public static void main(String[] args) {

        // Example 1
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println(isSubsequence(s1, t1)); // true
        System.out.println();

        // Example 2
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println(isSubsequence(s2, t2)); // false
        System.out.println();
    }
}
