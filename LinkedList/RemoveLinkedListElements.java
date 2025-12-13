/*
 *　203. Remove Linked List Elements
 * 単方向リンクリストから、指定した値 val を持つノードをすべて削除する問題。
 *@param head リストの先頭ノード
 @param val 削除したい値
 @return val を持つノードをすべて削除した後のリストの先頭ノード
 */

public class RemoveLinkedListElements {
  public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0); //先頭が削除されても大丈夫なように作成
        dummy.next = head;
        ListNode current = dummy;

        while(current.next != null){
            if(current.next.val == val){
                //削除(スキップ)
                current.next = current.next.next;
            }else{
                //削除しないなら次へ
                current = current.next;
            }
        }
        return dummy.next;
    }

    // リストを配列形式で表示するメソッド
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }
        System.out.println("]");
    }

    // main
    public static void main(String[] args) {
        // Example 1: [1,2,6,3,4,5,6], val = 6
                ListNode ex1 = new ListNode(1,
                            new ListNode(2,new ListNode(6,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6)))))));
        ListNode res1 = removeElements(ex1, 6);
        System.out.print("Example 1 Output: ");
        printList(res1);

        // Example 2: [], val = 1
        ListNode ex2 = null;
        ListNode res2 = removeElements(ex2, 1);
        System.out.print("Example 2 Output: ");
        printList(res2);

        // Example 3: [7,7,7,7], val = 7
        ListNode ex3 = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        ListNode res3 = removeElements(ex3, 7);
        System.out.print("Example 3 Output: ");
        printList(res3);
    }
}