package task5;

import java.util.HashMap;
import java.util.List;

public class StudentDistribution {

    private final HashMap<Subject, List<Student>> studentDistribution = new HashMap<>();

    public boolean addSubjectAndStudents(Subject subject, List<Student> students) {
        if (studentDistribution.containsKey(subject)) {
            return false;
        } else {
            studentDistribution.put(subject, students);
            return true;
        }
    }

    public boolean addStudentToExistingSubject(Student student, Subject subject) {
        if (studentDistribution.containsKey(subject)) {
            studentDistribution.get(subject).add(student);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStudentFromExistingSubject(Student student, Subject subject) {
        if (studentDistribution.containsKey(subject)) {
            List<Student> students = studentDistribution.get(subject);
            if (students.contains(student)) {
                students.remove(student);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void printSubjectsAndStudents() {
        if (studentDistribution.isEmpty()) {
            System.out.println("Нет предметов");
            return;
        }

        for (var entry : studentDistribution.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("Предмет: " + subject.getName());
            if (students.isEmpty()) {
                System.out.println("  Студентов нет");
            } else {
                for (Student student : students) {
                    System.out.println("  " + student.getId() + " - " + student.getName());
                }
            }
        }
    }
}
