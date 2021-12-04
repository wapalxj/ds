package algorithms.liuyubobobo.datasctructure1.src.leetCode.chapter_8_heap;

import algorithms.liuyubobobo.datasctructure1.src.chapter8_heap.PriorityQueue;
import com.sun.istack.internal.NotNull;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class LeetCode_347_Top_K_Frequent_Elements {
    static class Freq implements Comparable<Freq> {
        int e, freq;//元素以及频次

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(@NotNull Freq o) {
            if (this.freq < o.freq) {
                //频次越低，优先级越高
                return 1;
            }
            if (this.freq > o.freq) {
                //频次越低，优先级越高
                return -1;
            }
            return 0;
        }
    }

    static class Solution {
        //使用我们自己的PriorityQueue
        public List<Integer> topKFrequent(int[] nums, int k) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            //上面代码统计频次

            //使用我们自己的PriorityQueue
            PriorityQueue<Freq> queue = new PriorityQueue<>();
            for (int key : map.keySet()) {
                if (queue.getSize() < k) {
                    //还没存够k个元素
                    queue.enqueue(new Freq(key, map.get(key)));
                } else if (map.get(key) > queue.getFront().freq) {
                    //下一个元素比堆中最小值大，则替换
                    queue.dequeue();
                    queue.enqueue(new Freq(key, map.get(key)));
                }
            }

            LinkedList<Integer> res = new LinkedList<>();
            while (!queue.isEmpty()) {
                res.add(queue.dequeue().e);
            }
            return res;
        }


        //使用JDK的PriorityQueue
        public List<Integer> topKFrequent2(int[] nums, int k) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            //上面代码统计频次

            //使用JDK的PriorityQueue
//            java.util.PriorityQueue<Freq2> queue = new java.util.PriorityQueue<>();
//            java.util.PriorityQueue<Freq2> queue =
//                    new java.util.PriorityQueue<>(new FreqComparator());


            //变形：不再需要Freq类
            java.util.PriorityQueue<Integer> queue =
                    new java.util.PriorityQueue<>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer a, Integer b) {
                            return map.get(a) - map.get(b);
                        }
                    });

            for (int key : map.keySet()) {
                if (queue.size() < k) {
                    //还没存够k个元素
                    queue.add(key);
                } else if (map.get(key) > map.get(queue.peek())) {
                    //下一个元素比堆中最小值大，则替换
                    queue.remove();
                    queue.add(key);
                }
            }

            LinkedList<Integer> res = new LinkedList<>();
            while (!queue.isEmpty()) {
                res.add(queue.remove());
            }
            return res;
        }


    }

    static class FreqComparator implements Comparator<Freq2>{

        @Override
        public int compare(Freq2 o1, Freq2 o2) {
            return o1.freq-o2.freq;
        }
    }

    static class Freq2 implements Comparable<Freq> {
        int e, freq;//元素以及频次

        public Freq2(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(@NotNull Freq o) {
            if (this.freq < o.freq) {
                return -1;
            }
            if (this.freq > o.freq) {
                //频次越低，优先级越高
                return 1;
            }
            return 0;
        }
    }
}
