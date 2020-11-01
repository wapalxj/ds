package leetCode.chapter_9_segmentTree;

import chapter9_Segment_tree.Merger;
import chapter9_Segment_tree.SegementTree;
import com.sun.org.apache.bcel.internal.generic.IFNE;

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
