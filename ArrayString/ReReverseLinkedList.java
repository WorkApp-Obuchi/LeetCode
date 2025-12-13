package LeetCode.ArrayString;

public class ReReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    // リストを表示する関数
    public static void printList(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val);
            if(curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // リスト 1 -> 2 -> 3 -> 4 -> 5 を作成
        ListNode head1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)
                                        )
                                )
                        )
                );

        // リスト 1 -> 2 を作成
        ListNode head2 =
                new ListNode(1,
                        new ListNode(2)
                );

        // 空のリストを作成
        ListNode head3 = null;

        System.out.println("元のリスト:" + " head1");
        printList(head1);
        System.out.println("元のリスト:" + " head2");
        printList(head2);
        System.out.println("元のリスト:" + " head3");
        printList(head3);

        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode reversed1 = solution.reverseList(head1);
        ListNode reversed2 = solution.reverseList(head2);
        ListNode reversed3 = solution.reverseList(head3);
        System.out.println("反転後のリスト:" + " reversed1");
        printList(reversed1);
        System.out.println("反転後のリスト:" + " reversed2");
        printList(reversed2);
        System.out.println("反転後のリスト:" + " reversed3");
        printList(reversed3);
    }
}
