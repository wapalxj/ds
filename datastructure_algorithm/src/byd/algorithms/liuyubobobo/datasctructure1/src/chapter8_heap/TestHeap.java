package byd.algorithms.liuyubobobo.datasctructure1.src.chapter8_heap;

import java.util.Random;

/**
 * 用一个数组构造一个堆，比较时间复杂度
 * 1.将n个元素逐个插入空堆
 * 2.heapify
 */
public class TestHeap {

    private static double testHeap(Integer[] testData,boolean isHeapify){
        long startTime=System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            //heapify
            maxHeap=new MaxHeap<>(testData);
        }else {
            //将n个元素逐个插入空堆
            maxHeap=new MaxHeap<>();

            for (int num:testData){
                maxHeap.add(num);
            }
        }

        int [] arr=new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i]=maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1]<arr[i]) {
                //无序则测试错误
                throw new IllegalArgumentException("error");
            }
        }

        long endTime=System.nanoTime();

        return (endTime-startTime)/1_000_000_000.0;
    }

    public static void main(String[] args) {
        int n = 1_000_000;

        Integer[] testData=new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {

            testData[i]=random.nextInt(Integer.MAX_VALUE);
        }

        double time1=testHeap(testData,false);
        System.out.println("without heapify: "+time1);


        double time2=testHeap(testData,true);
        System.out.println("with heapify: "+time2);


    }

}
