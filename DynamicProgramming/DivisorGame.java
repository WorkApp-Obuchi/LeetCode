/*
 * 1025. Divisor DivisorGame
 * Alice が勝てるかどうかを判定するメソッド
 * @param n ゲーム開始時の整数
 * @return Alice が勝てる場合 true、負ける場合 false
 */
public class DivisorGame {
    public static boolean divisorGame(int n) {
        //n が偶数なら true（勝ち）
        //n が奇数なら false（負け）
        return n % 2 == 0;
    }
    public static void main(String[] args) {

        // Example 1
        int n1 = 2;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + divisorGame(n1));
        System.out.println();

        // Example 2
        int n2 = 3;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + divisorGame(n2));
    }
}
