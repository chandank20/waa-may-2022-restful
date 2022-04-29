package com.example.proj01.service;

import com.example.proj01.domain.Course;
import com.example.proj01.domain.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    Student getStudentById(int id);

    void save(Student s);

    void delete(int id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int id);
}
