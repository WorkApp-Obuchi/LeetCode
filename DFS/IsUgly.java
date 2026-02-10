package LeetCode.DFS;

public class IsUgly {
    public boolean isUgly(int n) {
        if(n <= 0) return false;

        // 2,3,5で割れるだけ破り続けて、最後に１が残ればUply Number !
        while(n % 2 == 0) n /= 2;
        while(n % 3 == 0) n /= 3;
        while(n % 5 == 0) n /= 5;

        // 最後に１が残ればUgly Number
        return n == 1;
    }
}
