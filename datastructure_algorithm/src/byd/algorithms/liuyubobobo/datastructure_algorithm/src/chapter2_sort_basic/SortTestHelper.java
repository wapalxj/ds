package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic;

import java.lang.reflect.Method;

/**
 * 随机生成测试用例
 */
public class SortTestHelper {

    //生成一个有n个元素的随机数组，每个元素随机范围为[rangeLeft,rangeRight]
    public static int[] generateRandomArray(int n, int rangeLeft, int rangeRight) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeRight - rangeLeft + 1) + rangeLeft);
        }
        return arr;
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, int[] arr){

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        // * 依然是，使用反射机制并不是这个课程的重点, 大家也完全可以使用自己的方式书写代码, 最终只要能够测试出自己书写的算法的效率即可
        // * 推荐大家阅读我在问答区向大家分享的一个学习心得: 【学习心得分享】请大家抓大放小，不要纠结于C++语言的语法细节
        // * 链接: http://coding.imooc.com/learn/questiondetail/4100.html
        try{
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort",new Class[]{int[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static int[] generateNearlyOrderedArray(int n, int swapTimes){

        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = i;

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }
    // 生成一个完全有序的数组
    public static int[] generateOrderedArray( int n ){

        return generateNearlyOrderedArray(n, 0);
    }

    // 生成一个完全逆序的数组
    public static int[] generateInversedArray( int n ){

        int[] arr = generateOrderedArray( n );
        for( int i = n/2 - 1 ; i >= 0 ; i -- ){
            Integer t = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = t;
        }
        return arr;
    }

    // 将数组arr随机化
    public static void shuffleArray( int[] arr ){
        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            int j = (int)(Math.random() * (n-i)) + i;

            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    // 拷贝数组
    public static int[] copyInArray(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }


    // 判断arr数组是否有序
    public static boolean isSorted(int[] arr){

        for( int i = 0 ; i < arr.length - 1 ; i ++ )
            if( arr[i]>(arr[i+1]) )
                return false;
        return true;
    }

    //交换
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
