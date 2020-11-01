package leetCode.chapter4_linkedlist;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class LeetCode_203 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = Solution.removeElements4(head, 6,0);
        System.out.println(res);
    }
}

class Solution {
    //不使用虚拟头结点
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
//            ListNode delNode=head;
//            head=head.next;
//            delNode.next=null;

            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
//                ListNode delNode=prev.next;
//                prev.next=delNode.next;
//                delNode.next=null;
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    //使用虚拟头结点
    public static ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }


    //使用递归
    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            //求解基本问题
            return null;
        }

        //写法1
//        ListNode res=removeElements3(head.next,val);
        //判断当前点
//        if (head.val==val) {
//            return res;
//        }else {
//            head.next=res;
//            return head;
//        }


        //写法2
        head.next = removeElements3(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }

        //写法3
        // head.next = removeElements3(head.next, val);
        // return head.val == val ? head.next : head;
    }

    //使用递归--调试--打印输出
    public static ListNode removeElements4(ListNode head, int val, int depth) {
        String depthString=generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call:remove "+val+" in "+head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("return "+head);
            //求解基本问题
            return null;
        }

        ListNode res= removeElements4(head.next, val,depth+1);
        System.out.print(depthString);
        System.out.println("After remove "+val+": "+res);

        ListNode ret;
        if (head.val == val) {
            ret=res;
        }else {
            head.next=res;
            ret=head;
        }
        System.out.print(depthString);
        System.out.println("Return "+ret);
        return ret;
    }

    private static String generateDepthString(int depth) {
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < depth; i++) {
            //"-"越长，深度越大
            res.append("—");
        }
        return res.toString();
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    //以下全部代码自己创建作为测试用例

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty ");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}