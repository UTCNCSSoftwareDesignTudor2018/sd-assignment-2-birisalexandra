package com.biris.studentManagement.business;

import com.biris.studentManagement.data.entity.Grade;
import com.biris.studentManagement.data.repository.GradeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GradeService {

    @Autowired
    GradeJpaRepository gradeJpaRepository;

    public Grade findGrade (Integer id) {
        return gradeJpaRepository.findByEnroll(id);
    }

    public Grade addGrade(Grade s) {
        return gradeJpaRepository.save(s);
    }

}
