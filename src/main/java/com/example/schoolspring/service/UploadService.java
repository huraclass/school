package com.example.schoolspring.service;

import com.example.schoolspring.domain.BoardListDomain;
import com.example.schoolspring.vo.FileListVO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UploadService {
    public List<BoardListDomain> boardList();

    public int fileProcess(FileListVO fileListVO, MultipartHttpServletRequest request, HttpServletRequest httpReq);
}
