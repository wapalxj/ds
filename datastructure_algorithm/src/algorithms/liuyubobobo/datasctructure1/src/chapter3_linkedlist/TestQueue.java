package algorithms.liuyubobobo.datasctructure1.src.chapter3_linkedlist;


import algorithms.liuyubobobo.datasctructure1.src.chapter2_stack.queue.ArrayQueue;
import algorithms.liuyubobobo.datasctructure1.src.chapter2_stack.queue.LoopQueue;
import algorithms.liuyubobobo.datasctructure1.src.chapter2_stack.queue.Queue;

import java.util.Random;

/**
 * 测试数组队列、循环队列、链表队列的性能
 */
public class TestQueue {

    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime=System.nanoTime();

        Random random=new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime=System.nanoTime();


        return (endTime-startTime)/1000000000.0;//纳秒转换为秒
    }

    public static void main(String[] args) {
        int opCount=100_000;
//        int opCount=10_000_000;

        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        double time1=testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue---->"+time1);

        LoopQueue<Integer> loopQueue=new LoopQueue<>();
        double time2=testQueue(loopQueue,opCount);
        System.out.println("LoopQueue---->"+time2);

        LinkedQueue<Integer> linkedQueue=new LinkedQueue<>();
        double time3=testQueue(linkedQueue,opCount);
        System.out.println("LinkedQueue---->"+time3);
    }
}
