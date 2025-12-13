package LeetCode.ArrayString;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.isEmpty() || t.isEmpty()) return false;
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for(char c1 : s.toCharArray()) {
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }

        for(char c2 : t.toCharArray()) {
            if(!map.containsKey(c2)) {
                return false;
            }
                map.put(c2, map.get(c2) - 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 =  "anagram";
        String t1 = "nagaram";

        String s2 =  "rat";
        String t2 = "car";

        ValidAnagram solution = new ValidAnagram();
        boolean result = solution.isAnagram(s1, t1);
        boolean result2 = solution.isAnagram(s2, t2);

        System.out.println("anagram : " + result);
        System.out.println("rat : " + result2);
    }
}
