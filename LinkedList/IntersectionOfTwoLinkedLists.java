package LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        // headAを記録
        ListNode current = headA;
        while (current != null) {
            set.add(current);
            current = current.next;
        }

        // headB
        current = headB;
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        // testcase1
        ListNode headA1 = new ListNode(4,
                new ListNode(1,
                        new ListNode(8,
                                new ListNode(4,
                                        new ListNode(5)
                                )
                        )
                )
        );
        ListNode headB1 = new ListNode(5,
                new ListNode(6,
                        new ListNode(1,
                                new ListNode(8,
                                        new ListNode(4,
                                                new ListNode(5)
                                        )
                                )
                        )
                )
        );
        ListNode result1 = solution.getIntersectionNode(headA1, headB1);
        System.out.println("testcase1 : " + result1);

        // testcase2
        ListNode headA2 = new ListNode(1,
                new ListNode(9,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(4)
                                )
                        )
                )
        );
        ListNode headB2 = new ListNode(3,
                new ListNode(2,
                        new ListNode(4)
                )
        );
        ListNode result2 = solution.getIntersectionNode(headA2, headB2);
        System.out.println("testcase2 : " + result2);

        // testcase3
        ListNode headA3 = new ListNode(2,
                new ListNode(6,
                        new ListNode(4)
                )
        );
        ListNode headB3 = new ListNode(1,
                new ListNode(5)
        );
        ListNode result3 = solution.getIntersectionNode(headA3, headB3);
        System.out.println("testcase3 : " + result3);

    }
}
