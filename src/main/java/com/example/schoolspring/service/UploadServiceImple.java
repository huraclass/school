package com.example.schoolspring.service;

import com.example.schoolspring.domain.BoardListDomain;
import com.example.schoolspring.mapper.UploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadServiceImple implements UploadService{
    @Autowired
    private UploadMapper uploadMapper;

    @Override
    public List<BoardListDomain> boardList() {
        // TODO Auto-generated method stub
        return uploadMapper.boardList();
    }
}
