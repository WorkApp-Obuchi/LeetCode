package LeetCode.DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReFindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        if(score == null) return new String[0];

        int n = score.length;
        String[] result = new String[n];

        // ①スコア：元の位置
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        // ②スコアを降順にソート
        int[] sorted = score.clone();
        Arrays.sort(sorted);

        // 順位をつけて元の位置に入れる
        for(int i = 0; i < n; i++) {
            int rank = n - 1 - i;
            int originalIndex = map.get(sorted[rank]);

            result[originalIndex] = switch(i) {
                case 0 -> "Gold Medal";
                case 1 -> "Silver Medal";
                case 2 -> "Bronze Medal";
                default -> String.valueOf(i + 1);
            };
        }
        return result;
    }
}
