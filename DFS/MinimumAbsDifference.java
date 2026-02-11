package LeetCode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        //隣同士の差を見て、最小の差を見つけるx
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            minDiff = Math.min(diff, minDiff);
        }

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + i]));
            }
        }
        return result;
    }

}
