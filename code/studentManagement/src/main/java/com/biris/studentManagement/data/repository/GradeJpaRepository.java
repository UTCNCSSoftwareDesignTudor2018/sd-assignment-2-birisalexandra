package com.biris.studentManagement.data.repository;

import com.biris.studentManagement.data.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface GradeJpaRepository extends JpaRepository<Grade, Integer> {

    @Query("FROM Grade WHERE enroll_id = :id")
    public Grade findByEnroll(@Param("id") Integer enrollId);
}
