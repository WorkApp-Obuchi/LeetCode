/*
 * 231. Power of Two
 * n が 2 のべき乗かどうかを判定する
 * @param n 判定したい整数
 * @return 2のべき乗なら true、そうでなければ false
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        //２のべき乗は整数の数しかないので、0以下はfalse
        if(n <= 0) return false;
        //nが２で割り切れる限り割っていく
        while(n % 2 == 0 ){
            n /= 2; //n = n / 2
        }
        //最後１になれば2のべき乗
        return n == 1;
    }
    //実行用main
    public static void main(String[] args) {
        // Example 1
        int n1 = 1;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + isPowerOfTwo(n1)); //true
        System.out.println();

        // Example 2
        int n2 = 16;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + isPowerOfTwo(n2)); //true
        System.out.println();

        // Example 3
        int n3 = 3;
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + isPowerOfTwo(n3)); //false
        System.out.println();
    }
}
