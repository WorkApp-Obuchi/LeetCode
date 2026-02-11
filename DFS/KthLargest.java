package LeetCode.DFS;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }
    }
    // 要素を追加して、k番目に大きい値を返す
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

}
