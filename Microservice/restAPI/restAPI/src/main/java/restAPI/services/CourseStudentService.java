package restAPI.services;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import restAPI.clients.ICourseStudentClient;
import restAPI.models.CourseStudents;


@Service
@Slf4j
public class CourseStudentService {


    private ICourseStudentClient iCourseStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(ICourseStudentClient.class, "http://localhost:8084/courseStudents");

    public ResponseEntity<String> getOneCourseStudent(Long id){

        log.info("Call to the CourseStudent composite getOneById : " + id);
        return iCourseStudentClient.getOneById(id);
    }

}
