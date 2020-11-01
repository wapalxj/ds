package chapter_5_linkedlist.C5_3_dummyhead.practice;

import chapter_5_linkedlist.ListNode;

public class p2_LeetCode_21_Merge_two_sorted_linked {


    /**
     * 3个指针
     * prev
     * cur
     * next
     *
     * cur==next 跳过
     *
     *
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(-1);
        ListNode pre=dummyHead;
        ListNode p1=l1;
        ListNode p2=l2;

        while (p1!=null || p2!=null){
            if (p1 == null) {
                pre.next=p2;
                p2=p2.next;
            }else if (p2 == null){
                pre.next=p1;
                p1=p1.next;
            }else if (p1.val <=p2.val) {
                pre.next=p1;
                p1=p1.next;
            }else {
                pre.next=p2;
                p2=p2.next;
            }
            pre=pre.next;
        }

        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(node,node2));
    }
}
