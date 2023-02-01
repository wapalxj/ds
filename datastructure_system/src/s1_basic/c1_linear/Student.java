package s1_basic.c1_linear;

import java.util.Objects;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object student) {
        if (this == student) return true;
        if (!(student instanceof Student)) return false;
        Student another = (Student) student;
        return Objects.equals(name.toLowerCase(), another.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
