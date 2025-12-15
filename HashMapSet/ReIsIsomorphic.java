package LeetCode.HashMapSet;

import java.util.HashMap;
import java.util.Map;

public class ReIsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mapST.containsKey(c1)) {
                if(mapST.get(c1) != c2) return false;
            } else {
                mapST.put(c1, c2);
            }

            if(mapTS.containsKey(c2)) {
                if(mapTS.get(c2) != c1) return false;
            } else {
                mapTS.put(c2, c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // testcase1
        String s1 = "egg";
        String t1 = "add";

        // testcase2
        String s2 = "foo";
        String t2 = "bar";

        // testcase3
        String s3 = "paper";
        String t3 = "title";

        ReIsIsomorphic solution = new ReIsIsomorphic();
        System.out.println("testcase1 : " + solution.isIsomorphic(s1, t1)); // true
        System.out.println("testcase2 : " + solution.isIsomorphic(s2, t2)); // false
        System.out.println("testcase3 : " + solution.isIsomorphic(s3, t3)); // true
    }
}
