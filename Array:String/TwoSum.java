class Solution {
    public int[] twoSum(int[] nums, int target) {
        // キーと値の箱を作成
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<nums.length;i++){
            int diff = target - nums[i];  //targetから引けば次何を持ってこればtargetとイコールになるかわかる
            // diffがnumsの中にあるかどうかを確認する。
            if(map.containsKey(diff)){
                // 見つかった場合の処理
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[0]; //見つからなかったときの処理
    }
}