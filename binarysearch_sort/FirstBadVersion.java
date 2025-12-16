/*
 * 278. First Bad Version
 * 1 〜 n の中から、最初に不正（bad）となった番号を二分探索で求めるクラス
 */
public class FirstBadVersion extends VersionControl{
    /*
     * コンストラクタ
     * @param but 最初のbat version
     */
    public FirstBadVersion(int bad) {
        super(bad); // 親のコンストラクタを明示的に呼ぶ
    }
    /*
     * 最初のbadとなたバージョンを返す
     * good → butの二分探索の境界線を探す
     * @param n バージョンの最大値
     * @return 最初のbut version
     */
    public int firstBadVersion(int n){
        int left = 1 ;
        int right = n ;

        while(left < right){
            int mid = left + (right - left) / 2;
            boolean but = isBadVersion(mid);
            if(but){
                //midは bad → 答えは左側（mid含む）
                right = mid ;
            }else{
                //midは good → 答えは右側
                left = mid + 1 ;
            }
        }
        // left == right が最初の bad
        return left ;
    }
    //実行用main
    public static void main(String[] args) {

        // Example 1
        int n1 = 5;
        int bad1 = 4;
        FirstBadVersion firstBad1 = new FirstBadVersion(bad1);
        System.out.println("Example 1 Output: " + firstBad1.firstBadVersion(n1));
        // 期待値: 4

        // Example 2
        int n2 = 1;
        int bad2 = 1;
        FirstBadVersion firstBad2 = new FirstBadVersion(bad2);
        System.out.println("Example 2 Output: " + firstBad2.firstBadVersion(n2));
        // 期待値: 1
    }
}
