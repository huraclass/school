package com.example.schoolspring.middleTest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class board {
    private String title;
    private String content;
    private int boardNumber;
    private long id;
}
