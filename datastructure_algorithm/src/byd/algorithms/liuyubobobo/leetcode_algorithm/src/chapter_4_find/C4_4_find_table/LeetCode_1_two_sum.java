package byd.algorithms.liuyubobobo.leetcode_algorithm.src.chapter_4_find.C4_4_find_table;

import java.util.HashMap;
import java.util.Map;

/**
 * O(n)
 */
public class LeetCode_1_two_sum {


    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            //key---元素，value---索引
            Map<Integer, Integer> record = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (record.containsKey(complement)) {
                    int res[] = {i, record.get(complement)};
                    return res;
                } else {
                    record.put(nums[i], i);
                }
            }

            throw new IllegalArgumentException("no result");
        }
    }
}
