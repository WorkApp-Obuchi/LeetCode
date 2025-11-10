class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() -1 ;
        //末尾に空白がある場合に空白を消す
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        int length = 0;

        while(i >= 0 && s.charAt(i) != ' '){ //末尾から空白が見つかるまで処理
            length++ ;
            i--;
        }
        return length;
    }
}