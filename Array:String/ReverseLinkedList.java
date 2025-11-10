/**
 * Definition for singly-linked list.　//ListNodeの定義を準備してくれている
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 逆むきリストの先頭
        ListNode curr = head; //現在のノード
        //ListNode型の変数はノードの参照を保持できる

        while(curr != null){
            ListNode nextTemp = curr.next; //次のノードを保存(後でcurr を次に進めるための一時保管)
            curr.next = prev; //curr が指しているノードの next（矢印先） を prev に変更する
            prev = curr; //prevを１つ進める
            curr = nextTemp; //currを一つ進める
        }
        return prev; //逆向きリストの新しい head
    }
}