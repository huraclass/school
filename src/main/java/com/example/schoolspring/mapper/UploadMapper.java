package com.example.schoolspring.mapper;

import com.example.schoolspring.domain.BoardListDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UploadMapper {
    public List<BoardListDomain> boardList();

    public void contentUpload(BoardContentDomain )
}
