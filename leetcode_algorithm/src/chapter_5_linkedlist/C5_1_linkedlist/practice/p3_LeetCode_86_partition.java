package chapter_5_linkedlist.C5_1_linkedlist.practice;

import chapter_5_linkedlist.ListNode;

public class p3_LeetCode_86_partition {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode headLt=null;
        ListNode headGt=null;
        ListNode newHead=null;
        ListNode newHead2=null;

        while (head!=null){
            if (head.val<x) {
                if (headLt == null) {
                    headLt=newHead=head;
                }else {
                    headLt.next=head;
                    headLt=head;
                }
            }else if (head.val >=x) {
                if (headGt == null) {
                    headGt=newHead2=head;
                }else {
                    headGt.next=head;
                    headGt=head;
                }
            }
            head=head.next;
        }

        if (headGt != null) {
            headGt.next=null;
        }
        if (headLt != null) {
            headLt.next=newHead2;
        }
        if (newHead == null) {
            //全部都比target大
            return newHead2;
        }

        return newHead;
    }

    public static ListNode partition2(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode prev1 = dummyHead1;
        ListNode prev2 = dummyHead2;

        for(ListNode cur = head ; cur != null ;){
            if(cur.val < x){
                prev1.next = cur;
                cur = cur.next;
                prev1 = prev1.next;
                prev1.next = null;
            } else{
                prev2.next = cur;
                cur = cur.next;
                prev2 = prev2.next;
                prev2.next = null;
            }
        }

        prev1.next = dummyHead2.next;
        ListNode ret = dummyHead1.next;

        return ret;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(4);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(2);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(2);
        System.out.println(partition(node,0));
    }
}
