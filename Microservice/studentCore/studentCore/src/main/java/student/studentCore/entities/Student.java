package student.studentCore.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="PRIVATE_SEQ_STUDENT", sequenceName="private_sequence")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ_STUDENT")
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
