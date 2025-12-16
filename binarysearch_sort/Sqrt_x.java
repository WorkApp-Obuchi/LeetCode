/*
 * 69. Sqrt(x)
 * 整数　x の平方根の整数部分を返す(二分探索)
 * @param x 非負整数
 * @return x の平方根の整数部分
 */
class Sqrt_x{
    public int mySqrt(int x) {
        int left = 1; // 探索範囲の左端
        int right = x ; //探索範囲の右端
        int ans = 0 ; //条件を満たした最新の正解候補の保存先

        while(left <= right){
            int mid = left + (right -left) / 2;
            // mid * mid ==x と同じ意味(オーバーフロー防止)
            if(mid == x / mid){
                return mid;
            // mid * mid <= x と同じ意味
            }else if(mid < x / mid){
                ans = mid ; //正解候補として保存
                left = mid + 1; //大きい値があるか右側を探索
            }else{
                right = mid - 1; //小さい値があるか左側を探索
            }
        }
        //平方根が整数じゃない場合、最後に条件を満たした値が答え
        return ans;
    }
    public static void main(String[] args) {
        Sqrt_x sol = new Sqrt_x();

        // Example 1
        int x1 = 4;
        int result1 = sol.mySqrt(x1);
        System.out.println("Input: x = " + x1);
        System.out.println("Output: " + result1);
        System.out.println();

        // Example 2
        int x2 = 8;
        int result2 = sol.mySqrt(x2);
        System.out.println("Input: x = " + x2);
        System.out.println("Output: " + result2);
    }
}
