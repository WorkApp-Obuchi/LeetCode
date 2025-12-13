package LeetCode.HashMapSet;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
        public boolean isHappy(int n) {

            Set<Integer> set = new HashSet<>();

            while(n != 1) {
                // すでに出た数値でループを繰り返さない
                if(!set.add(n)) {
                    return false;
                }

                int sum = 0;
                while(n > 0){
                    // 数字を各行に分解し、ぞれぞれを2乗して合計する
                    int digit = n % 10;   // 1の位の値を取り出す. 347
                    sum += digit * digit; // 1の位の値を2乗して合計する
                    n = n / 10;           // 次の位へ
                }
                n = sum;  // sumは1回の「各行の計算」ごとに０に戻す必要がある
                //System.out.println(sum);
            }
            return true;
        }

    public static void main(String[] args) {
        int testcase1 = 19;
        int testcase2 = 2;

        IsHappy solution = new IsHappy();

        System.out.println(solution.isHappy(testcase1));
        System.out.println(solution.isHappy(testcase2));

    }
}
