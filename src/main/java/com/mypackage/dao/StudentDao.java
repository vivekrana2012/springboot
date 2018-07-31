package com.mypackage.dao;

import com.mypackage.entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    String removeStudentById(int id);

    String updateStudent(Student student);

    String insertStudent(Student student);
}
