package chapter_5_linkedlist.C5_6_Remove_Nth_Node_Form_End_of_List;

import chapter_5_linkedlist.ListNode;

public class LeetCode_61_Rotate_list {

    static class Solution {
        public static ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) {
                return head;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            ListNode q = dummyHead;

            int length = 0;//计算长度
            while (q.next != null) {
                length++;
                q = q.next;
            }
            if (length <= 1) {
                return prev.next;
            }
            k = k % length;//真正需要旋转的个数
            if (k <1) {
                return prev.next;
            }


            int distance = 0;//p和q直接的距离，相差n+1
            q = dummyHead;
            while (distance < k + 1 && q != null) {
                distance++;
                q = q.next;
            }

            while (q != null && prev != null) {
                q = q.next;
                prev = prev.next;
            }

            ListNode newHead = null;
            //记录prev的后一个结点
            if (prev != null) {
                ListNode postP = prev.next;
                newHead = postP;
                if (postP != null) {
                    //断开
                    prev.next = null;
                    while (postP.next != null) {
                        postP = postP.next;
                    }
                    postP.next = dummyHead.next;
                }
            }
            return newHead;
        }

        public static void main(String[] args) {
//            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//            int[] arr = {1, 2, 3, 4, 5};
            int[] arr = {1,2};
            ListNode head = new ListNode(arr);
            System.out.println(head);
            head = rotateRight(head, 2);
            System.out.println(head);
        }
    }


}
