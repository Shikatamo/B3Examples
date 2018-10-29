package student.studentCore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.studentCore.entities.Student;
import student.studentCore.exceptions.StudentNotFoundException;
import student.studentCore.repositories.StudentRepository;

import java.util.List;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    List<Student> getAll() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    Student newStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @RequestMapping(value = "/students/course/{courseId}", method = RequestMethod.GET)
    List<Student> studentsByCourseId(@PathVariable Long courseId) {
        log.info("Retrieving students where course id = " + courseId);
        return studentRepository.getAllByCourseId(courseId);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    Student getOne(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
    @PutMapping("/students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {

        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setGrade(newStudent.getGrade());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
    
    
}
