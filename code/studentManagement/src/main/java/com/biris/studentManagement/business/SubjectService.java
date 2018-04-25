package com.biris.studentManagement.business;

import com.biris.studentManagement.data.entity.Subject;
import com.biris.studentManagement.data.repository.SubjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectJpaRepository subjectJpaRepository;

    public Subject findById(Integer id) {
        return subjectJpaRepository.findById(id).get();
    }

    public List<Subject> getAllSubjects() {
        return subjectJpaRepository.findAll();
    }

    public void insertNew(Subject s) {
        subjectJpaRepository.save(s);
    }

    public Subject findByTitle(String title) {
        return subjectJpaRepository.findByTitle(title);
    }
}
