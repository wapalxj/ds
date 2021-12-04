package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_4_find.C4_6_findt_able3;

import java.util.HashMap;
import java.util.Map;

/**
 * // 时间复杂度: O(n^2)
 * // 空间复杂度: O(n)
 */
public class LeetCode_447_Number_of_Boomerangs {

    static class Solution {
        public static int numberOfBoomerangs(int[][] points) {
            int res = 0;
            for (int i = 0; i < points.length; i++) {
                Map<Integer, Integer> record = new HashMap<>();

                //Key--i到其他点的存储距离
                //Value--点数
                for (int j = 0; j < points.length; j++) {
                    if (i != j) {
                        int dis = dis(points[i], points[j]);
                        if (record.containsKey(dis)) {
                            record.put(dis, record.get(dis) + 1);
                        } else {
                            record.put(dis, 1);
                        }
                    }
                }

                for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
                    if (entry.getValue() >= 2) {
                        //计算组合数
                        res += entry.getValue() * (entry.getValue() - 1);
                    }
                }
            }
            return res;

        }

        //计算距离的平方，开放可能导致浮点误差
        //注意是否溢出
        private static int dis(int[] pa, int pb[]) {
            return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
                    (pa[1] - pb[1]) * (pa[1] - pb[1]);
        }

        public static void main(String[] args) {
        }
    }
}
