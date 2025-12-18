import java.util.ArrayList;
import java.util.List;
/*
 * 401. Binary Watch
 * turnedOn 個の LED が点灯しているときに表示できるすべての時刻を返す
 * @param turnedOn 点灯しているLEDの個数
 * @return 時刻リスト("h:mm"形式)
 */
public class BinaryWatch{
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        // hour は 0 ～ 11
        for(int hour = 0; hour < 12; hour++){
            // minute は 0 ～ 59
            for(int minure = 0; minure < 60; minure++){
                // hour と minute の 1 ビットの数を合計
                int leds = Integer.bitCount(hour) + Integer.bitCount(minure);
                // LED の数が turnedOn と一致したら有効な時刻
                if(leds == turnedOn){
                     // 分は必ず 2 桁で表示
                    result.add(String.format("%d:%02d",hour,minure));
                }
            }
        }
        return result;
    }
    //実行用main
    public static void main(String[] args) {

        BinaryWatch watch = new BinaryWatch();

        // ---- Example 1 ----
        int turnedOn1 = 1;
        List<String> result1 = watch.readBinaryWatch(turnedOn1);

        System.out.println("Example 1:");
        System.out.println("Input: turnedOn = " + turnedOn1);
        System.out.println("Output: " + result1); //[0:01, 0:02, 0:04, 0:08, 0:16, 0:32, 1:00, 2:00, 4:00, 8:00]

        System.out.println();

        // ---- Example 2 ----
        int turnedOn2 = 9;
        List<String> result2 = watch.readBinaryWatch(turnedOn2);

        System.out.println("Example 2:");
        System.out.println("Input: turnedOn = " + turnedOn2);
        System.out.println("Output: " + result2); //[]
    }
}