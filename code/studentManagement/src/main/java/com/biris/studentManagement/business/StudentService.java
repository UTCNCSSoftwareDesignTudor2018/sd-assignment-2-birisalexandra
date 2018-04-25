package com.biris.studentManagement.business;

import com.biris.studentManagement.data.entity.Student;
import com.biris.studentManagement.data.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    public Student getStudent(String username) {
       return studentJpaRepository.findByUsername(username);
    }

    public Optional<Student> findById(Integer id) {
        return studentJpaRepository.findById(id);
    }

    public void insertNewStudent(Student s) {
        studentJpaRepository.save(s);
    }

    public void updateAddress(Student s, String address) {
        s.setAddress(address);
        studentJpaRepository.save(s);
    }

    public void updateCardNumber(Student s, String card) {
        s.setCardNumber(card);
        studentJpaRepository.save(s);
    }

    public void updateName(Student s, String name) {
        s.setName(name);
        studentJpaRepository.save(s);
    }

    public List<Student> getAllStudents() {
        return studentJpaRepository.findAll();
    }

    public void deleteStudent(Student s) {
        studentJpaRepository.delete(s);
    }
}
