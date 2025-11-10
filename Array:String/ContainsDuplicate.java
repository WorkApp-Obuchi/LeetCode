class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>(); //値のみの箱作成

        for(int num :nums){
            if(map.contains(num)){ //mapに値が存在していれば処理をする
                return true;
            }
            map.add(num);//mapに格納する
        }
        return false;//重複していなければ値を返す。
    }
}

