package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_5_linkedlist.C5_3_dummyhead;

import algorithms.liuyubobobo.leetcode_algorithm.src.chapter_5_linkedlist.ListNode;

public class LeetCode_203_remove_element {


    class Solution {

        /**
         *
         */
        public ListNode removeElements1(ListNode head, int val) {
            if (head == null) {
                return head;
            }

            //删除头结点
            while (head != null && head.val == val) {
                head = head.next;
            }

            //删除非头结点
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return head;
        }

        /**
         * 使用虚拟头结点
         */
        public ListNode removeElements2(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode pre = dummyHead;
            while (pre.next != null) {
                if (pre.next.val == val) {
                    pre.next = pre.next.next;
                } else {
                    pre = pre.next;
                }
            }
            return dummyHead.next;
        }
    }
}
