package com.biris.studentManagement.data.repository;

import com.biris.studentManagement.data.entity.Enroll;
import com.biris.studentManagement.data.entity.Student;
import com.biris.studentManagement.data.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollJpaRepository extends JpaRepository<Enroll, Integer> {

    public List<Enroll> findAllByStudent(Student student);

    @Query("FROM Enroll WHERE student = :stud AND subject.title = :sub")
    public Enroll findEnrollment(@Param("stud") Student student,
                                 @Param("sub") String subject);
}
