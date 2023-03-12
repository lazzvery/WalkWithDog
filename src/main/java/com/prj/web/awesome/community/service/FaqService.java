package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.mapper.FaqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FaqService {

    @Autowired
    private FaqMapper mapper;

    public List<FaqDTO> faqList(){
        List<FaqDTO> faqList = new ArrayList<FaqDTO>();

        try {
            faqList = mapper.faqList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return faqList;
    }

    public void faqInsert(FaqDTO dto){
        mapper.faqInsert(dto);
    }

    @Transactional
    public int faqUpdate(FaqDTO dto){
        return mapper.faqUpdate(dto);
    }

    @Transactional
    public void faqDelete(FaqDTO dto){
        mapper.faqDelete(dto);
    }

}
