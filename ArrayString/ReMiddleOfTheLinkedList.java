package LeetCode.ArrayString;

import java.util.List;

public class ReMiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
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
        // input : [1,2,3,4,5]
        // output : [3,4,5]
        ListNode testcase1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)
                                )
                        )
                )
        );

        // testcase2
        // input : [1,2,3,4,5,6]
        // output : [4,5,6]
        ListNode testcase2 = new ListNode(1,
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

        ReMiddleOfTheLinkedList solution = new ReMiddleOfTheLinkedList();
        ListNode result1 = solution.middleNode(testcase1);
        ListNode result2 = solution.middleNode(testcase2);

        System.out.println("testcase1 : " + result1.val);
        System.out.println("testcase2 : " + result2.val);
    }
}
