package composite.coursestudentscomposite.services;

import composite.coursestudentscomposite.clients.ICourseClient;
import composite.coursestudentscomposite.clients.IStudentClient;
import composite.coursestudentscomposite.entities.Course;
import composite.coursestudentscomposite.entities.CourseStudents;
import composite.coursestudentscomposite.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseStudentsService {


    private ICourseClient iCourseClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(ICourseClient.class, "http://localhost:8082/courses");


    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8083/students");



    public CourseStudents getOneById(Long courseId){

        log.info("Call to the Course core - getOneById : " + courseId);
        Course course = iCourseClient.getOneById(courseId);

        log.info("Call to the Student core - getAllByCourseId : " + courseId);
        List<Student> students = iStudentClient.getAllByCourseId(courseId);

        return new CourseStudents(course.getId(), course.getTitle(), students);
    }
}
