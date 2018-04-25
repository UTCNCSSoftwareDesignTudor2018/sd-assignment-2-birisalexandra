package com.biris.studentManagement.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Integer gradeId;

    @OneToOne
    @JoinColumn(name = "enroll_id")
    private Enroll enroll;

    @Column(name = "grade")
    private Integer grade;

    public Grade() {

    }

    public Grade(Integer gradeId, Enroll enroll, Integer grade) {
        this.gradeId = gradeId;
        this.enroll = enroll;
        this.grade = grade;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Enroll getEnroll() {
        return enroll;
    }

    public void setEnroll(Enroll enroll) {
        this.enroll = enroll;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
