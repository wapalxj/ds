package leetCode.chapter_7_set_map;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 求2个数组的交集
 * <p>
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 */
public class LeetCode_349_Intersection {

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int num : nums1) {
                //对nums1去重
                set.add(num);
            }

            ArrayList<Integer> intersection  = new ArrayList<>();
            for (int num : nums2) {
                if (set.contains(num)) {
                    //如果num1包含num2元素，则添加到结果list中
                    intersection .add(num);
                    set.remove(num);
                }
            }

            int res[] = new int[intersection .size()];
            for (int i = 0; i < intersection .size(); i++) {
                res[i] = intersection .get(i);
            }

            return res;
        }
    }


}

