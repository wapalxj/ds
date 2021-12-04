package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_6_stack_queue.C6_6_priorityQueue;

import java.util.*;

public class LeetCode_347_Top_K_fre {
    static class Solution {
        public static List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> fre = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (fre.containsKey(nums[i])) {
                    fre.put(nums[i], fre.get(nums[i]) + 1);
                } else {
                    fre.put(nums[i], 1);
                }
            }


            if (k > fre.size()) {
                return null;
            }

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return fre.get(o1)-fre.get(o2);
                }
            });
            for (int i : fre.keySet()) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(i);
                } else {
                    if (fre.get(priorityQueue.peek()) < fre.get(i)) {
                        priorityQueue.remove();
                        priorityQueue.add(i);
                    }
                }
            }
            List<Integer> ret=new ArrayList<>();
            ret.addAll(priorityQueue);

            return ret;
        }

        public static void main(String[] args) {
            int nums[] ={4,1,-1,2,-1,2,3};
            topKFrequent(nums,2);
        }
    }
}
