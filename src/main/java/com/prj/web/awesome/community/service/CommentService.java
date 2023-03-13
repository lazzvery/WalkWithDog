package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.dto.CommentDTO;
import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.mapper.CommentMapper;
import com.prj.web.awesome.community.mapper.FaqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper mapper;

    public List<CommentDTO> commentList(){
        List<CommentDTO> commentList = new ArrayList<CommentDTO>();

        try {
            commentList = mapper.commentList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return commentList;
    }

    public int commentInsert(CommentDTO dto){
        return mapper.commentInsert(dto);
    }

    @Transactional
    public int commentUpdate(CommentDTO dto){
        return mapper.commentUpdate(dto);
    }

    @Transactional
    public int commentDelete(int com_seq){
        return mapper.commentDelete(com_seq);
    }

}
