package composite.coursestudentscomposite.entities;

import lombok.Data;

@Data
public class Student {
    private Long id;

    private String name;

    private String grade;

    private Long courseId;

    public Student(Long id, String name, String grade, Long courseId) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.courseId = courseId;
    }

}
