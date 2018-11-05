package composite.coursestudentscomposite.clients;


import composite.coursestudentscomposite.entities.Student;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name="StudentClient", url="http://localhost:8083/students", configuration = ClientConfiguration.class)
public interface IStudentClient {

    @RequestLine("GET /course/{id}")
    List<Student> getAllByCourseId(@Param("id") Long id);
}
