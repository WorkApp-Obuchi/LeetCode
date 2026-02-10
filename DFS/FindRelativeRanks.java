package LeetCode.DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        if(score == null) return new String[0];

        int n = score.length;
        String[] result = new String[n];

        // 1 スコア；元の位置
        // スコアとインデックスの対応を覚える
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        // 2 スコアを降順にソート
        int[] sorted = score.clone();
        Arrays.sort(sorted);

        // 3 大きい順に順位をつけて、元の位置に戻す
        for(int i = 0; i < n; i++) {
            int rank = n - 1 - i;
            // sorted   [3,4,8,9,10]
            // index(i)  0,1,2,3,4
            // original  4,3,2,1,0
            int originalIndex = map.get(sorted[rank]);

            // method1
//            if(i == 0) {
//                result[originalIndex] = "GoldMedal";
//            } else if (i == 1){
//                result[originalIndex] = "SilverMedal";
//            } else if (i == 2){
//                result[originalIndex] = "BronzeMedal";
//            } else {
//                result[originalIndex] = String.valueOf(i + 1);
//            }
            // method2
//            switch(i) {
//                case 0:
//                    result[originalIndex] = "GoldMedal";
//                    break;
//                case 1:
//                    result[originalIndex] = "SilverMedal";
//                    break;
//                case 2:
//                    result[originalIndex] = "BronzeMedal";
//                    break;
//                default:
//                    result[originalIndex] = String.valueOf(i + 1);
//                    break;
//            }
            // method3
            result[originalIndex] = switch(i) {
                case 0 -> "GoldMedal";
                case 1 -> "SilverMedal";
                case 2 -> "Bronze Medal";
                default -> String.valueOf(i + 1);
            };
        }
        return result;
    }
}
