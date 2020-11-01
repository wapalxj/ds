package chapter8_heap;

import chapter1_array.Array;
import com.sun.org.apache.regexp.internal.RE;

import java.util.PriorityQueue;
import java.util.Random;

public class MaxHeap<E extends Comparable> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * heapify
     * @param arr
     */
    public MaxHeap(E[] arr){
        data=new Array<>(arr);
        for (int i = parent(arr.length - 1); i >=0; i--) {
            //从最后一个非叶子结点开始，倒序进行siftDown
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpy();
    }

    //返回完全二叉树的数组表示中，inedx结点的parent的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't hava parent");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，index结点的leftChild的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，index结点的rightChild的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加操作
     *
     * @param e
     */
    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);

    }

    //上浮操作
    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            //大于parent，交换
            data.swap(index, parent(index));
            index = parent(index);
        }
    }


    /**
     * 删除操作--删除最大值
     *
     * @return
     */
    //取出堆中最大元素
    public E findMax() {
        if (data.isEmpy()) {
            throw new IllegalArgumentException("findMax---heap is empty");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E ret = findMax();

        //root与末尾进行交换，并且删除末尾
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        //下沉操作
        siftDown(0);
        return ret;
    }

    //下沉操作
    private void siftDown(int index) {
        //循环条件，左孩子存在(如果leftChild不存在，那rightChild也肯定不存在)
        while (leftChild(index) < data.getSize()) {
            int j = leftChild(index);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                //rightChild存在
                //rightChild比leftChild大
                j = rightChild(index);

                //data[j] 是leftChild和rightChild中的最大值
            }

            if (data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }
            //当前结点比左右孩子中最大的还小，交换
            data.swap(index, j);
            index = j;
        }
    }

    /**
     * replace
     * @param e
     * @return
     */
    public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        //测试堆的extractMax元素顺序
        int [] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1]<arr[i]) {
                //无序则测试错误
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("text MaxHeap completed.");
    }
}
