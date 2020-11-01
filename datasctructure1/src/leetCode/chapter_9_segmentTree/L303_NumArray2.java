package leetCode.chapter_9_segmentTree;

/**
 * 303. 区域和检索 - 数组不可变
 * 数组不可变，则可以使用此种方式
 *
 */
public class L303_NumArray2 {

    private int []sum;//sum[i]存储前i个元素的和,sum[0]=0;
                      //sum[i]存储nums[0...i-1]的和
    public L303_NumArray2(int[] nums) {
        sum=new int[nums.length+1];
        sum[0]=0;
        for (int i = 1; i < sum.length; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        //nums[0...j]-nums[0...i-1]
        return sum[j+1]-sum[i];
    }

    public static void main(String[] args) {
        int nums[]= {-2, 0, 3, -5, 2, -1};
        L303_NumArray2 numArray2=new L303_NumArray2(nums);
        System.out.println(numArray2.sumRange(0,2));
        System.out.println(numArray2.sumRange(2,5));
        System.out.println(numArray2.sumRange(0,5));
    }
}
