class Solution {
    public int removeElement(int[] nums, int val) {
    int i = 0;
     for(int j =0;j < nums.length; j++){
        if(nums[j] != val){ //val比較
            nums[i] = nums[j]; //nums上書き
            i++; //配列次へ
        }
     }
     return i;
    }
}