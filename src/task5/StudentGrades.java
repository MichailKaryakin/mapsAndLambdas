package task5;

import java.util.HashMap;
import java.util.Map;

public class StudentGrades {

    private final HashMap<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();

    public boolean addStudentAndSubjects(Student student, Map<Subject, Integer> subjects) {
        if (studentGrades.containsKey(student)) {
            return false;
        } else {
            studentGrades.put(student, subjects);
            return true;
        }
    }

    public boolean addSubject(Student student, Map.Entry<Subject, Integer> subject) {
        if (studentGrades.containsKey(student)) {
            studentGrades.get(student).put(subject.getKey(), subject.getValue());
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStudent(Student student) {
        if (studentGrades.containsKey(student)) {
            studentGrades.remove(student);
            return true;
        } else {
            return false;
        }
    }

    public void printStudentsAndSubjects() {
        if (studentGrades.isEmpty()) {
            System.out.println("Нет студентов");
            return;
        }

        for (var entry : studentGrades.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> subjects = entry.getValue();

            System.out.println("Студент: " + student.getName());
            if (subjects.isEmpty()) {
                System.out.println("  Нет предметов");
            } else {
                for (var subjectEntry : subjects.entrySet()) {
                    System.out.println(
                            "  " + subjectEntry.getKey().getName()
                                    + " — " + subjectEntry.getValue()
                    );
                }
            }
        }
    }
}
