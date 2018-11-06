package composite.coursestudentscomposite.entities;

import com.fasterxml.jackson.annotation.JsonValue;
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
