package course.courseCore.controllers;

import course.courseCore.entities.Course;
import course.courseCore.exceptions.CourseNotFoundException;
import course.courseCore.repositories.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    List<Course> getAll() {
        return courseRepository.findAll();
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    Course newCourse(@RequestBody Course newCourse) {
        return courseRepository.save(newCourse);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    Course getOne(@PathVariable Long id) {
        log.info("Retrieving course with id : " + id);
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @PutMapping("/courses/{id}")
    Course replaceCourse(@RequestBody Course newCourse, @PathVariable Long id) {

        return courseRepository.findById(id)
                .map(course -> {
                    course.setTitle(newCourse.getTitle());
                    return courseRepository.save(course);
                })
                .orElseGet(() -> {
                    newCourse.setId(id);
                    return courseRepository.save(newCourse);
                });
    }

    @DeleteMapping("/courses/{id}")
    void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

}
