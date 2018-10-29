package course.courseCore.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="PRIVATE_SEQ_COURSE", sequenceName="private_sequence")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ_COURSE")
    private Long id;

    private String title;

    public Course() {

    }

    public Course(String title) {
        this.title = title;
    }
}
