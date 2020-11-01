package chapter_5_linkedlist.C5_1_linkedlist;

import chapter_5_linkedlist.ListNode;

public class LeetCode_206_reverse_linkedlist {

    static class Solution {

        public static ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                //创建指向下一个链表的指针
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return pre;
        }

        /**
         * 递归实现
         */
        public static ListNode reverseList0(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            ListNode ret = reverseList0(head.next);
            head.next = null;
            next.next = head;
            return ret;
        }


        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 4, 5};
            ListNode head = new ListNode(nums);
            System.out.println(head);

            ListNode head2 = reverseList(head);
            System.out.println(head2);
        }
    }
}
