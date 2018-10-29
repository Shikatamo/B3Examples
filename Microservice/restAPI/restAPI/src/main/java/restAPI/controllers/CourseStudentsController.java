package restAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restAPI.models.CourseStudents;
import restAPI.services.CourseStudentService;

@RestController
public class CourseStudentsController {

    @Autowired
    CourseStudentService courseStudentService;

    @RequestMapping("/courseStudents/{id}")
    ResponseEntity getOne(@PathVariable Long id) {

        return courseStudentService.getOneCourseStudent(id);
    }
}
