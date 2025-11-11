package LeetCode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // 単語とスペースで構成される文字列 s が与えられた場合、文字列内の最後の単語の長さを返す

        // エッジケース処理：null または空文字列の場合は0を返す
        if(s == null || s.isEmpty()) return 0;

        // 最後の単語の長さをカウントする変数
        int length = 0;

        // 文字列の最後のインデックスから開始
        int lastIndex = s.length() - 1;

        // Phase 1: 末尾の空白文字をスキップ
        // 例: "Hello World   " の場合、最後の'd'の位置まで移動
        while(lastIndex >= 0 && s.charAt(lastIndex) == ' ') {
            lastIndex--;  // 空白がある限り、インデックスを左へ移動
        }

        // Phase 2: 最後の単語の文字数をカウント
        // 空白でない文字（＝単語の文字）を後ろから数える
        // 例: "World"の'd'から'W'まで逆順にカウント
        while(lastIndex >= 0 && s.charAt(lastIndex) != ' ') {
            length++;     // 単語の文字を見つけたらカウントを増やす
            lastIndex--;  // 次の文字（左側）へ移動
        }

        // カウントした最後の単語の長さを返す
        return length;
    }

    public static void main(String[] args) {
        // テスト用のインスタンスを作成
        LengthOfLastWord result = new LengthOfLastWord();

        // テストケース1: 通常の文字列（単語間に1つの空白）
        String s1 = "Hello World";

        // テストケース2: 複数の空白と末尾の空白を含む文字列
        String s2 = "   fly me   to   the moon  ";

        // テストケース3: 末尾に空白がない文字列
        String s3 = "luffy is still joyboy";

        // 各テストケースの実行と結果出力
        int num1 = result.lengthOfLastWord(s1);
        System.out.println("Hello World : " + num1);  // 期待値: 5 ("World"の長さ)

        int num2 = result.lengthOfLastWord(s2);
        System.out.println("   fly me   to   the moon  : " + num2);  // 期待値: 4 ("moon"の長さ)

        int num3 = result.lengthOfLastWord(s3);
        System.out.println("luffy is still joyboy : " + num3);  // 期待値: 6 ("joyboy"の長さ)
    }
}