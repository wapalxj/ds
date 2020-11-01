package byd.algorithms.liuyubobobo.datasctructure1.src.chapter1_array;

import java.util.ArrayList;

public class C2_1_array {
    public static void main(String[] args) {
        Array<Integer> array=new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);


        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

//        ----------------------------------------
        Array<Integer>  array2=new Array<>(20);
        array2.addLast(1);
        array2.addLast(2);
        array2.addLast(3);
        array2.addLast(4);
        array2.addLast(3);
        array2.addLast(4);
        array2.addLast(3);
        array2.addLast(3);
        array2.addLast(7);

        array2.removeAllElement(3);
        System.out.println(array2);
    }
}
