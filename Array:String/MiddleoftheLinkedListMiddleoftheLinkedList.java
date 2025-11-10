/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){ //fastリストを超えてないかつ次のノードが存在しない
            slow = slow.next; //１つ進める
            fast = fast.next.next; //２つ進める
        }
        return slow; //中央ノードから全てのノード値を返す
    }
}