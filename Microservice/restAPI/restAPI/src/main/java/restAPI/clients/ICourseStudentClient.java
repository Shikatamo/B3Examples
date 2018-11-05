package restAPI.clients;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("CourseStudent")
public interface ICourseStudentClient {

    @RequestLine("GET /{id}")
    Object getOneById(@Param("id") Long id);

}
