class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for(int i = 0;i <= rowIndex;i++){
            row.add(1); //右端に1を入れる

            for(int j = i - 1;j > 0;j--){
                row.set(j,row.get(j)+row.get(j-1)); //右端＋左端　をj番目に入れ込む
            }
        }
        return row;
    }
}