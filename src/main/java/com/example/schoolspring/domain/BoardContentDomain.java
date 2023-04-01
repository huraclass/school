package com.example.schoolspring.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardContentDomain {
    private Integer bdSeq;
    private String mbId;
    private String bdTitle;
    private String dbContent;
}
