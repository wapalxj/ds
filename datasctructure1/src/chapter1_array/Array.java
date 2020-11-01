package chapter1_array;

import java.util.ArrayList;

public class Array<E> {
    private E[] data;
    private int size;


    /**
     *
     * @param capacity 容量
     */
    public Array(int capacity){
        data= (E[]) new Object[capacity];
        size=0;
    }
    /**
     * 无参构造，默认数组容量10
     */
    public Array(){
        this(10);
    }

    /**
     * 数组构造
     */
    public Array(E[] arr){
        data= (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i]=arr[i];
        }
        size=arr.length;
    }


    /**
     * @return 元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * @return 容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * @return 是否为空
     */
    public boolean isEmpy(){
        return size==0;
    }

    /**
     *
     * @param e 增加元素
     */
    public void addLast(E e){
        add(size,e);
    }
    /**
     *
     * @param e 增加元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在index位置插入e
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if (index<0 || index>size) {
            throw new IllegalArgumentException(
                    "addLast failed,Require index>0 and index<=size");
        }

        if (size==data.length) {
            //动态数组-扩容
            resize(2 * data.length);
        }

        for (int i = size-1; i>=index; i--) {
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    /**
     * 动态数组-扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     *
     * @return 获取index索引位置的元素
     */
    public E get(int index){
        if (index<0 || index>=size) {
            throw new IllegalArgumentException(
                    "get failed,index is illegal");
        }
        return data[index];
    }

    /**
     * @return 获取last
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * @return 获取First
     */
    public E getFirst(){
        return get(0);
    }

    /**
     *
     * @return 获取index索引位置的元素
     */
    public void set(int index,E e){
        if (index<0 || index>=size) {
            throw new IllegalArgumentException("" +
                    "set failed,index is illegal");
        }
        data[index]=e;
    }

    /**
     *
     * @param e 查找数组中是否有e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals( e)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param e 查找数组中是否有e
     * @return  返回索引
     */
    public int find(E e){
        return find(e,0);
    }

    /**
     *
     * @param e 查找数组中是 否有e
     * @param start 指定位置开始找
     * @return 查找数组中是否有e
     */
    public int find(E e,int start){
        for (int i = start; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置的元素
     * @return
     */
    public E remove(int index){
        if (index <0 || index>=size) {
            throw new IllegalArgumentException(
                    "set failed,index is illegal");
        }
        E res=data[index];
        for (int i = index+1; i <size ; i++) {
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;//loitering objects != memory leak

        //动态数组，减容
        if (size== data.length/4 && data.length/2 != 0) {
            resize(data.length  /2);
        }
        return res;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 删除第一个e
     * @param e
     */
    public void removeElement(E e){
        int index=find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 删除所有e
     * @param e
     */
    public void removeAllElement(E e){
        int index=0;
        do {
            index=find(e,index);
            if (index != -1) {
                remove(index);
            }
        }while (index != -1 && index<size-1);
    }


    public void swap(int i,int j){
        if (i<0 || i>=size || j<0 || j>=size ) {
            throw new IllegalArgumentException("index is illegal");
        }
        E t=data[i];
        data[i]=data[j];
        data[j]=t;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array size= %d " +
                ",capacity= %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
