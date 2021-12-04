package algorithms.liuyubobobo.datasctructure1.src.chapter2_stack.stack;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
