package com.mypackage.service;

import com.mypackage.dao.StudentRepo;
import com.mypackage.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
     private StudentRepo studentRepo;

    public Iterable<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student getStudentById(int id){
        return studentRepo.getStudentById(id);
    }

    public String removeStudentById(int id){
        studentRepo.delete(id);
        return "ok";
    }

    public String updateStudent(Student student){
        studentRepo.delete(student.getId());
        studentRepo.save(student);
        return "ok";
    }

    public String insertStudent(Student student){
        studentRepo.save(student);
        return "ok";
    }

    public List<Student> getStudentByName(String name) {
        return studentRepo.getStudentByName(name, new Sort("id"));
    }
}
