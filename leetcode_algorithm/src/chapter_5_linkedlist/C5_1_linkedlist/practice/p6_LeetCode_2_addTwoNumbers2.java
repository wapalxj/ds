package chapter_5_linkedlist.C5_1_linkedlist.practice;

import chapter_5_linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p6_LeetCode_2_addTwoNumbers2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先用队列存储
        List<Integer> list1=new LinkedList<>();
        while (l1!=null){
            ((LinkedList<Integer>) list1).addFirst(l1.val);
            l1=l1.next;
        }
        List<Integer> list2=new LinkedList<>();
        while (l2!=null){
            ((LinkedList<Integer>) list2).addFirst(l2.val);
            l2=l2.next;
        }

        ListNode dummyHead=new ListNode(-1);
        ListNode cur= dummyHead;
        int carry=0;
        while (!list1.isEmpty() || !list2.isEmpty()){
            int sum=0;
            if (list1.isEmpty()) {
                 sum =((LinkedList<Integer>) list2).removeFirst()+carry;
            }else if (list2.isEmpty()) {
                 sum =((LinkedList<Integer>) list1).removeFirst()+carry;
            }else {
                 sum =((LinkedList<Integer>) list1).removeFirst()+((LinkedList<Integer>) list2).removeFirst()+carry;
            }
            carry=sum /10;
            sum=sum%10;
            cur.next=new ListNode(sum);
            cur=cur.next;
        }
        if (carry !=0) {
            //尾数相加进位
            cur.next=new ListNode(carry);
        }
        return reverse(dummyHead.next);
    }

    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        while (head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;

    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(7);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(4);
//        node.next.next.next = new ListNode(3);
//
//
//        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);

        ListNode node = new ListNode(5);

        ListNode node2 = new ListNode(5);
        System.out.println(addTwoNumbers(node, node2));
    }
}
