package com.mypackage.dao;

import com.mypackage.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

    @Query(value = "select * from student where id = ?1", nativeQuery = true)
    public Student getStudentById(int id);

    @Query(value = "select * from student where name = :name")
    public List<Student> getStudentByName(@Param(value = "name") String name, Sort sort);
}
