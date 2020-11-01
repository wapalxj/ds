package byd.algorithms.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1_move_zero {

    public static void main(String[] args) {
//        int[] arr = {0,1,2,3,4, 5, 6};
//        int[] arr = {1, 0, 2, 3, 0, 0, 4, 5, 6};
//        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0, 6};
        int[] arr = {1, 0, 2, 0, 3,0};
        move(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZero1(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                list.add(arr[i]);
            }
        }
        int l = list.size();
        for (int i = 0; i < arr.length - l; i++) {
            list.add(0);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    public static void moveZero2(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                j = i + 1;
                while (arr[j] == 0) {
                    j++;
                    if (j >= arr.length) {
                        return;
                    }
                }
                swap(arr, i, j);
            }
        }
    }

    public static void moveZero3(int[] arr) {
        int j = 0;
        int nums=0;//0的数目
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                j = i + 1;
                while (arr[j] == 0) {
                    j++;
                    if (j >= arr.length) {
                        return;
                    }
                }
                nums+=(j-i);
                System.arraycopy(arr, j, arr, i, arr.length - j);
                System.out.println(Arrays.toString(arr));
            }
        }
        for (int i = 0; i < nums; i++) {
            arr[arr.length-1-i]=0;
        }

    }


    public static void move(int[] arr){
        int len=arr.length;
        int k=0;//[0,k)
        for (int i = 0; i < len; i++) {
            if (arr[i]>0) {
                swap(arr,k,i);
                k++;
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}