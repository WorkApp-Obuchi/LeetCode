class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num :nums){
            result ^= num; //result = result ^ num (どちらか片方だけtrueならOK)
        }
        return result;
    }
}