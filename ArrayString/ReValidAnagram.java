package LeetCode.ArrayString;

import java.util.HashMap;
import java.util.Map;

public class ReValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : s.toCharArray()) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : t.toCharArray()) {
            if(!map.containsKey(num)) {
                return false;
            }
            map.put(num, map.getOrDefault(num, 0) - 1);
            // -1になってしまった場合の制御（例：s = 'aab', t = 'abb')
            if(map.get(num) < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 =  "anagram";
        String t1 = "nagaram";

        String s2 =  "rat";
        String t2 = "car";

        ReValidAnagram solution = new ReValidAnagram();
        boolean result = solution.isAnagram(s1, t1);
        boolean result2 = solution.isAnagram(s2, t2);

        System.out.println("anagram : " + result);
        System.out.println("rat : " + result2);
    }
}
