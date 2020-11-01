package chapter_5_linkedlist.C5_4;

import chapter_5_linkedlist.ListNode;

public class LeetCode_25_reverse_K_Group {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        if (k <=1) {
            return dummyHead.next;
        }
        int count=1;
        while (checkNextK(prev, k)) {
            ListNode node0=prev.next;
            ListNode node1=node0;
            ListNode node2=node1.next;
            ListNode node3=null;
            node1.next=null;
            while (count<k){
                //翻转1个
                node3=node2.next;
                node2.next=node1;
                node1=node2;
                node2=node3;
                count++;
            }
            prev.next=node1;
            node0.next=node3;
            prev=node0;
            count=1;
        }


        return dummyHead.next;
    }

    //检查链表后面是否还有k个元素
    private static boolean checkNextK(ListNode prev, int k) {
        int i = 0;
        while (prev.next != null && i < k) {
            i++;
            prev=prev.next;
        }
        return i == k;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        head = reverseKGroup(head, 2);
        System.out.println(head);
    }


}
