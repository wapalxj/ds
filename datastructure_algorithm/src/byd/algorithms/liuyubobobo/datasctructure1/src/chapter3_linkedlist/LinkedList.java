package byd.algorithms.liuyubobobo.datasctructure1.src.chapter3_linkedlist;


public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;//虚拟头结点
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public void add(E e, int index) {
        //index是可以等于size的--->在末尾添加元素
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }


    //递归写法
    public void add2(E e, int index) {
        //index是可以等于size的--->在末尾添加元素
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. illegal index.");
        }

        Node prev = dummyHead;
        dummyHead=add2(prev,e,index, 0);
        size++;
    }

    private Node add2(Node prev, E e, int index, int curIndex) {
        if (index == curIndex) {
            prev.next = new Node(e, prev.next);
            return prev;
        }
        prev.next = add2(prev.next, e, index, curIndex + 1);
        return prev;
    }



    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast(int index) {
        return get(size - 1);
    }


    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. illegal index.");
        }
        Node prev=dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        Node delNode=prev.next;
        prev.next=delNode.next;
        delNode.next=null;
        size--;
        return delNode.e;
    }

    public void removeElement(E e){
        Node prev=dummyHead;
//        while (prv.next!=null){
//            if (prv.next.e.equals(e)) {
//                break;
//            }
//            prv=prv.next;
//        }
//
//        if (prv.next!=null) {
//            Node delNode=prv.next;
//            prv.next=delNode.next;
//            size--
//            delNode.next=null;
//        }

        while (prev.next != null) {
            if (prev.next.e == e) {
                prev.next = prev.next.next;
                size--;
            } else {
                prev = prev.next;
            }
        }
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

//        for (;cur!=null;cur=cur.next){
//            res.append(cur + "->");
//        }

        res.append("NULL");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add2(666,2);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

}
