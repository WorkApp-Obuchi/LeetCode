package LeetCode.LinkedList;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        // corner case
        // if head or head.next is null, return false
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle solution = new HasCycle();

        // testcase1
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        ListNode head1 = new ListNode(3);
        head1.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;

        System.out.println("testcase1 : " + solution.hasCycle(head1));


        // testcase2
        ListNode head2 = new ListNode(1,
                            new ListNode(2)
        );
        System.out.println("testcase2 : " + solution.hasCycle(head2));
    }
}
