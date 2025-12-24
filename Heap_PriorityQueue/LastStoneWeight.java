import java.util.Collections;
import java.util.PriorityQueue;
/*
 * 1046. Last Stone Weight
 * 石をぶつけ続けて、最後に残る石の重さを返す
 * @param stones 石の重さが入った配列
 * @return 最後に残る石の重さ（なければ 0）
 */
public class LastStoneWeight{
    public int lastStoneWeight(int[] stones) {
        //最大ヒープを作成
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //stones 配列の中身を全てヒープに入れる
        for(int stone :stones){
            pq.offer(stone);
        }
        //石が2個以上ある場合は続ける
        while(pq.size() > 1){
            int first = pq.poll(); //一番目に重い石
            int second = pq.poll(); //二番目に重い石
            //重さが違う場所だけ差分を戻す
            if(first != second){
                pq.offer(first - second);
            }
        }
        //石が一つも残ってない場合
        if(pq.isEmpty()){
            return 0;
        }
        //最後に残った石の重さ
        return pq.poll();
    }
    //実行用main
    public static void main(String[] args) {

        LastStoneWeight LastStoneWeight = new LastStoneWeight();

        // Example 1
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int result1 = LastStoneWeight.lastStoneWeight(stones1);
        System.out.println("Example 1 Output: " + result1); // 1
        System.out.println();

        // Example 2
        int[] stones2 = {1};
        int result2 = LastStoneWeight.lastStoneWeight(stones2);
        System.out.println("Example 2 Output: " + result2); // 1
        System.out.println();
    }
}