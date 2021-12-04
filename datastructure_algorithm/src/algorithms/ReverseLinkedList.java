package algorithms;


public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        Node node = head;
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }

//        Node nodeR1 =reverse(head);
//        while (nodeR1 != null) {
//            System.out.println(nodeR1.val);
//            nodeR1 = nodeR1.next;
//        }


        reverseWithRecursion(head);
        while (root!= null) {
            System.out.println(root.val);
            root = root.next;
        }
    }


    //虚拟头节点翻转
    public static Node reverse(Node head) {
//        Node dummyHead = new Node(-1, null);
//        Node temp = head;
//        while (temp != null) {
//            head = head.next;
//            temp.next = dummyHead.next;
//            dummyHead.next = temp;
//            temp = head;
//        }
//        return dummyHead.next;
        Node dummyHead = new Node(-1, null);
        while (head != null) {
            Node temp=head.next;
            head.next=dummyHead.next;
            dummyHead.next=head;
            head=temp;
        }
        return dummyHead.next;

    }

    //递归翻转
    static Node root;
    public static Node reverseWithRecursion(Node head) {
        if (head.next == null) {
        //递归到底
            root=head;
            return head;
        } else {
            Node pre = reverseWithRecursion(head.next);
            pre.next = head;
            head.next=null;
            return head;
        }

//        if (head.next != null) {
//            Node pre = reverseWithRecursion(head.next);
//            pre.next = head;
//        }
//        System.out.println(head.val);
//        return head;
    }


    public static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}