/*
 * 1370. Increasing Decreasing String
 * 文字列を昇順・降順を交互に繰り返す形で並びかえてソートとする
 * @param s 入力文字列（小文字のみ）
 * @return 昇順・降順を繰り返したソート済文字列
 */

public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] count = new int[26]; //文字a~zの出現回数を数える
        for(int i = 0;i < s.length(); i++){
            char c = s.charAt(i); //文字を一つずつ取り出す
            int index = c - 'a'; //0~25に変換する
            count[index]++; //回数を数える
        }
        //結果を格納していく入れ物
        StringBuilder sb = new StringBuilder();
        //全ての文字を使い切るまで繰り返す
        while(sb.length() < s.length()){
            //昇順で文字を取っていく
            for(int i = 0; i < 26; i++){
                if(count[i]> 0){
                    sb.append((char)('a' + i));
                    count[i]--;
                }
            }
            //降順で文字を取っていく
            for(int i = 25;i >= 0; i--){
                if(count[i] > 0){
                sb.append((char)('a' + i));
                count[i]--;
                }
            }
        }
        return sb.toString();
    }
    //実行用main
    public static void main(String[] args) {
        IncreasingDecreasingString ids = new IncreasingDecreasingString();

        // ---- Example 1 ----
        String s1 = "aaaabbbbcccc";
        String result1 = ids.sortString(s1);
        System.out.println("Input: " + s1);
        System.out.println("Output: " + result1);

        // ---- Example 2 ----
        String s2 = "rat";
        String result2 = ids.sortString(s2);
        System.out.println("Input: " + s2);
        System.out.println("Output: " + result2);
    }
}
