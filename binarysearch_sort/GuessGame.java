/*
 * Guess Number Higher or Lower 用の共通クラス。
 * 正解の数を内部的に保持する
 */

public class GuessGame {
    /*
     * 正解の数を設定するコンストラクタ
     * @param pick 正解となる数値
     */
    private int pick;
    public GuessGame(int pick) {
        this.pick = pick;
    }
    /*
     * 推測した数と正解の数を比較する。
     * @param num 推測した数
     * @return 0:正解、1:推測より大きい、-1:推測より小さい
     */
    public int guess(int num) {
        //正解と一致した場合
        if (num == pick) return 0; //正解
        //予想した数が正解より大きい場合
        if (num > pick) return -1; //大きい
        //予想した数が正解より小さい場合
        return 1; //小さい
    }
}
