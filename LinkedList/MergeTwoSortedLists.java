/*
 * 21. Merge Two Sorted
 * 二つの昇順に並んだ結合リストを１つの昇順リストにマージする
 * 
 * @param list1　昇順にソートされた１つ目の連結リストのノード
 * @param list2　昇順にソートされた２つ目の連結リストのノード
 * @return ２つのリストをマージして得られる昇順リスト
 */

  //ListNode 定義
class ListNode { //同じファイルにおいて使えるようにpublicなし
    int val;
    ListNode next; //次のノードへの参照(結合リスト)

    ListNode() {} //引数なしのコンストラクタ　nextはnullで自動セットされる
    ListNode(int val) { this.val = val; } //ノードの値を指定して作ることができる
    ListNode(int val, ListNode next) { this.val = val; this.next = next; } //次のノードも繋げることができる。
}

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); //ダミーノード作成　-1がなくてもいい
        ListNode current = dummy; //今つなぐ位置

        while (list1 != null && list2 != null) {// 両方のリストを走査
            if (list1.val <= list2.val) { //valは「ノードが持つデータ(値)」
                current.next = list1; //current.nextにlist1のノードを繋げる
                list1 = list1.next; //listのポインタを進める
            } else {
                current.next = list2;// current.nextにlist2のノードを繋げる
                list2 = list2.next; //listのポインタを進める
            }
            current = current.next; //currentを次に次に進める
        }

        if (list1 != null){ // 片方が残っていたらつなげる
            current.next = list1; //list1の残り
        }else{
            current.next = list2; //list2の残り
        }
        return dummy.next; // ダミーノードの次からのノードを返す。
  }
}
  /*
 * テスト用でmainを作成
 */
// このクラスは実行用の main クラス
class Main {
    // リストを表示するヘルパー関数(連結リストの中身を見やすく出力するための便利関数)
    public static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) { //ノードの値を出力
            System.out.print(head.val); //次のノードへ移動
            head = head.next;
            if (head != null) System.out.print(", ");
        }
        System.out.println("]");
   }

    public static void main(String[] args) {
        MergeTwoSortedLists  merge = new MergeTwoSortedLists();

        // --- Example 1 ---
        ListNode list1_1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2_1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged1 = merge.mergeTwoLists(list1_1, list2_1);
        System.out.print("Example 1 Output: ");
        printList(merged1); // [1, 1, 2, 3, 4, 4]

        // --- Example 2 ---
        ListNode list1_2 = null;
        ListNode list2_2 = null;
        ListNode merged2 = merge.mergeTwoLists(list1_2, list2_2);
        System.out.print("Example 2 Output: ");
        printList(merged2); // []

        // --- Example 3 ---
        ListNode list1_3 = null;
        ListNode list2_3 = new ListNode(0);
        ListNode merged3 = merge.mergeTwoLists(list1_3, list2_3);
        System.out.print("Example 3 Output: ");
        printList(merged3); // [0]
  }
}