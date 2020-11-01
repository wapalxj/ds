package byd.algorithms.liuyubobobo.leetcode_algorithm.src.chapter_3_array.C3_6_TwoSum.practice;

public class p3_LeetCode11_Container_With_Most_Water {

    //暴力解法，计算每2堵墙的容量
    public static int maxArea(int[] height) {
        int len = height.length;
        int[] pos = new int[2];//2堵墙的位置
        int area = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int newArea = (j - i) * Math.min(height[i], height[j]);
                if (newArea > area) {
                    area = newArea;
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
