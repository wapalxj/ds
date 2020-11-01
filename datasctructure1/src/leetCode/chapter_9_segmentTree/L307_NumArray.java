package leetCode.chapter_9_segmentTree;

/**
 * 307. 区域和检索 - 数组可修改
 */
public class L307_NumArray {
    private int[] sum;//sum[i]存储前i个元素的和,sum[0]=0;
                      //sum[i]存储nums[0...i-1]的和
    private int[] data;
    public L307_NumArray(int[] nums) {
        data=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i]=nums[i];
        }

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        //nums[0...j]-nums[0...i-1]
        return sum[j + 1] - sum[i];
    }

    public void update(int index, int val) {
        data[index]=val;
        for (int i = index+1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }


    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        L307_NumArray numArray = new L307_NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
