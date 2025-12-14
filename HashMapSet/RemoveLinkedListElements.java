package LeetCode.HashMapSet;

import java.util.List;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // dummynodeを作る(headの前に置く)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        // リストを最後まで走査
        while(current != null) {
            if(current.val == val) {
                // 削除；つなぎ替え
                prev.next = current.next;
            } else {
                // 削除しない場合にprevを進める
                prev = current;
            }
            // currentは必ず進める
            current = current.next;
        }
        // 新しい先頭を返す
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        // testcase1
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
        System.out.println(result2);
        // testcase3
        ListNode result3 = solution.removeElements(head3, 7);
        if(result3 == null){
            System.out.println("[]");
        } else {
            System.out.println(result3.val);
        }


    }
}
