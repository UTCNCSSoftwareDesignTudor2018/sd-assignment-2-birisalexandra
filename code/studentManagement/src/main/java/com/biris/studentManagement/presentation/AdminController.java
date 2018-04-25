package com.biris.studentManagement.presentation;

import com.biris.studentManagement.business.EnrollService;
import com.biris.studentManagement.business.GradeService;
import com.biris.studentManagement.business.StudentService;
import com.biris.studentManagement.business.SubjectService;
import com.biris.studentManagement.data.entity.Enroll;
import com.biris.studentManagement.data.entity.Grade;
import com.biris.studentManagement.data.entity.Student;
import com.biris.studentManagement.data.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    ModelAndView mav;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    EnrollService enrollService;

    @Autowired
    GradeService gradeService;

    @GetMapping(value = "/adminLogIn")
    public ModelAndView initialize() {
        mav = new ModelAndView("admin");
        mav.addObject("subjects", subjectService.getAllSubjects());
        mav.addObject("students", studentService.getAllStudents());

        return mav;
    }

    @PostMapping(value = "/admin", params = "Add subject")
    public ModelAndView addSubject(@RequestParam(name="subject") String title) {
        Subject s = new Subject(0, title);
        subjectService.insertNew(s);
        mav.getModel().replace("subjects", subjectService.getAllSubjects());
        return mav;
    }

    @PostMapping(value = "/admin", params = "Delete")
    public ModelAndView deleteSubject(@RequestParam(name="student") String name) {
        Student s = studentService.getStudent(name);
        studentService.deleteStudent(s);

        mav.getModel().replace("students", studentService.getAllStudents());
        return mav;
    }

    @PostMapping(value = "/admin", params = "See grades")
    public ModelAndView seeGrade(@RequestParam(name="student") String username) {
        Student s = studentService.getStudent(username);
        mav.addObject("activeStudent", s);
        List<Enroll> enrollments = enrollService.findAll(s);
        List<Grade> grades = new ArrayList<>();
        for(Enroll e: enrollments) {
            grades.add(gradeService.findGrade(e.getEnrollId()));
        }
        mav.addObject("enrollments", enrollments);
        mav.addObject("grades", grades);
        return mav;
    }

    @PostMapping(value = "/admin", params = "Add grade")
    public ModelAndView addGrade(@RequestParam(name="subject") String subject,
                                 @RequestParam(name="grade") Integer grade) {
        Student stud = (Student) mav.getModel().get("activeStudent");
        Enroll e = enrollService.findEnroll(stud, subject);
        Grade g = gradeService.findGrade(e.getEnrollId());
        g.setGrade(grade);
        gradeService.addGrade(g);

        List<Enroll> enrollments = enrollService.findAll(stud);
        List<Grade> grades = new ArrayList<>();
        for(Enroll er: enrollments) {
            grades.add(gradeService.findGrade(er.getEnrollId()));
        }
        mav.getModel().replace("grades", grades);
        return mav;
    }


    @PostMapping(value = "/admin", params = "Insert student")
    public ModelAndView insertStudent(@RequestParam String name,
                                      @RequestParam String address,
                                      @RequestParam String cardNumber,
                                      @RequestParam String username,
                                      @RequestParam String password) {
        Student s = new Student.StudentBuilder().setStudentId(0).setName(name).setAddress(address).setCardNumber(cardNumber).setUsername(username).setPassword(password).build();
        studentService.insertNewStudent(s);
        mav.getModel().replace("students", studentService.getAllStudents());
        return mav;
    }
}
