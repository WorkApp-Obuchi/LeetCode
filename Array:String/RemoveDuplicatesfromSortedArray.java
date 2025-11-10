class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { //重複していなければ
                i++;
                nums[i] = nums[j]; //右側の値を一個左へ移動させている。
            }
        }
        return i + 1;
    }
}