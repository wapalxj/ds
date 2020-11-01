package chapter_5_linkedlist.C5_1_linkedlist.practice;

import chapter_5_linkedlist.ListNode;

public class p5_LeetCode_2_addTwoNumbers {

    //位数多了，会溢出
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = listToNum(l1);
        int num2 = listToNum(l2);
        int resNum = num1 + num2;
        ListNode node = numTolist(resNum);
        return node;
    }

    private static int listToNum(ListNode l1) {
        int num1 = 0;
        int count1 = 0;
        while (l1 != null) {
            num1 = num1 + (int) (Math.pow(10, count1) * l1.val);
            count1++;
            l1 = l1.next;
        }
        System.out.println("11111========" + num1);
        return num1;
    }

    private static ListNode numTolist(int num) {
        int tempNum = num;
        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;
        if (num == 0) {
            dummyHead.next = new ListNode(0);
        }

        while (num > 0) {
            tempNum = num % 10;
            num = num / 10;
            node.next = new ListNode(tempNum);
            node = node.next;

        }
        System.out.println("22222========" + tempNum);
        return dummyHead.next;
    }

    //官方答案
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            //尾数相加进位
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(2);
//        node.next = new ListNode(4);
//        node.next.next = new ListNode(3);
//
//        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);

        ListNode node = new ListNode(9);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(9);
        node2.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        System.out.println(addTwoNumbers(node, node2));
    }
}
