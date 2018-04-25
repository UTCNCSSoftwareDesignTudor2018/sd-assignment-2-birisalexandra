package com.biris.studentManagement.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String cardNumber;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "enroll",
            joinColumns = { @JoinColumn(name = "student_id")},
            inverseJoinColumns = { @JoinColumn(name = "subject_id")})

    private List<Subject> courses = new ArrayList<>();

    public Student() {
    }

    public Student(StudentBuilder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.address = builder.address;
        this.cardNumber = builder.cardNumber;
        this.username = builder.username;
        this.password = builder.password;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Subject> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private Integer studentId;
        private String name;
        private String address;
        private String cardNumber;
        private String username;
        private String password;

        public StudentBuilder setStudentId(Integer studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public StudentBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public StudentBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
