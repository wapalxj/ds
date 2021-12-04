package chapter8_heap;

import chapter2_stack.queue.Queue;

/**
 * 基于最大堆的优先队列
 * @param <E>
 */
public class PriorityQueue<E extends Comparable<E>>
        implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap=new MaxHeap<>();
    }
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }


}
