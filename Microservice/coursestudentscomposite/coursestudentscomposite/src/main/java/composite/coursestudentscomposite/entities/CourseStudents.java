package composite.coursestudentscomposite.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseStudents {

    private Long id;
    private String name;
    private List<Student> students;
}
