package algorithms.liuyubobobo.datasctructure1.src.leetCode.chapter_8_heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 前K大小的数
 */
public class Top_K_num {
    public static void main(String[] args) {
        int []arr={10,1,8,2,6,5,4,3,7,9};
        int k=5;
        PriorityQueue<Integer> queue=new PriorityQueue<>();

        for (int i :arr) {
            if (queue.size()<k) {
                queue.add(i);
            }else {
                if (i>queue.peek()) {
                    //下一个元素比堆中最小值大，则替换
                    queue.remove();
                    queue.add(i);
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        while (!queue.isEmpty()){
            res.add(queue.remove());
        }

        System.out.println(res);

    }
}