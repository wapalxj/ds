package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_2_time_complexity.testComplexity;

public class TestNlogN {
    public static void main(String[] args) {

        // 数据规模倍乘测试mergeSort
        // O(nlogn)

        System.out.println("TestPrintStars for Merge Sort:");
        for( int i = 10 ; i <= 26 ; i ++ ){

            int n = (int)Math.pow(2,i);
            Integer[] arr = MyUtil.generateRandomArray(n, 0, 1<<30);

            long startTime = System.currentTimeMillis();
            MyAlgorithmTester.mergeSort(arr, n);
            long endTime = System.currentTimeMillis();

            System.out.print("data size 2^" + i + " = " + n + "\t");
            System.out.println("Time cost: " + (endTime - startTime) + " s");
        }
    }
}
