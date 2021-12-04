package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_4_find.C4_1_set_map;

import java.util.*;

/**
 * 求2个数组的交集
 *
 * // 时间复杂度: O(len(nums1)+len(nums2))
 * // 空间复杂度: O(len(nums1))
 */
public class LeetCode_350_intersection {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Map<Integer, Integer> record = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                if (record.containsKey(nums1[i])) {
                    record.put(nums1[i], record.get(nums1[i]) + 1);
                } else {
                    record.put(nums1[i], 1);
                }
            }

            List<Integer> intersection = new ArrayList<>();
            for (int i = 0; i < nums2.length; i++) {
                if (record.containsKey(nums2[i])) {
                    intersection.add(nums2[i]);
                    if (record.get(nums2[i]) > 1) {
                        record.put(nums2[i], record.get(nums2[i]) - 1);
                    } else {
                        record.remove(nums2[i]);
                    }

                }
            }

            int[] res = new int[intersection.size()];
            for (int i = 0; i < intersection.size(); i++) {
                res[i] = intersection.get(i);
            }

            return res;
        }
    }
}
