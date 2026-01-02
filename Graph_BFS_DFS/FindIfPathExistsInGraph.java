import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 1971. Find if Path Exists in Graph
 * source から destination へ、辺をたどって到達できるかどうかを判定する
 *
 * @param n             ノード数
 * @param edges         辺の情報（無向グラフ）
 * @param source        スタートノード
 * @param destination   ゴールノード
 * @return 到達可能なら true、そうでなければ false
 */
public class FindIfPathExistsInGraph{
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // graph.get(i) : ノード i から直接行けるノードの一覧
        List<List<Integer>> graph = new ArrayList<>();
        // ノード数分のリストを用意
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        // edges から無向グラフを構築
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]); // a → b
            graph.get(e[1]).add(e[0]); // b → a
        }
        // 訪問済みノードを管理
        boolean[] visited = new boolean[n];
        // BFS 用のキュー
        Queue<Integer> queue = new LinkedList<>();
        // スタートノードをキューに入れる
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            // キューから現在のノードを取り出す
            int current = queue.poll();
            // ゴールに到達したら true
            if (current == destination){
                return true;
            }
            // 現在のノードから行ける隣接ノードを探索
            for (int next : graph.get(current)) {
                // まだ訪問していないノードのみキューに追加
                if (!visited[next]) {
                    visited[next] = true;// キューに入れた時点で訪問済みにする
                    queue.offer(next);
                }
            }
        }
        // すべて探索しても destination に到達できなかった場合
        return false;
    }
    //実行用main
    public static void main(String[] args) {

        FindIfPathExistsInGraph solution = new FindIfPathExistsInGraph();

        // ===== Example 1 =====
        int n1 = 3;
        int[][] edges1 = {
                {0, 1},
                {1, 2},
                {2, 0}
        };
        int source1 = 0;
        int destination1 = 2;

        boolean result1 = solution.validPath(n1, edges1, source1, destination1);
        System.out.println("Example 1 Result: " + result1); // true


        // ===== Example 2 =====
        int n2 = 6;
        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        int source2 = 0;
        int destination2 = 5;

        boolean result2 = solution.validPath(n2, edges2, source2, destination2);
        System.out.println("Example 2 Result: " + result2); // false
    }
}