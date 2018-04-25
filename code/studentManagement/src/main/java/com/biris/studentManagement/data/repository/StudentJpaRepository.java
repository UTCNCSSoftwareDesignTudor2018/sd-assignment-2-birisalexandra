package com.biris.studentManagement.data.repository;

import com.biris.studentManagement.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

    public Student findByUsername(String username);
    public List<Student> findAll();
}
