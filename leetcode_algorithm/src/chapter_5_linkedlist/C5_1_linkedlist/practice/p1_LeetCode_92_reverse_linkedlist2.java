package chapter_5_linkedlist.C5_1_linkedlist.practice;

import chapter_5_linkedlist.ListNode;

public class p1_LeetCode_92_reverse_linkedlist2 {
    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    static class Solution {

        public static ListNode reverseBetween(ListNode head, int m, int n) {
            int count=1;
            ListNode reversePre=null;//开始反转的head的pre
            ListNode startHead=head;//开始反转的head

            while (count<m){
                count++;
                reversePre=startHead;
                startHead=startHead.next;
            }

            System.out.println(startHead);

            ListNode startRecord=startHead;//开始记录反转的head
            ListNode pre=null;
            ListNode finalNext=null;//反转完成的下一个
            while (count<=n){
                count++;

                ListNode next=startHead.next;
                startHead.next=pre;
                pre=startHead;
                startHead=finalNext=next;
            }

            if (reversePre != null) {
                reversePre.next=pre;
            }
            startRecord.next=finalNext;

            if (m >1) {
                return head;
            }else {
                return pre;
            }
        }

        public static void main(String[] args) {
            ListNode node=new ListNode(1);
            node.next=new ListNode(2);
            node.next.next=new ListNode(3);
            node.next.next.next=new ListNode(4);
            node.next.next.next.next=new ListNode(5);
//            reverseBetween(node,1,2);
            System.out.println(reverseBetween(node,2,4));


        }
    }
}
