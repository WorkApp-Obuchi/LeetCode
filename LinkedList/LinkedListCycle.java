/*
 * 141. Linked List Cycle
 * リストに循環があるか判定する。
 *@param 昇順にしたリストノード
 @return true　か false
 */

 
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class LinkedListCycle {
  public static boolean hasCycle(ListNode head) {
        ListNode slow = head; //一つ進むノード作成
        ListNode fast = head; //二つ進むノード作成

        while(fast != null && fast.next != null){
                slow = slow.next; //一つ進める
                fast = fast.next.next; //二つ進める

                if(slow == fast){
                    return true;
                }
        }
        return false;
    }

    //テスト用のmainメソッド
    public static void main(String[] args) {

    // ===== Example 1 =====
    ListNode n1 = new ListNode(3);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(0);
    ListNode n4 = new ListNode(-4);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n2; // pos = 1 → n4.next が n2 を指す

    System.out.println("Example 1: " + LinkedListCycle.hasCycle(n1)); // true

    // ===== Example 2 =====
    ListNode m1 = new ListNode(1);
    ListNode m2 = new ListNode(2);

    m1.next = m2;
    m2.next = m1; // pos = 0 → m2.next が m1 を指す

    System.out.println("Example 2: " + LinkedListCycle.hasCycle(m1)); // true
}
}
