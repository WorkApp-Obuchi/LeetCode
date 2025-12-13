/*
 *　160. Intersection of Two Linked Lists
 * 2つの単方向リンクリストがどこで交差しているかを返す問題。
 *@param headA リストAの先頭ノード
 @param headB リストBの先頭ノード
 @return 最初に交差するノード（交差が無ければ null）
 */

public class IntersectionofTwoLinkedLists {
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != pB){
            //三項演算子を使用
            pA = (pA == null) ? headB : pA.next; //pAがnullならheadBに移動,nullならpA.nextに進む
            pB = (pB == null) ? headA : pB.next; //pBがnullならheadAに移動,nullならpB.nextに進む
        }
        return pA; //交差ノードor null
    }
     // 配列からリストを作るヘルパー
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int n : arr) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummy.next;
    }

    // LeetCode の skipA / skipB を再現して交差を作る
    private static void connectIntersection(ListNode headA, ListNode headB, int skipA, int skipB) {
        ListNode curA = headA;
        ListNode curB = headB;

        // A の skipA番目へ移動
        for (int i = 0; i < skipA; i++) {
            curA = curA.next;
        }

        // B の skipB番目へ移動
        for (int i = 0; i < skipB; i++) {
            curB = curB.next;
        }

        // B の skipB の次を A の skipA のノードそのものにつなぐ
        curB.next = curA;
    }

    public static void main(String[] args) {

        // ---------- Example 1 ----------
        int[] listA1 = {4,1,8,4,5};
        int[] listB1 = {5,6,1,8,4,5};
        int skipA1 = 2;
        int skipB1 = 3;

        ListNode headA1 = buildList(listA1);
        ListNode headB1 = buildList(listB1);
        connectIntersection(headA1, headB1, skipA1, skipB1);

        ListNode ans1 = getIntersectionNode(headA1, headB1);
        System.out.println("Example 1 → Intersected at: " + (ans1 != null ? ans1.val : "null"));


        // ---------- Example 2 ----------
        int[] listA2 = {1,9,1,2,4};
        int[] listB2 = {3,2,4};
        int skipA2 = 3;
        int skipB2 = 1;

        ListNode headA2 = buildList(listA2);
        ListNode headB2 = buildList(listB2);
        connectIntersection(headA2, headB2, skipA2, skipB2);

        ListNode ans2 = getIntersectionNode(headA2, headB2);
        System.out.println("Example 2 → Intersected at: " + (ans2 != null ? ans2.val : "null"));
    }
}
