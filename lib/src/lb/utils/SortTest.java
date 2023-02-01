package lb.utils;

public class SortTest {

    public static <E extends Comparable<E>> void sortTest(Sortable<E> sortable) {
        sortTest(sortable,true);
    }
    public static <E extends Comparable<E>> void sortTestOnly(Sortable<E> sortable) {
        sortTest(sortable,false);
    }

    public static <E extends Comparable<E>> void sortTest(Sortable<E> sortable,boolean show) {
        long start = System.currentTimeMillis();
        E[] res = sortable.sort();
        long end = System.currentTimeMillis();

        double time = (end - start) / 1000.0;
        if (!SortingHelper.isSorted(res)) {
            throw new RuntimeException("sort failed");
        }
        System.out.println(time + " s");

        if (show) {
            PrintUtils.printArr(res);
        }
    }

    public interface Sortable<E> {
        E[] sort();
    }
}
