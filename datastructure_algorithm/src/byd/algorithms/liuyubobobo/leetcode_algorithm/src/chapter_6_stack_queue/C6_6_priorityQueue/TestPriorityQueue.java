package byd.algorithms.liuyubobobo.leetcode_algorithm.src.chapter_6_stack_queue.C6_6_priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
                return myCmp(o1,o2);
            }
        });


        for (int i = 0; i < 10; i++) {
            int num= (int) (Math.random()*100);
            priorityQueue.add(num);
        }

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }

    private static int myCmp(Integer o1, Integer o2){
        //按个位数大小排序
        return o1%10 - o2%10;
    }
}
