package chapter_3_array.C3_5_Sort_Colors.practice;

import java.util.Arrays;

public class p1_LeetCode88_Merger_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("归并前---"+Arrays.toString(nums1));
        mergeInternal(nums1,m,nums2,n);
        System.out.println("归并后---"+Arrays.toString(nums1));
    }

    //mid:左边数组的最后一个位置
    //将arr[l...mid]和arr[mid+1...r]两部分进行归并
    public static void mergeInternal(int[] nums1, int m, int[] nums2, int n) {
        //开辟一个辅助空间aux，
        int[] aux=new int [m+n];
        for (int i = 0; i <m; i++) {
            aux[i]=nums1[i];
        }
        for (int i = 0; i <n; i++) {
            aux[i+m]=nums2[i];
        }

        int left=0;
        int mid=m-1;
        int i=left,j=mid+1;
        for (int k = left; k <=m+n-1 ; k++) {
            if (i >mid) {
                //左边越界，则全取右边的数
                nums1[k]=aux[j-left];
                j++;
            }else if (j >m+n-1) {
                //右边越界，则全取左边的数
                nums1[k]=aux[i-left];
                i++;
            }else if (aux[i-left]<aux[j-left]) {
                nums1[k]=aux[i-left];
                i++;
            }else {
                nums1[k]=aux[j-left];
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
    }
}
