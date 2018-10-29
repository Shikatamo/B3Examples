package restAPI.models.students;

import lombok.Data;

@Data
public class Student {

    private Long id;

    private String name;

    private String grade;

    private Long courseId;

    public Student(String name, String grade, Long courseId) {
        this.name = name;
        this.grade = grade;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
