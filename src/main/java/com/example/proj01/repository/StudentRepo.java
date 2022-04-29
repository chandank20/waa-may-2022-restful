package com.example.proj01.repository;

import com.example.proj01.domain.Course;
import com.example.proj01.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    private static List<Student> students;

    ArrayList<Course> courses = new ArrayList<>();

    StudentRepo() {
        students = new ArrayList<>();
        var s = new Student();
        s.setId(1);
        s.setFirstName("Rony");
        s.setLastName("Shaha");
        s.setEmail("rony@gmail.com");
        s.setMajor("MPP");
//Add multiple Courses
        ArrayList<Course> courses = new ArrayList<>();
        s.setCoursesTaken(courses);

        Course c= new Course();
        c.setId(1);
        c.setCode("424");
        c.setName("WAP");
        Course c1= new Course();
        c1.setId(2);
        c1.setCode("543");
        c1.setName("Big Data");
        courses.add(c);
        courses.add(c1);

        students.add((s));

        var s1 = new Student();
        s1.setId(2);
        s1.setFirstName("Omur");
        s1.setLastName("Faruqe");
        s1.setEmail("faruq@gmail.com");
        s1.setMajor("SWA");
//Add Multiple Course
        ArrayList<Course> courses1 = new ArrayList<>();
        s1.setCoursesTaken(courses1);

        Course c2= new Course();
        c2.setId(1);
        c2.setCode("424");
        c2.setName("WAP");
        Course c3= new Course();
        c3.setId(2);
        c3.setCode("534");
        c3.setName("SWA");

        courses1.add(c2);
        courses1.add(c3);

        students.add((s1));
    }

    public List<Student> getAll(){
        return students;
    }

    public Student getStudentById(int id){
        return students.stream().filter(i ->i.getId() == id).findFirst().orElse(null);
    }

    public void save(Student s){
        students.add(s);
    }

    public void delete(int id){
        students
                .stream()
                .filter(i ->i.getId() == id)
                .forEach(i -> students.remove(i));
    }

    public List<Student> getStudentByMajor(String major){
        return students.stream().filter(i -> i.getMajor() == major).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id){
        return students.stream().filter(i ->i.getId() == id)
                .map(student -> student.getCoursesTaken())
                .flatMap(c ->c.stream())
                .collect(Collectors.toList());
    }

}
