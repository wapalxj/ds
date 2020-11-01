package chapter14_hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * java中的hashCode()
 */
public class UseJavaHashCode {
    public static void main(String[] args) {
        int a = 42;
        System.out.println("45--hashCode==" + ((Integer) a).hashCode());

        int b = -42;
        System.out.println("-42--hashCode==" + ((Integer) b).hashCode());

        double c = 3.14;
        System.out.println("3.14--hashCode==" + ((Double) c).hashCode());

        String d = "vero";
        System.out.println("\"vero\"--hashCode==" + d.hashCode());


        Student student=new Student(3,2,"vero");
        System.out.println("\"student\"--hashCode==" + student.hashCode());


        HashSet<Student> set=new HashSet<>();
        set.add(student);

        HashMap<Student,Integer> scores=new HashMap<>();
        scores.put(student,100);
    }

}
