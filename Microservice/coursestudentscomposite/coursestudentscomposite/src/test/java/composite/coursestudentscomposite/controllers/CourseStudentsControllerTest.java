package composite.coursestudentscomposite.controllers;

import composite.coursestudentscomposite.entities.CourseStudents;
import composite.coursestudentscomposite.entities.Student;
import composite.coursestudentscomposite.services.CourseStudentsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CourseStudentsControllerTest {

    @Mock
    private CourseStudentsService courseStudentsService;

    @Autowired
    private CourseStudentsController courseStudentsController;

    @Autowired
    private MockMvc mockMvc;

    private static final String CONTROLLER_RESPONSE = "{\"id\":1," +
            "\"name\":\"Java\"," +
            "\"students\":[" +
            "{\"id\":1," +
            "\"name\":\"Tintin\"," +
            "\"grade\":\"Bachelor 3\"," +
            "\"courseId\":1}" +
            "]}";

    private List<Student> STUDENT_RESPONSE = new ArrayList<>();


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        courseStudentsController.setCourseStudentsService(courseStudentsService);
    }

    @Test
    public void should_return_valid_response() throws Exception {
        STUDENT_RESPONSE.add(new Student(1L,"Tintin", "Bachelor 3", 1L));
        Mockito.when(courseStudentsService.getOneById(1L)).thenReturn(new CourseStudents(1L, "Java", STUDENT_RESPONSE));
        this.mockMvc.perform(get("/courseStudents/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(CONTROLLER_RESPONSE)));
    }
}