package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_5_linkedlist.C5_6_Remove_Nth_Node_Form_End_of_List;

import algorithms.liuyubobobo.leetcode_algorithm.src.chapter_5_linkedlist.ListNode;

public class LeetCode_19_Remove_Nth_Node_Form_End_of_List {

    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            if (n < 1) {
                return head;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next=head;
            ListNode p = dummyHead;
            ListNode q = dummyHead;

            for (int i = 0; i < n + 1; i++) {
                //q与p之间保持n+1的距离
                if (q != null) {
                    q = q.next;
                }
            }

            while (q != null) {
                p = p.next;
                q = q.next;
            }

            ListNode delNode = p.next;
            p.next = delNode.next;
            return dummyHead.next;
        }

        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 4, 5};
            ListNode head = new ListNode(arr);
            System.out.println(head);

            head = removeNthFromEnd(head, 2);
            System.out.println(head);
        }
    }
}
