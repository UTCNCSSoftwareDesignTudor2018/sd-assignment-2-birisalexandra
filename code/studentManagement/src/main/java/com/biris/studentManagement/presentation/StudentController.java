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

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;


@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    EnrollService enrollService;

    @Autowired
    GradeService gradeService;

    ModelAndView mav;

    @GetMapping(value = "/logIn")
    public ModelAndView logIn(@RequestParam(name = "username") String username) {
        Student student = studentService.getStudent(username);
        mav = new ModelAndView("student");
        mav.addObject("student", student);

        List<Subject> sub = subjectService.getAllSubjects();
        mav.addObject("allSubjects", sub);

        List<Enroll> enrollments = enrollService.findAll(student);
        mav.addObject("enrollments", enrollments);
        List<Grade> grades = new ArrayList<>();
        for(Enroll e: enrollments) {
            grades.add(gradeService.findGrade(e.getEnrollId()));
        }
        mav.addObject("grades", grades);
        return mav;
    }

    @PostMapping(value = "/student", params = "Change name")
    public ModelAndView changeName(@RequestParam(name="name") String name) {
        Student s = (Student)mav.getModel().get("student");
        studentService.updateName(s, name);
        return mav;
    }

    @PostMapping(value = "/student", params = "Change address")
    public ModelAndView changeAddress(@RequestParam(name="address") String address) {
        Student s = (Student)mav.getModel().get("student");
        studentService.updateAddress(s, address);
        return mav;
    }

    @PostMapping(value = "/student", params = "Change card")
    public ModelAndView changeCard(@RequestParam(name="cardNumber") String card) {
        Student s = (Student)mav.getModel().get("student");
        studentService.updateCardNumber(s, card);
        return mav;
    }

    @PostMapping(value = "/student", params = "Enroll")
    public ModelAndView enroll(@RequestParam(name = "class") String sub) {
        Student student = (Student)mav.getModel().get("student");
        Subject subject = subjectService.findByTitle(sub);
        enrollService.enrollToSubject(new Enroll(0, student, subject));

        mav.getModel().replace("enrollments", enrollService.findAll(student));
        gradeService.addGrade(new Grade(0, enrollService.findEnroll(student, sub), 0));

        List<Grade> grades = new ArrayList<>();
        for(Enroll enr: (List<Enroll>)mav.getModel().get("enrollments")) {
            grades.add(gradeService.findGrade(enr.getEnrollId()));
        }
        mav.getModel().replace("grades", grades);
        return mav;
    }

    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public void insertStudent(@RequestBody Student student) {
        studentService.insertNewStudent(student);
    }
}
