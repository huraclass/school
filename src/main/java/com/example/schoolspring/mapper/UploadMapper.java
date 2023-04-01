package com.example.schoolspring.mapper;

import com.example.schoolspring.domain.BoardContentDomain;
import com.example.schoolspring.domain.BoardFileDomain;
import com.example.schoolspring.domain.BoardListDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UploadMapper {
    public List<BoardListDomain> boardList();

    public void contentUpload(BoardContentDomain boardContentDomain);

    public void fileUpload(BoardFileDomain boardFileDomain);

    public void bdContentUpdate(BoardContentDomain boardContentDomain);

    public void bdFileUpdate(BoardFileDomain boardFileDomain);

    public void bdContentRemove(HashMap<String, Object> map);

    public void bdFileRemove(BoardFileDomain boardFileDomain);

    //select one
    public BoardListDomain boardSelectOne(HashMap<String, Object> map);

    //select one file
    public List<BoardFileDomain> boardSelectOneFile(HashMap<String, Object> map);
}
