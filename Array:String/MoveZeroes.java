class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; //0以外を詰める値

        for(int num :nums){ 
            if(num != 0){ //1,３回目はスキップ
               nums[insertPos] = num;
               insertPos++ ;
            }
        }

        while (insertPos < nums.length){ //trueの間実行 2 < 5 2回実行される
            nums[insertPos] = 0;
            insertPos++ ;
        }
    }
}