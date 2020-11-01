package chapter4_heap;

public class MaxHeap<E extends Comparable> {

    private E[] data;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity + 1];//索引从1开始
        size = 0;
        this.capacity = capacity;
    }

    public MaxHeap(E[] arr) {
        int n=arr.length;
        data = (E[]) new Comparable[n + 1];//索引从1开始
        this.capacity = n;
        for (int i = 0; i < n; i++) {
            data[i+1]=arr[i];
        }
        size = n;
        for (int i = size/2; i >=1 ; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(E e) {
        assert (size + 1 <= capacity);
        data[size + 1] = e;
        size++;
        shiftUp(size);
    }

    private void shiftUp(int k) {
        while( k > 1 && data[k/2].compareTo(data[k]) < 0 ){
            swap(k, k/2);
            k /= 2;
        }
    }

    public E extractMax(){
        E ret =data[1];

        swap(1,size);
        size--;
        //下沉操作
        siftDown(1);
        return ret;
    }

    private void siftDown(int i) {
        while (2 * i<=size){
            int j=2*i;//j和i交换位置
            if (j+1 <=size && data[j+1].compareTo(data[j])>0) {
                j+=1;
            }

            if (data[i].compareTo(data[j])>=0) {
                break;
            }
            //j和i交换位置
            swap(i,j);
            i=j;
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap=new MaxHeap<>(100);
        for (int i = 0; i < 100; i++) {
            maxHeap.insert(new Integer((int) (Math.random()*100)));
        }

        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.extractMax());
        }
    }
}
