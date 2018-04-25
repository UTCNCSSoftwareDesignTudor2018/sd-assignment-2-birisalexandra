package com.biris.studentManagement.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "enroll")
public class Enroll {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "enroll_id")
    private Integer enrollId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Enroll() {

    }

    public Enroll(Integer id, Student stud, Subject sub) {
        this.enrollId = id;
        this.student = stud;
        this.subject = sub;
    }

    public Integer getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Integer enrollId) {
        this.enrollId = enrollId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Enroll{" +
                "enrollId=" + enrollId +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
