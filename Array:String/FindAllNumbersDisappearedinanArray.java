class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>(); //重複チェック
        List<Integer> result = new ArrayList<>(); //結果を格納するリスト作成

        for(int num : nums){ //numsの値を全て入れる
            set.add(num);
        }

        for(int i = 1;i <= nums.length;i++){ //出てきていない数字を探す。
            if(!set.contains(i)){ //setの中にiの数字がなければ
                result.add(i); //resultに追加
            }
        }
        return result;
    }
}