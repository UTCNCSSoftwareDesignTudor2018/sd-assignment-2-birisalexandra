package com.biris.studentManagement.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId;

    @Column
    private String title;

    public Subject() {
    }

    public Subject(Integer subjectId, String title) {
        this.subjectId = subjectId;
        this.title = title;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", title='" + title + '\'' +
                '}';
    }
}
