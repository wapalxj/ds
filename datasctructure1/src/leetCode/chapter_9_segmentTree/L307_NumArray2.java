package leetCode.chapter_9_segmentTree;

import chapter9_Segment_tree.Merger;
import chapter9_Segment_tree.SegementTree;

/**
 * 307. 区域和检索 - 数组可修改--使用线段树
 */
public class L307_NumArray2 {

    private SegementTree<Integer> segementTree;

    public L307_NumArray2(int[] nums) {
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

    public void update(int index,int val){
        if (segementTree == null) {
            throw  new IllegalArgumentException("nums is null");
        }
        segementTree.set(index,val);
    }
    public int sumRange(int i, int j) {
        if (segementTree == null) {
            throw  new IllegalArgumentException("nums is null");
        }
        return segementTree.query(i,j);
    }

    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        L307_NumArray2 numArray = new L307_NumArray2(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
