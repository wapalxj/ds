package chapter_5_linkedlist.C5_6_Remove_Nth_Node_Form_End_of_List;

import chapter_5_linkedlist.ListNode;

public class LeetCode_19_Remove_Nth_Node_Form_End_of_List {

    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            if (n < 1) {
                return head;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
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


    //2次遍历的做法
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (n < 0) {
            return head;
        }

        int count = 0;//第一次遍历，计算总结点数
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            count++;
            prev = prev.next;
        }

        if (n > count) {
            return head;
        }

        int pos = 0;
        prev = dummyHead;
        while (pos < count - n) {//count - n表示删除的是整数第几个数
            prev=prev.next;
            pos++;
        }
        prev.next=prev.next.next;

        return dummyHead.next;
    }

    //1次遍历的做法
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (n < 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode q = dummyHead;

        int distance=0;//p和q的距离为n+1
        while (distance<n+1 && q!=null){
            distance++;
            q=q.next;
        }

        while (q!=null &&prev!=null){
            q=q.next;
            prev=prev.next;
        }

        prev.next=prev.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//        insertionSort(arr);
//        System.out.println(Arrays.toString(arr));

        ListNode head = new ListNode(arr);
        System.out.println(head);
        head = removeNthFromEnd2(head, 3);
        System.out.println(head);
    }
}
