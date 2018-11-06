package composite.coursestudentscomposite.services;

import composite.coursestudentscomposite.clients.ICourseClient;
import composite.coursestudentscomposite.clients.IStudentClient;
import composite.coursestudentscomposite.entities.Course;
import composite.coursestudentscomposite.entities.CourseStudents;
import composite.coursestudentscomposite.entities.Student;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseStudentsServiceTest {

    @Mock
    private ICourseClient courseClient;

    @Mock
    private IStudentClient studentClient;

    private CourseStudentsService courseStudentsService = new CourseStudentsService();

    private static final Course COURSE_RESPONSE = new Course(1L, "Java");
    private List<Student> STUDENT_RESPONSE = new ArrayList<>();


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        courseStudentsService.setICourseClient(courseClient);
        courseStudentsService.setIStudentClient(studentClient);
    }

    @Test
    public void should_create_coursestudent_object(){
        STUDENT_RESPONSE.add(new Student(1L, "Tintin", "Bachelor3", 1L));
        Mockito.when(courseClient.getOneById(1L)).thenReturn(COURSE_RESPONSE);
        Mockito.when(studentClient.getAllByCourseId(1L)).thenReturn(STUDENT_RESPONSE);

        assertEquals(courseStudentsService.getOneById(1L), new CourseStudents(1L, "Java", STUDENT_RESPONSE));

    }

}