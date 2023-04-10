package com.example.schoolspring.middleTest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long id;
    private long studentNumber;
    private String studentName;
}
