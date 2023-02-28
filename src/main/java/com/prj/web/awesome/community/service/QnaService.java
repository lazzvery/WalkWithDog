package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.mapper.QnAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class QnaService {

    @Autowired
    private QnAMapper mapper;

    public List<QnaDTO> qnaList(){
        List<QnaDTO> qnaList = new ArrayList<QnaDTO>();

        try {
            qnaList = mapper.qnaList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return qnaList;
    }
    public QnaDTO qnaPassword(QnaDTO dto) {
        return mapper.qnaPassword(dto);
    }

    public QnaDTO qnaDetail(QnaDTO dto) {
        return mapper.qnaDetail(dto);
    }

    public void qnaInsert(QnaDTO dto){
        mapper.qnaInsert(dto);
    }

    @Transactional
    public void qnaUpdate(QnaDTO dto){
        mapper.qnaUpdate(dto);
    }

    @Transactional
    public void qnaDelete(QnaDTO dto){
        mapper.qnaDelete(dto);
    }

}
