package com.mypackage.controller;

import com.mypackage.entity.Student;
import com.mypackage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public List<Student> getStudentByName(@PathVariable(value = "name", required = true) String name){
        return studentService.getStudentByName(name);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable(value="id", required = true) int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
    public String removeStudentById(@PathVariable(value="id", required = true) int id){
        return studentService.removeStudentById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@Valid @RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertStudent(@Valid @RequestBody Student student){
        return studentService.insertStudent(student);
    }
}
