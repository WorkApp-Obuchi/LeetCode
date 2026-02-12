package LeetCode.DFS;

import java.util.PriorityQueue;

public class ReKthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    public ReKthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }
    }
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
