package LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class ReIntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        // headAを記録
        ListNode current = headA;
        while(current != null) {
            set.add(current);
            current = current.next;
        }
        // headB
        current = headB;
        while(current != null) {
            if(set.contains(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
