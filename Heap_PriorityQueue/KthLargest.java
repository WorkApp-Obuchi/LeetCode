import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
 * 703. Kth Largest Element in a Stream
 * 数値が次々に追加される中で、常に「k番目に大きい値」を返す。
 */
public class KthLargest {
    //最小ヒープを作成
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    //何番目に大きい値を求めるか（k番目）
    private int k;

    /*
     * @param k 何番目に大きい値を求めるか
     * @param nums 初期状態で与えられる数値配列
     */
    public KthLargest(int k, int[] nums) {
        //kをフィールドに保存
        this.k = k ;
        for(int num :nums){
            add(num);
        }
    }
    /*
     *新しい値を追加し、現在の k 番目に大きい値を返す
     * @param val 追加する値
     * @return    現在の k 番目に大きい値
     */
    public int add(int val) {
        //ヒープに値を追加する
        pq.offer(val);
        //ヒープのサイズが k を超えた場合
        if(pq.size() > k){
        pq.poll(); //一番小さい値（k番目より小さい値）を削除する
     }
     //ヒープの先頭は「k番目に大きい値」
     return pq.peek();
    }
    //実行用main
    public static void main(String[] args) {
        // ===== Example 1 =====
        String[] commands1 = {
            "KthLargest", "add", "add", "add", "add", "add"
        };

        Object[] arguments1 = {
            new Object[]{3, new int[]{4, 5, 8, 2}},
            new Object[]{3},
            new Object[]{5},
            new Object[]{10},
            new Object[]{9},
            new Object[]{4}
        };

        // ===== Example 2 =====
        String[] commands2 = {
            "KthLargest", "add", "add", "add", "add"
        };

        Object[] arguments2 = {
            new Object[]{4, new int[]{7, 7, 7, 7, 8, 3}},
            new Object[]{2},
            new Object[]{10},
            new Object[]{9},
            new Object[]{9}
        };

        runTest(commands1, arguments1);
        runTest(commands2, arguments2);
    }
    /**
     * LeetCode風にコマンドを順番に実行する
     */
    private static void runTest(String[] commands, Object[] arguments) {

        List<Object> output = new ArrayList<>();
        KthLargest kth = null;

        for (int i = 0; i < commands.length; i++) {
            String cmd = commands[i];

            if (cmd.equals("KthLargest")) {
                Object[] args0 = (Object[]) arguments[i];
                int k = (int) args0[0];
                int[] nums = (int[]) args0[1];

                kth = new KthLargest(k, nums);
                output.add(null); // コンストラクタは null
            }
            else if (cmd.equals("add")) {
                int val = (int) ((Object[]) arguments[i])[0];
                output.add(kth.add(val));
            }
        }

        System.out.println(output);
    }
}
