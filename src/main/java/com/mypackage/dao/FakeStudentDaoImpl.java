package com.mypackage.dao;

import com.mypackage.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class FakeStudentDaoImpl implements StudentDao {

    private static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
    static {
        students.put(1, new Student(1, "vivek", "computer science"));
        students.put(2, new Student(2, "rahul", "physics"));
        students.put(3, new Student(3, "ankit", "electrical"));
    }

    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    @Override
    public String removeStudentById(int id){
        this.students.remove(id);

        if(this.students.containsKey(id))    return "failure";
        else
            return "ok";
    }

    @Override
    public String updateStudent(Student student){
        this.students.put(student.getId(), student);
        return "ok";
    }

    @Override
    public String insertStudent(Student student){
        this.students.put(student.getId(), student);
        return "ok";
    }
}
