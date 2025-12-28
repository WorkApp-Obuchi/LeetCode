package LeetCode.HashMapSet;

import java.util.HashSet;
import java.util.Set;

public class JewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();

        for(char c : jewels.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for(char c : stones.toCharArray()) {
            if(set.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // testcase1
        String jewels = "aA";
        String stones = "aAAbbbb";

        // testcase2
        String jewels2 = "z";
        String stones2 = "ZZ";

        JewelsInStones solution = new JewelsInStones();
        int result = solution.numJewelsInStones(jewels, stones);
        System.out.println("Jewelがstonesに含まれる個数(小文字大文字を区別する) : " + result);

        int result2 = solution.numJewelsInStones(jewels2, stones2);
        System.out.println("Jewelがstonesに含まれる個数(小文字大文字を区別する) : " + result2);

    }
}
