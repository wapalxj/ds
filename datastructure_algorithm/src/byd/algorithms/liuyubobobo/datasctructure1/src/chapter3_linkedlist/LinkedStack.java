package byd.algorithms.liuyubobobo.datasctructure1.src.chapter3_linkedlist;


import algorithms.liuyubobobo.datasctructure1.src.chapter2_stack.stack.Stack;

public class LinkedStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedStack(){
        list=new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack top: ");
        res.append(list);
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedStack<Integer> stack=new LinkedStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
