package task1;

public class Student {
    private String name;
    private String faculty;
    private Integer year;

    public Student(String name, String faculty, Integer year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
