package composite.coursestudentscomposite.controllers;

import composite.coursestudentscomposite.entities.CourseStudents;
import composite.coursestudentscomposite.services.CourseStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CourseStudentsController {

    @Autowired
    CourseStudentsService courseStudentsService;

    @RequestMapping("/courseStudents/{id}")
    ResponseEntity<CourseStudents> getOne(@PathVariable Long id) {
                return new ResponseEntity<>(courseStudentsService.getOneById(id), HttpStatus.OK);
    }

}
