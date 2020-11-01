package chapter_5_linkedlist.C5_4;

import chapter_5_linkedlist.ListNode;

import java.util.Arrays;

public class LeetCode_147_insertion_sort {
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;


        ListNode node1 = prev.next;//排序链表
        ListNode node2 = null;//旧链表
        ListNode newList = null;//排序链表头\
        while (node1 != null) {
            node1.next = null;//取下
            //node1插入
//            System.out.println(newList);
            newList = insert(newList, node1);
//            System.out.println(newList);
            node1 = node2;
        }
        return newList;
    }

    //按顺序插入到链表
    private static ListNode insert(ListNode newList, ListNode node) {
        if (newList == node) {
            return newList;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = newList;
        ListNode prev = dummyHead;
        while (prev.next != null && node.val > prev.next.val) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;

        return dummyHead.next;
    }


    public static ListNode insertionSortList2(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        ListNode curr= prev.next;//旧链表

        while (curr!=null && curr.next!=null){
            if (curr.val<=curr.next.val) {
                curr=curr.next;
            }else {
                //取下
                ListNode in=curr.next;
                curr.next=in.next;
                in.next=null;

                //插入
                ListNode tempHead=prev;
                while (tempHead.next.val<=in.val){
                    tempHead=tempHead.next;
                }
                in.next=tempHead.next;
                tempHead.next=in;
            }
        }
        return dummyHead.next;
    }
    //数组插入排序
    public static void insertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int p = arr[i + 1];
            int j = i + 1;
            for (; j > 0 && p < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = p;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
//        insertionSort(arr);
//        System.out.println(Arrays.toString(arr));

        ListNode head = new ListNode(arr);
        System.out.println(head);
        head = insertionSortList2(head);
        System.out.println(head);
    }
}
