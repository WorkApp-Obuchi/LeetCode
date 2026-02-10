package LeetCode.DFS;

public class ReCountBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            //result[i] = Integer.bitCount(i);
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
