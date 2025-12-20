package LeetCode.HashMapSet;

public class ReReRemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while(current != null) {
            if(current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ReReRemoveLinkedListElements solution = new ReReRemoveLinkedListElements();

        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6)
                                                )
                                        )
                                )
                        )
                )
        );

        // testcase2
        ListNode head2 = null; // 空リスト

        // testcase3
        ListNode head3 = new ListNode(7,
                new ListNode(7,
                        new ListNode(7,
                                new ListNode(7)
                        )
                )
        );

        // testcase1
        ListNode result1 = solution.removeElements(head1,6);
        System.out.println(result1.val);
        // testcase2
        ListNode result2 = solution.removeElements(head2, 1);
        if(result2 == null) {
            System.out.println("[]");
        } else {
            System.out.println(result2);
        }
        // testcase3
        ListNode result3 = solution.removeElements(head3, 7);
        if(result3 == null){
            System.out.println("[]");
        } else {
            System.out.println(result3.val);
        }
    }
}
