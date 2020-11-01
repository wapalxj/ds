package byd.algorithms.liuyubobobo.datasctructure1.src.chapter2_stack.queue;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
