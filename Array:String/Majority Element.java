class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; //仮の候補
        int count = 0;//カウント(投票数)

        for(int num : nums){
            if(count == 0){
                //新しい候補
                candidate = num;
            }

            if(num == candidate){
                count++; //現在と候補が同じなら＋１
            }else {
                count--; // 現在と候補が違うなら−１
            }
        }
        return candidate;
    }
}