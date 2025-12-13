package LeetCode.ArrayString;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // corner case
        if(head == null) return null;
        if(head.next == null) return head;
        if(head.next.next == null) return head.next;

        // step1
        // even node: head -> 0 -> 2 -> 4 -> 6, middle: 4
        // odd  node: head -> 1 -> 3 -> 5, middle: 3

        // ListNode slow : 1回で1つ進む
        // ListNode fast : 1回で2つ進む

        // odd case
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // testcase1
        ListNode node1 = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(3,
                                            new ListNode(4,
                                                    new ListNode(5)
                                            )
                                    )
                            )
        );

        // testcase2
        ListNode node2 = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(3,
                                            new ListNode(4,
                                                    new ListNode(5,
                                                            new ListNode(6)
                                                    )
                                            )
                                    )
                            )
        );

        MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();
        // testcase1
        ListNode testcase1 = solution.middleNode(node1);
        System.out.println(testcase1.val);
        // testcase2
        ListNode testcase2 = solution.middleNode(node2);
        System.out.println(testcase2.val);
    }
}
