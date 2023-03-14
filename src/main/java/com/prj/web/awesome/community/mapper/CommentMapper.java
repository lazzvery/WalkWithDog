package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.dto.CommentDTO;
import com.prj.web.awesome.community.dto.FaqDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    List<CommentDTO> commentList(CommentDTO dto) throws Exception;

    int commentInsert(CommentDTO dto);

    int commentUpdate(CommentDTO dto);

    int commentDelete(int com_seq);
}
