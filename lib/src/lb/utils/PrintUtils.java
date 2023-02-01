package lb.utils;

public class PrintUtils {
    public static <E> void printArr(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
