package com.example.schoolspring.controller;

import com.example.schoolspring.domain.BoardFileDomain;
import com.example.schoolspring.domain.BoardListDomain;
import com.example.schoolspring.service.UploadService;
import com.example.schoolspring.vo.FileListVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

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
    public ModelAndView bdSelectOneCall(@ModelAttribute("fileListVO") FileListVO fileListVO, String bdSeq, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HashMap<String, Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession();

        map.put("bdSeq", Integer.parseInt(bdSeq));
        BoardListDomain boardListDomain =uploadService.boardSelectOne(map);
        System.out.println("boardListDomain"+boardListDomain);
        List<BoardFileDomain> fileList =  uploadService.boardSelectOneFile(map);

        for (BoardFileDomain list : fileList) {
            String path = list.getUpFilePath().replaceAll("\\\\", "/");
            list.setUpFilePath(path);
        }
        mav.addObject("detail", boardListDomain);
        mav.addObject("files", fileList);

        //삭제시 사용할 용도
        session.setAttribute("files", fileList);

        return mav;
    }
}
