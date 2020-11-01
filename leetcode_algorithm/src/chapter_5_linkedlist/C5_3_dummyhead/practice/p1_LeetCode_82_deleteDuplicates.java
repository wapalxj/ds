package chapter_5_linkedlist.C5_3_dummyhead.practice;

import chapter_5_linkedlist.ListNode;

public class p1_LeetCode_82_deleteDuplicates {


    /**
     * 3个指针
     * prev
     * cur
     * next
     *
     * cur==next 跳过
     *
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = prev.next;
//        while (cur != null) {
//            if (cur.next != null && cur.val != cur.next.val) {
//                prev = cur;
//            } else {
//                while (cur.next!=null && cur.val==cur.next.val) {
//                    cur=cur.next;
//                }
//            }
//            cur = cur.next;
//            prev.next = cur;
//
//        }


        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            } else {
                prev = cur;
            }
            cur = cur.next;
            prev.next = cur;

        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        System.out.println(deleteDuplicates(node));
    }
}
