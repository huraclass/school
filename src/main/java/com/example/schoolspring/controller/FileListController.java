package com.example.schoolspring.controller;

import com.example.schoolspring.service.UploadService;
import com.example.schoolspring.vo.FileListVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FileListController {
    private final UploadService uploadService;

    @PostMapping(value = "upload")
    public ModelAndView bdUpload(FileListVO fileListVO, MultipartHttpServletRequest request, HttpServletRequest httpReq) {
        ModelAndView mav = new ModelAndView();
        int bdSeq = uploadService.fileProcess(fileListVO, request, httpReq);
        fileListVO.setContent("");
        fileListVO.setTitle("");

        mav = bdSelectOneCall(fileListVO, String.valueOf(bdSeq), request);
        mav.setViewName("board/boardList.html");
        return mav;
    }
}
