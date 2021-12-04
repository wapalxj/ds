package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_5_linkedlist.C5_4;

import algorithms.liuyubobobo.leetcode_algorithm.src.chapter_5_linkedlist.ListNode;

public class LeetCode_24_Swap_Nodes_in_Pairs {

    static class Solution {
        public static ListNode swapPairs(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode pre = dummyHead;
            while (pre.next != null && pre.next.next != null) {
                ListNode node1 = pre.next;
                ListNode node2 = node1.next;
                ListNode next = node2.next;

                node2.next = node1;
                node1.next = next;
                pre.next = node2;

                pre = node1;
            }

            return dummyHead.next;
        }

        public static void main(String[] args) {

            int[] arr = {1, 2, 3, 4};

            ListNode head = new ListNode(arr);
            System.out.println(head);

            head = swapPairs(head);
            System.out.println(head);
        }
    }
}
