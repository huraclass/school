package com.example.schoolspring.mapper;

import com.example.schoolspring.domain.BoardContentDomain;
import com.example.schoolspring.domain.BoardFileDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@SpringBootTest
public class SqlTest {

    @Autowired
    UploadMapper map;

    @Test
    void test() {
        BoardContentDomain domain = BoardContentDomain.builder()
                .bdSeq(null)
                .mbId("var")
                .bdTitle("hello")
                .bdContent("world")
                .build();
        log.info("domain : {}", domain);
        log.info("map : {}", map);
        map.contentUpload(domain);
        
    }

    @Test
    void tes2() {
        BoardFileDomain domain = BoardFileDomain.builder()
                .bdSeq(1)
                .mbId("var")
                .upOriginalFileName("22-12-20 정진우 여권.jpg")
                .upNewFileName("72ab3efe-20b4-489b-9ac7-f6e07b89c62f20230403122534.jpg")
                .upFilePath("/Users/java/upload/72ab3efe-20b4-489b-9ac7-f6e07b89c62f20230403122534.jpg")
                .upFileSize(235377)
                .build();
        map.fileUpload(domain);
    }
}
