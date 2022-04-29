package com.example.proj01.repository;

import com.example.proj01.domain.Course;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
//    private static ArrayList<Course> courses = new ManagedList<>();

    private static List<Course> courses;
    static {
        courses = new ArrayList<>();
        var c = new Course();
        c.setId(1);
        c.setName("WAA");
        c.setCode("454");
        courses.add((c));

        var c1 = new Course();
        c1.setId(2);
        c1.setName("SWE");
        c1.setCode("472");
        courses.add((c1));
    }

    public List<Course> getAll(){
        return courses;
    }

    public Course getCourseById(int id){
        return courses.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public void save(Course c){
        courses.add(c);
    }

    public void delete(int id){
        courses.stream()
                .filter(i -> i.getId() == id).forEach(i -> courses.remove(i));
    }

}
