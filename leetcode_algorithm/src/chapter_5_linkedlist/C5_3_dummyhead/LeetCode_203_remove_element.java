package chapter_5_linkedlist.C5_3_dummyhead;

import chapter_5_linkedlist.ListNode;

public class LeetCode_203_remove_element {


    static class Solution {

        /**
         *
         */
        public static ListNode removeElements1(ListNode head, int val) {
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
        public static ListNode removeElements2(ListNode head, int val) {
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

        /**
         *
         */
        public static ListNode removeElements3(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            ListNode pre = head;
            while (pre != null && pre.next != null) {
                if (pre.next.val == val) {
                    pre.next = pre.next.next;
                } else {
                    pre = pre.next;
                }
            }
            return head;
        }

        public static ListNode removeElements4(ListNode head, int val) {
            ListNode dummyHead=new ListNode(-1);
            dummyHead.next=head;
            ListNode pre=dummyHead.next;
            while (pre.next!=null ){
                if (pre.next.val == val) {
                    ListNode delNode=pre.next;
                    pre.next=delNode.next;
                }else {
                    pre=pre.next;
                }
            }

            return dummyHead.next;
        }
        public static void main(String[] args) {
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(4);
            node.next.next.next.next = new ListNode(5);
            System.out.println(removeElements4(node, 3));
        }
    }
}
