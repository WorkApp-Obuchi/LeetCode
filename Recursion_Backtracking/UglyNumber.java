/*
 * 263. Ugly Number
 * n が 2、3、5の素数のみで構成されているかどうかを判定する
 * @param n 判定したい整数
 * @return 2、3、5の素数のみなら true、そうでなければ false
 */

public class UglyNumber {
    public boolean isUgly(int n) {
        //整数の数しかないので、0以下はfalse
        if(n <= 0) return false;
        //nが２で割り切れる限り割っていく
        while(n % 2 == 0 ){
            n /= 2;
        }
        //nが3で割り切れる限り割っていく
        while(n % 3 == 0 ){
            n /= 3;
        }
        //nが5で割り切れる限り割っていく
        while( n % 5 == 0 ){
            n /= 5;
        }
        return n == 1;
    }
    //実行用main
    public static void main(String[] args) {
        UglyNumber UglyNumber = new UglyNumber();

        // Example 1
        int n1 = 6;
        System.out.println("Input: n = " + n1);
        System.out.println("n = " + n1 + " → " + UglyNumber.isUgly(n1)); //true
        System.out.println();

        // Example 2
        int n2 = 1;
        System.out.println("Input: n = " + n2);
        System.out.println("n = " + n2 + " → " + UglyNumber.isUgly(n2)); //true
        System.out.println();

        // Example 3
        int n3 = 14;
        System.out.println("Input: n = " + n3);
        System.out.println("n = " + n3 + " → " + UglyNumber.isUgly(n3)); //false
        System.out.println();
    }
}
