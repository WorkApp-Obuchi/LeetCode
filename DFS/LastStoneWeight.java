package LeetCode.DFS;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones == null) return 0;

        // 最大ヒープを作る
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            pq.offer(stone);
        }
        // 石が2個以上ある時、ぶつけ続ける。
        while(pq.size() >= 2) {
            int first = pq.poll();// 一番重い石
            int second = pq.poll(); // 2番目に重い石

            if(first != second) {
                pq.offer(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
