package com.biris.studentManagement.business;

import com.biris.studentManagement.data.entity.Enroll;
import com.biris.studentManagement.data.entity.Student;
import com.biris.studentManagement.data.entity.Subject;
import com.biris.studentManagement.data.repository.EnrollJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollService {

    @Autowired
    EnrollJpaRepository enrollJpaRepository;

    public List<Enroll> findAll(Student s) {
        return enrollJpaRepository.findAllByStudent(s);
    }

    public void enrollToSubject(Enroll e) {
        enrollJpaRepository.save(e);
    }

    public Enroll findEnroll(Student student, String subject) {
        return enrollJpaRepository.findEnrollment(student, subject);
    }


}
