class Solution {
    public void reverseString(char[] s) {
        int left = 0; //最初のインデックス
        int right = s.length - 1; //最後のインデックス

        while(left<right){
            char temp = s[left]; //最初のインデックスのな中身をtempへ
            s[left] = s[right]; //左端←右端 
            s[right] = temp ;  //右端←左端
            left++ ;
            right--;
        }
    }
}
