package com.example.proj01.controller;

import com.example.proj01.domain.Course;
import com.example.proj01.domain.Student;
import com.example.proj01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.status(403).body(studentService.getAll());
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void save(@RequestBody Student s){
        studentService.save(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @GetMapping(value = "api/v2/students/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major){
        return ResponseEntity.status(405).body(studentService.getStudentsByMajor(major));
    }


    @GetMapping(value = "api/v2/students/sid/{id}")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable int id){
        return ResponseEntity.status(406).body(studentService.getCoursesByStudentId(id));
    }

}
