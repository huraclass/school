package com.example.schoolspring.middleTest.service;


import com.example.schoolspring.middleTest.domain.Student;

public interface LoginService {

    void signUp(Student student);

    void login(Student student);
}
