package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
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

//    public List<QnaDTO> qnaList(){
//        List<QnaDTO> qnaList = new ArrayList<QnaDTO>();
//
//        try {
//            qnaList = mapper.qnaList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return qnaList;
//    }
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
    public int qnaUpdate(QnaDTO dto){
        return mapper.qnaUpdate(dto);
    }

    @Transactional
    public void qnaDelete(QnaDTO dto){
        mapper.qnaDelete(dto);
    }

    // ** SearchCriteria PageList
    public List<QnaDTO> searchList(SearchCriteria cri){
        return mapper.searchList(cri);
    };

    public int searchTotalCount(SearchCriteria cri){
        return mapper.searchTotalCount(cri);
    };

    // ** Criteria PageList
    public List<QnaDTO> criList(Criteria cri){
        return mapper.criList(cri);
    };
    public int criTotalCountAnInt(){
        return mapper.criTotalCount();
    };

}
