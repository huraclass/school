package com.example.schoolspring.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardFileDomain {
    private Integer bdSeq;
    private String mbId;
    private String upOriginalFileName;
    private String upNewFileName;
    private String upFilePath;
    private Integer upFileSize;
}
