package task5;

import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentDistribution distribution = new StudentDistribution();
    private final StudentGrades grades = new StudentGrades();

    public static void main(String[] args) {
        new Main().menu();
    }

    public void menu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    ===== StudentDistribution =====
                    1 - Добавить предмет и список студентов
                    2 - Добавить студента к предмету
                    3 - Удалить студента из предмета
                    7 - Показать предметы и студентов
                    
                    ===== StudentGrades =====
                    4 - Добавить студента с оценками
                    5 - Добавить предмет студенту
                    6 - Удалить студента
                    8 - Показать студентов и оценки
                    
                    0 - Выход
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addSubjectWithStudents();
                case 2 -> addStudentToSubject();
                case 3 -> deleteStudentFromSubject();
                case 4 -> addStudentWithGrades();
                case 5 -> addSubjectToStudent();
                case 6 -> deleteStudent();
                case 7 -> distribution.printSubjectsAndStudents();
                case 8 -> grades.printStudentsAndSubjects();
                case 0 -> exit = true;
                default -> System.out.println("Нет такой опции");
            }
        }
    }

    private void addSubjectWithStudents() {
        Subject subject = readSubject();
        List<Student> students = new ArrayList<>();

        boolean addMore = true;
        while (addMore) {
            students.add(readStudent());
            System.out.print("Добавить ещё студента? (y/n): ");
            addMore = scanner.nextLine().equalsIgnoreCase("y");
        }

        boolean added = distribution.addSubjectAndStudents(subject, students);
        System.out.println(added ? "Предмет добавлен" : "Предмет уже существует");
    }

    private void addStudentToSubject() {
        Student student = readStudent();
        Subject subject = readSubject();

        boolean added = distribution.addStudentToExistingSubject(student, subject);
        System.out.println(added ? "Студент добавлен" : "Предмет не найден");
    }

    private void deleteStudentFromSubject() {
        Student student = readStudent();
        Subject subject = readSubject();

        boolean deleted = distribution.deleteStudentFromExistingSubject(student, subject);
        System.out.println(deleted ? "Студент удалён" : "Студент или предмет не найден");
    }

    private void addStudentWithGrades() {
        Student student = readStudent();
        Map<Subject, Integer> subjectGrades = new HashMap<>();

        boolean addMore = true;
        while (addMore) {
            Subject subject = readSubject();
            System.out.print("Оценка: ");
            int grade = scanner.nextInt();
            scanner.nextLine();

            subjectGrades.put(subject, grade);

            System.out.print("Добавить ещё предмет? (y/n): ");
            addMore = scanner.nextLine().equalsIgnoreCase("y");
        }

        boolean added = grades.addStudentAndSubjects(student, subjectGrades);
        System.out.println(added ? "Студент добавлен" : "Студент уже существует");
    }

    private void addSubjectToStudent() {
        Student student = readStudent();
        Subject subject = readSubject();

        System.out.print("Оценка: ");
        int grade = scanner.nextInt();
        scanner.nextLine();

        boolean added = grades.addSubject(student, Map.entry(subject, grade));
        System.out.println(added ? "Предмет добавлен" : "Студент не найден");
    }

    private void deleteStudent() {
        Student student = readStudent();
        boolean deleted = grades.deleteStudent(student);
        System.out.println(deleted ? "Студент удалён" : "Студент не найден");
    }

    private Student readStudent() {
        System.out.print("ID студента: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Имя студента: ");
        String name = scanner.nextLine();

        return new Student(id, name);
    }

    private Subject readSubject() {
        System.out.print("ID предмета: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Название предмета: ");
        String name = scanner.nextLine();

        return new Subject(id, name);
    }
}
