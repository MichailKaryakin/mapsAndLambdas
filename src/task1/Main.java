package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Михаил", "И", 3));
        students.add(new Student("Николай", "И", 3));
        students.add(new Student("Андрей", "О", 1));
        students.add(new Student("Ярослав", "О", 1));
        students.add(new Student("Алексей", "Е", 2));
        students.add(new Student("Александр", "Е", 2));

        HashMap<String, ArrayList<String>> studentsMap = groupByYearAndFaculty(students);

        for (Map.Entry<String, ArrayList<String>> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static HashMap<String, ArrayList<String>> groupByYearAndFaculty(ArrayList<Student> students) {
        HashMap<String, ArrayList<String>> studentsMap = new HashMap<>();
        for (Student student : students) {
            String key = student.getYear() + "-" + student.getFaculty();
            if (!studentsMap.containsKey(key)) {
                studentsMap.put(key, new ArrayList<>());
                studentsMap.get(key).add(student.getName());
            } else {
                studentsMap.get(key).add(student.getName());
            }
        }
        return studentsMap;
    }
}
