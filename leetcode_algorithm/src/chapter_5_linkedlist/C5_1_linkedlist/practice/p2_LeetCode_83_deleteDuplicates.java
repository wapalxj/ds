package chapter_5_linkedlist.C5_1_linkedlist.practice;

import chapter_5_linkedlist.ListNode;

public class p2_LeetCode_83_deleteDuplicates {
    //递归
    public static ListNode deleteDuplicatesWithRecursion(ListNode head) {

        //递归到底
        if (head == null) {
            return null;
        }

        head.next = deleteDuplicatesWithRecursion(head.next);
        if (head.next != null && head.val == head.next.val) {
            //重复则指向下一个
            return head.next;
        }

        return head;
    }

    //非递归
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        System.out.println(deleteDuplicates(node));
    }
}
