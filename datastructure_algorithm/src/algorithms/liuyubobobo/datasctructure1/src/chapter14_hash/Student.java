package algorithms.liuyubobobo.datasctructure1.src.chapter14_hash;

public class Student {
    int grade;
    int cls;
    private String name;

    public Student(int grade, int cls, String name) {
        this.grade = grade;
        this.cls = cls;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int B = 31;//假定B为31
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + name.toLowerCase().hashCode();
        return hash;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Student anthor = (Student) o;

        return this.grade == anthor.grade &&
                this.cls == anthor.cls &&
                this.name.toLowerCase().equals(anthor.name.toLowerCase())
                ;
    }
}
