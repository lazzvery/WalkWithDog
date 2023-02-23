package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.mapper.FaqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
