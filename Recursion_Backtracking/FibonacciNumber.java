/*
 * 509. Fibonacci Number
 * フィボナッチ数を計算する
 * n 番目のフィボナッチ数を返す
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)
 * @param n フィボナッチ数列のインデックス（0以上）
 * @return n 番目のフィボナッチ数
 */
public class FibonacciNumber {
    public static int fib(int n) {
        //n が 0 の場合
        if(n == 0) return 0;
        //n が 1 の場合
        if(n == 1) return 1;

        int prev2 = 0; //F(0)
        int prev1 = 1; //F(1)

        for(int i = 2; i <= n; i++ ){
            int current = prev1 + prev2; //F(i)
            prev2 = prev1; //次のループ用
            prev1 = current;
        }

        return prev1; //F(n)
    }
    // 動作確認用 main
    public static void main(String[] args) {
        System.out.println("Example 1:");
        System.out.println("Input: n = 2");
        System.out.println("Output: " + fib(2)); // 1
        System.out.println();

        System.out.println("Example 2:");
        System.out.println("Input: n = 3");
        System.out.println("Output: " + fib(3)); // 2
        System.out.println();

        System.out.println("Example 3:");
        System.out.println("Input: n = 4");
        System.out.println("Output: " + fib(4)); // 3
        System.out.println();
    }
}
