package composite.coursestudentscomposite.clients;

import composite.coursestudentscomposite.entities.Course;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "CourseClient")
public interface ICourseClient {

    @RequestLine("GET /{id}")
    Course getOneById(@Param("id") Long id);
}
