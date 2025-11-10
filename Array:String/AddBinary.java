class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); //結果を逆順追加する。
         int i = a.length() -1 ; //aの文字数　
         int j = b.length() -1 ; //bの文字数
         int carry = 0 ; //繰り上がり 
         //a,b,carryが残っている場合は処理
         while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry; //計算の合計を一時的保存

            if(i >= 0){
                sum += a.charAt(i) - '0'; 
                i-- ;
            }

            if(j >= 0){
                sum += b.charAt(j) - '0';
                j-- ;
            }
            result.append(sum % 2); //今の桁の値
            carry = sum / 2 ; //次の繰り上がり
         }
         return result.reverse().toString();
    }
}