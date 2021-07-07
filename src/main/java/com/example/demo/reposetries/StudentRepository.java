package com.example.demo.reposetries;
import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student,Integer> {
    Student findByName(String name);
    Student findByGPA(int gpa);
}
