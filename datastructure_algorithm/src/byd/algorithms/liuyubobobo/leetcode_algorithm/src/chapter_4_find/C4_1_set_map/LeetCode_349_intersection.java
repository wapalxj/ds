package byd.algorithms.liuyubobobo.leetcode_algorithm.src.chapter_4_find.C4_1_set_map;

import java.util.*;

/**
 * 求2个数组的交集
 *
 * // 时间复杂度: O(len(nums1)+len(nums2))
 * // 空间复杂度: O(len(nums1))
 */
public class LeetCode_349_intersection {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> record = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                record.add(nums1[i]);
            }

            List<Integer> intersection = new ArrayList<>();
            for (int i = 0; i < nums2.length; i++) {
                if (record.contains(nums2[i])) {
                    intersection.add(nums2[i]);
                }
            }

            int[] res = new int[intersection.size()];

            return res;
        }
    }
}
