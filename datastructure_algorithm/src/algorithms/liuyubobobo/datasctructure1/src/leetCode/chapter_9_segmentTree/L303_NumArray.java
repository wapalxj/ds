package algorithms.liuyubobobo.datasctructure1.src.leetCode.chapter_9_segmentTree;


import algorithms.liuyubobobo.datasctructure1.src.chapter9_Segment_tree.Merger;
import algorithms.liuyubobobo.datasctructure1.src.chapter9_Segment_tree.SegementTree;

/**
 * 303. 区域和检索 - 数组不可变-使用线段树
 */
public class L303_NumArray {

    private SegementTree<Integer> segementTree;

    public L303_NumArray(int[] nums) {
        if (nums!=null && nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segementTree = new SegementTree<>(data, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });
        }
    }

    public int sumRange(int i, int j) {
        if (segementTree == null) {
            throw  new IllegalArgumentException("nums is null");
        }
        return segementTree.query(i,j);
    }

    public static void main(String[] args) {

    }
}
