package composite.coursestudentscomposite.entities;

import lombok.Data;

@Data
public class Course {

    private Long id;

    private String title;

    public Course() {

    }

    public Course(String title) {
        this.title = title;
    }

    public Course(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
