import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Student {
    int id;
    double cgpa;
    String name;


    public Student(int id, double cgpa, String name) {
        this.id = id;
        this.cgpa = cgpa;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", cgpa=" + cgpa +
                ", name='" + name + '\'' +
                '}';
    }
}

public class StudentSort {
    public static void main(String[] args) {
        Queue<Student> students = new PriorityQueue<Student>(Comparator.comparing(student -> student.cgpa));
        for (int i = 0; i < 5; i++) {
            students.add(new Student(i, ((i * 33) / 3.142), "Test" + i));
        }

        students.add(new Student(22, ((5 * 33) / 3.142), "Test" + 5));
        students.add(new Student(22, ((100 * 33) / 3.142), "Test" + 5));
        students.add(new Student(22, ((100 * 33) / 333.142), "Test" + 5));

        while (!students.isEmpty()) {
            System.out.println(students.poll());
        }
    }
}
