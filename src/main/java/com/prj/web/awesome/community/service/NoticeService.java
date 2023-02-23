package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.mapper.NoticeMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper mapper;

    public List<NoticeDTO> noticeList(){
        List<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();

        try {
            noticeList = mapper.noticeList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return noticeList;
    }
}
