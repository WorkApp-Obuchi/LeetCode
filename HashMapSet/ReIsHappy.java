package LeetCode.HashMapSet;

import java.util.HashSet;
import java.util.Set;

public class ReIsHappy {
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while(n != 1) {
            // すでに出ている数値については繰り返しループであるため繰り返さない
            if(!set.add(n)) {
                return false;
            }
            int sum = 0;
            while(n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        ReIsHappy solution = new ReIsHappy();

        // testcase1
        // input : n = 19
        // output : true
         int n1 = 19;
         System.out.println(solution.isHappy(n1));

        // testcase2
        // input : n = 2
        // output : false
        int n2 = 2;
        System.out.println(solution.isHappy(n2));
    }
}
