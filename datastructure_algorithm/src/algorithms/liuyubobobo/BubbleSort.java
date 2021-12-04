package algorithms.liuyubobobo;

import java.util.Arrays;

/**
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{80, 100, 50, 22, 15, 6, 1, 1000, 999, 0};
//        int[] nums = new int[]{1,2,3,4,5,6,7,9,8,10};
//        recursiveBubble(nums);
        bubble4(nums);
        System.out.println(Arrays.toString(nums));
    }

    //向后走，向后冒
    private static void bubbleSort(int [] nums) {
        int len=nums.length;
        boolean swap=false;
        for (int i = 0; i <len- 1; i++) {
            swap=false;
            for (int j = 0; j < len - 1-i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swap=true;
                }
            }
            System.out.println(Arrays.toString(nums));
            if (!swap) {
                break;
            }
        }
    }

    //向前走，向前冒
    private static void bubbleSort2(int[] nums) {
        int len=nums.length;
        boolean swap=false;
        for (int i = len - 1; i > 0; i--) {
            swap=false;
            for (int j = len- 1; j > len - 1 - i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    swap=true;
                }
            }
            System.out.println(Arrays.toString(nums));
            if (!swap) {
                break;
            }
        }
    }

    //向后走，向前冒
    private static void bubbleSort3(int[] nums) {
        int len=nums.length;
        boolean swap=false;
        for (int i = 0; i <len- 1; i++) {
            swap=false;
            for (int j = i+1; j < len ; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, j, i);
                    swap=true;
                }
            }
            System.out.println(Arrays.toString(nums));
            if (!swap) {
                break;
            }
        }
    }

    private static void bubble4(int[] nums){
        int len=nums.length;
        boolean swap=false;
        for (int i = len-1; i >0 ; i--) {
            swap=false;
            for (int j = 0; j < i; j++) {
                if (nums[j] >nums[j+1]) {
                    swap(nums, j, j+1);
                    swap=true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }


    //冒泡排序之递归方法
    public static void recursiveBubble(int[] array) {
        recursiveBubble(array, array.length-1);
    }

    //冒泡排序之递归方法
    //right--归位索引
    private static void recursiveBubble(int[] array, int right) {
        if (right == 0) {
            return ;
        } else {
            boolean swap=false;
            for (int i = 0; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swap=true;
                }
            }
            System.out.println(right+"---"+Arrays.toString(array));
            if (!swap) {
                return ;
            }
            right--;
            //System.out.println(e);
            recursiveBubble(array, right);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}