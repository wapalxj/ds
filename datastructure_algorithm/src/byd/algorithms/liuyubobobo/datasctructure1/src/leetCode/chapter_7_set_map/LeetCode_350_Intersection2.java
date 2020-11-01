package byd.algorithms.liuyubobobo.datasctructure1.src.leetCode.chapter_7_set_map;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 求2个数组的交集
 * <p>
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2,2].
 */
public class LeetCode_350_Intersection2 {

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums1) {
                //记录num1中元素的频次
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
            }

            List<Integer> intersection = new ArrayList<>();
            for (int num : nums2) {

                if (map.containsKey(num)) {
                    //如果num1包含num2元素，则添加到结果list中,并且频次-1
                    intersection.add(num);
                    map.put(num, map.get(num) - 1);
                    if (map.get(num) == 0) {
                        map.remove(num);
                    }
                }
            }
            int res[] = new int[intersection.size()];
            for (int i = 0; i < intersection.size(); i++) {
                res[i] = intersection.get(i);
            }

            return res;
        }
    }


}

