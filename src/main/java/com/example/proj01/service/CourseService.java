package com.example.proj01.service;

import com.example.proj01.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAll();

    Course getCourseById(int id);

    void save(Course c);

    void delete(int id);

}
