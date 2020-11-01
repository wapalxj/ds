package byd.algorithms.liuyubobobo.datasctructure1.src.chapter4_linkedlist_recursion;

/**
 * 递归解决数组求和
 */
public class Sum {
    public static int sum(int[] arr){
        //arr[0...n-1]这个区间的和
        return sum(arr,0);
    }

    //计算att[l...n-1]这个区间的和
    private static int sum(int[] arr,int l){
        if (l == arr.length) {
            return 0;
        }
        //arr[0]+att[1...n-1]这个区间的和
        return arr[l]+sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }
}
