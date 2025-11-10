class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        //基準の文字列
        for(int i = 0;i < strs[0].length(); i++){
            char c = strs[0].charAt(i); //基準の文字列
            //他の文字列と比較
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() ||strs[j].charAt(i) != c ){ //i >= strs[j].length()　←例外の可能性があるため記載
                    return strs[0].substring(0,i); //共通部分を返す
                }
            }
        }
        return strs[0]; //全部一致している場合
    }
}