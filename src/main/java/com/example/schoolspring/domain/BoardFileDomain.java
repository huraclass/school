package com.example.schoolspring.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardFileDomain {
    private Integer dbSeq;
    private String mbId;
    private String upOriginalFileName;
    private String upNewFileName;
    private String upFIlePath;
    private Integer upFileSize;
}
