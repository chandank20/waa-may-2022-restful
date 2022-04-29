package com.example.proj01.controller;

import com.example.proj01.domain.Course;
import com.example.proj01.domain.Student;
import com.example.proj01.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAll(){
        return ResponseEntity.status(403).body(courseService.getAll());
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

}
