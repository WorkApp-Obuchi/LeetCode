package LeetCode.DFS;

public class ReIsUgly {
    public boolean isUgly(int n) {
        if(n <= 0) return false;

        // 2,3,5で割れるだけ破り続けて、最後に１が残れば、Ugly Number

        // Ugly Number : 素因数が2,3,5のみの正の整数のこと
        while(n % 2 == 0) n /= 2;
        while(n % 3 == 0) n /= 3;
        while(n % 5 == 0) n /= 5;

        return n == 1;
    }
}
