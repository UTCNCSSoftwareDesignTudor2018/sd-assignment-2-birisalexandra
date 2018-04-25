package com.biris.studentManagement.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/studentLogin")
    public String studentLogin() {
        return "studentLogin";
    }

    @GetMapping(value = "/adminLogin")
    public String adminLogin() {
        return "adminLogin";
    }
}
