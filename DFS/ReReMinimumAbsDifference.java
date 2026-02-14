package LeetCode.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ReReMinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return result;
    }
}
