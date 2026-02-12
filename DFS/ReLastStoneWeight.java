package LeetCode.DFS;

import java.util.Collections;
import java.util.PriorityQueue;

public class ReLastStoneWeight {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();

            if(first != second) {
                pq.offer(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
