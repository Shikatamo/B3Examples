package composite.coursestudentscomposite.entities;

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

}
