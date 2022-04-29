package com.example.proj01.service.impl;

import com.example.proj01.domain.Course;
import com.example.proj01.repository.CourseRepo;
import com.example.proj01.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public List<Course> getAll(){
        return courseRepo.getAll();
    }

    @Override
    public void save(Course c){
        courseRepo.save(c);
    }

    @Override
    public void delete(int i){
        courseRepo.delete(i);
    }

    @Override
    public Course getCourseById(int id){
        return courseRepo.getCourseById(id);
    }
}
