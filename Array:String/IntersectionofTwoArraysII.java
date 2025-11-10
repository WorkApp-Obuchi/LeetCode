class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums1){ //nums1の数字のカウント
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        //一時格納先を作成
        ArrayList<Integer> result = new ArrayList<>();
        for(int num :nums2){ //nums2の各数字をチェック
            if(map.containsKey(num) && map.get(num)>0){
                result.add(num); //共通なら追加
                map.put(num,map.get(num)-1); //残りの回数を減らす
            }
        }

        int[] ans = new int[result.size()];
        for(int i = 0;i < result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;

    }
}