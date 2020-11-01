package chapter_5_linkedlist.C5_1_linkedlist.practice;

import chapter_5_linkedlist.ListNode;

public class p4_p3_LeetCode_328_oddEvenList_ {
    public static ListNode oddEvenList(ListNode head) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode prv1 = dummyHead1;
        ListNode prv2 = dummyHead2;
        int count = 1;
        while (head != null) {
            if (count % 2 != 0) {
                prv1.next=head;
                head=head.next;
                prv1=prv1.next;
                prv1.next=null;
            }else {
                prv2.next=head;
                head=head.next;
                prv2=prv2.next;
                prv2.next=null;
            }
            count++;
        }
        prv1.next=dummyHead2.next;
        ListNode ret=dummyHead1.next;

        return ret;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(oddEvenList(node));
    }
}
