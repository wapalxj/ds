package c2_linear;

/**
 * 线性查找法
 */
public class LinearSearch {
    private LinearSearch() {
    }

    public static void main(String[] args) {
        Integer target = 16;
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 12};
//        System.out.println(search(data, target));


        Student[] students = {
                new Student("vvvvvvvvv"),
                new Student("Veero"),
                new Student("vnixxxxxxxxxx")};

        Student t=new Student("veero");
        System.out.println(search(students, t));
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
