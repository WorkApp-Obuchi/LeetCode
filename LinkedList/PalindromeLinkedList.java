/*
 * 234. Palindrome Linked List
 * ノードを使用した回文問題
 *@param リストノード
 @return true　か false
 */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

public class PalindromeLinkedList {
  public static boolean isPalindrome(ListNode head) {
        ListNode slow = head; //一つ進むノード作成
        ListNode fast = head; //二つ進むノード作成
        StringBuilder sb = new StringBuilder();
        //真ん中を探したい（真ん中になるのはslowslow）
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //後半を反転
        ListNode secondHalf = reverse(slow); //slowとその先を反転
        ListNode first = head; //先頭から
        //反転させたものと先頭からの物を比較
        while(secondHalf != null){
            if(secondHalf.val != first.val){ //valをつけて値そのものを比較
                return false;
            }
            first = first.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next; //次のノードを記憶する
            head.next = prev; //ノードの向きを反転させる
            prev = head; //現在ノードに更新
            head = next; //次に進める
        }
        return prev; //反転したノードを返す
    }
      public static void main(String[] args) {
        PalindromeLinkedList sol = new PalindromeLinkedList();

        // Example 1: head = [1,2,2,1]
        ListNode ex1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println("Example 1: " + sol.isPalindrome(ex1)); // true

        // Example 2: head = [1,2]
        ListNode ex2 = new ListNode(1, new ListNode(2));
        System.out.println("Example 2: " + sol.isPalindrome(ex2)); // false
    }
}
