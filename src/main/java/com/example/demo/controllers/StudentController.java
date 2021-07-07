package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {
    @Autowired
    private StudentSrevice service;


    @GetMapping("/students/static")
    public List<Student> findAllStaticStudents() {

        ArrayList<Student> testArrayList = new ArrayList<Student>();

        testArrayList.add(new Student("azmi wahdan"));
        testArrayList.add(new Student("ramiz abufarha"));
        testArrayList.add(new Student("abdallah jaber"));


        List<Student> list = new ArrayList<>();
        for (Student student : testArrayList) {
            list.add(student);
        }

        return list;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PostMapping("/students/many")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return service.saveStudents(students);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return service.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @GetMapping("/students/name/{name}")
    public Student findStudentByName(@PathVariable String name) {
        return service.getStudentByName(name);
    }

    @GetMapping("/students/count")
    public int countStudents() {
        return service.getNumberOfStudents();
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}
