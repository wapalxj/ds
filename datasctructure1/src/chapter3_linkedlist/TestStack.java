package chapter3_linkedlist;

import chapter2_stack.queue.LoopQueue;
import chapter2_stack.stack.ArrayStack;
import chapter2_stack.stack.Stack;

import java.util.Random;
/**
 * 测试数组栈、链表栈的性能
 */
public class TestStack {
    private static double testStack(Stack<Integer> stack, int opCount){

        long startTime=System.nanoTime();

        Random random=new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime=System.nanoTime();


        return (endTime-startTime)/1000000000.0;//纳秒转换为秒
    }

    public static void main(String[] args) {
//        int opCount=10_000;
        int opCount=10_000_000;
        ArrayStack<Integer> arrayStack=new ArrayStack<>();
        double time1=testStack(arrayStack,opCount);
        System.out.println("ArrayStack---->"+time1);

        LinkedStack<Integer> linkedQueue=new LinkedStack<>();
        double time2=testStack(linkedQueue,opCount);
        System.out.println("LinkedStack---->"+time2);
    }
}
