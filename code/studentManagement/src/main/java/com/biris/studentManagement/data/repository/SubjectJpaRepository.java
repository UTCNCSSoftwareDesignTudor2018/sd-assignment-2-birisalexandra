package com.biris.studentManagement.data.repository;

import com.biris.studentManagement.data.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectJpaRepository extends JpaRepository<Subject, Integer> {

    public List<Subject> findAll();
    public Optional<Subject> findById(Integer subjectId);
    public Subject findByTitle(String title);
}
