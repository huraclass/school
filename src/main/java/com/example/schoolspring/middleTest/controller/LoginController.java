package com.example.schoolspring.middleTest.controller;

import com.example.schoolspring.middleTest.domain.Student;
import com.example.schoolspring.middleTest.service.LoginService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    //private final LoginService loginService;


    @GetMapping("/signup")
    public String signUp(@ModelAttribute Student student) {


        return null;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute Student student) {


        return null;
    }
}
