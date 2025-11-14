  /*
   * 83. Remove Duplicates from Sorted List
   * ソート済み方向リストから重複を取り除く問題。（in-placedで作成）
   *
   * @param 昇順のソートされたリスト
   * @retrun 重複のないリスト
   */
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

public class RemoveDuplicatesfromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head; //今のノード

        while(current != null && current.next != null){
            if(current.val == current.next.val){
                current.next = current.next.next; //次のノードが重複→スキップ（削除）
            }else{
                current = current.next; //重複ではない。
            }
        }
        return head;
    }

   // ★ リストを表示するメソッド
    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" → ");
            cur = cur.next;
        }
        System.out.println();
    }

    //テスト用でmain作成
    public static void main(String[] args) {

        // ===== Example 1: head = [1,1,2] =====
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);

        System.out.println("Before:");
        printList(head1);

        ListNode result1 = deleteDuplicates(head1);

        System.out.println("After:");
        printList(result1);


        // ===== Example 2: head = [1,1,2,3,3] =====
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);

        System.out.println("\nBefore:");
        printList(head2);

        ListNode result2 = deleteDuplicates(head2);

        System.out.println("After:");
        printList(result2);
      }
    }