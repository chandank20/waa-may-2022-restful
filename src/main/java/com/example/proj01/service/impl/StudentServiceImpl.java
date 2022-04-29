package com.example.proj01.service.impl;

import com.example.proj01.domain.Course;
import com.example.proj01.domain.Student;
import com.example.proj01.repository.StudentRepo;
import com.example.proj01.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public List<Student> getAll(){
        return studentRepo.getAll();
    }

    @Override
    public void save(Student s){
        studentRepo.save(s);
    }

    @Override
    public void delete(int id){
        studentRepo.delete(id);
    }

    @Override
    public Student getStudentById(int id){
        return studentRepo.getStudentById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id){
        return studentRepo.getCoursesByStudentId(id);
    }
}
