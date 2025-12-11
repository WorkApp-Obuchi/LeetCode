package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // input nums = [4,3,2,7,8,2,3,1]
        // output = [5,6]

        List<Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0) return result;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
    return result;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappeared solution = new FindAllNumbersDisappeared();

        int[] nums1 = {4,3,2,7,8,2,3,1};
        int[] nums2 = {1,1};

        List<Integer> answer1 = solution.findDisappearedNumbers(nums1);
        List<Integer> answer2 = solution.findDisappearedNumbers(nums2);

        System.out.println("answer1 : " + answer1); // output : [5,6]
        System.out.println("answer2 : " + answer2); // output : [2]
    }
}
