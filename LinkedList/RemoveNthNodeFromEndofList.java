class RemoveNthNodeFromEndofList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); //[0]→[1]→[2]
        dummy.next = head; //dummyを元の先頭に繋げてる。
        ListNode slow = dummy; 
        ListNode fast = dummy; 

        for(int i = 0; i <= n ;i++){ //fastをn+1進めたい
            fast =fast.next;
        }
        //fastが終わるまでslowとfastを進める
        while(fast != null){ //fastが最後まで行くまで回る
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; //slowを２つ進めて削除する。

        return dummy.next; 
    }
    //以下ローカルで動かすために作成している、、
        // 配列 → 連結リスト 変換
    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    // 連結リスト → 表示
    public static void printList(ListNode head) {
        ListNode cur = head;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(",");
            cur = cur.next;
        }
        System.out.println("]");
    }

    // 実行用のmain
    public static void main(String[] args) {

        // Example 1
        System.out.println("Example 1:");
        ListNode head1 = buildList(new int[]{1,2,3,4,5});
        ListNode res1 = removeNthFromEnd(head1, 2);
        printList(res1);  // Output: [1,2,3,5]

        // Example 2
        System.out.println("Example 2:");
        ListNode head2 = buildList(new int[]{1});
        ListNode res2 = removeNthFromEnd(head2, 1);
        printList(res2);  // Output: []

        // Example 3
        System.out.println("Example 3:");
        ListNode head3 = buildList(new int[]{1,2});
        ListNode res3 = removeNthFromEnd(head3, 1);
        printList(res3);  // Output: [1]
    }
}
