package lb.utils;

public class SortingHelper {

    public static <E extends Comparable<E>> boolean isSorted(E[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            if (arrs[i - 1].compareTo(arrs[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
