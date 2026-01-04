package LeetCode.LinkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // corner case
        if(head == null || head.next == null) return false;

        // step1:
        // run two pointers, slow(turtle) and fast(rabbit)
        // while fast.next and fast.next.next is not null
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // step2:
            // if there is a cycle, 2x speed fast(rabbit) will eventually catch up with
            // 1x speed slow(turtle) pointer
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        // === testcase1: サイクルあり ===
        // 3 → 2 → 0 → -4
        //     ↑         ↓
        //     └─────────┘
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // サイクル作成！ -4 → 2 に戻る

        System.out.println("Test1 (cycle exists): " + solution.hasCycle(node1));// Expected: true

        // === testcase2: サイクルなし ===
        // 1 → 2 → 3 →null
        ListNode head2 = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(3)));

        System.out.println("Test2 (no cycle): " + solution.hasCycle(head2)); // Expected: false

        // === testcase3: ノード1つ、サイクルなし ===
        ListNode head3 = new ListNode(1);
        System.out.println("Test3 (single node): " + solution.hasCycle(head3));// Expected: false

        // === testcase4: ノード1つ、自己ループ ===
        ListNode head4 = new ListNode(1);
        head4.next = head4;  // 自分自身を指す
        System.out.println("Test4 (self loop): " + solution.hasCycle(head4));// Expected: true

        // === testcase5: 空リスト ===
        System.out.println("Test5 (null): " + solution.hasCycle(null));// Expected: false


    }
}
