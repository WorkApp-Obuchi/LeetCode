class Solution {
    public int[] plusOne(int[] digits) {
        //配列の最後を指定
        for(int i = digits.length - 1; i >= 0 ;i--){
            if(digits[i] < 9){ //9より小さい場合処理
                digits[i]++ ;
                return digits;
            }else{ //９の場合は処理
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1] ; //元のdigitsより一つ多い配列を作成する。
        result[0] = 1 ;
        return result;
    }
}
