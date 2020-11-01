package chapter_5_linkedlist.C5_5;

import chapter_5_linkedlist.ListNode;

public class LeetCode_24_Delete_Node {

    static class Solution {
        public static void deleteNode(ListNode node) {
            if (node == null) {
                //空链表
                //按题意此行可以省略
                return;
            }
            if (node.next==null) {
                //末尾结点
                //按题意此行可以省略
                return;
            }

            node.val = node.next.val;
            ListNode delNode = node.next;
            node.next = delNode.next;
        }
    }
}
