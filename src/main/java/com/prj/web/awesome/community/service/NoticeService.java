package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.mapper.NoticeMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper mapper;

//    public List<NoticeDTO> noticeList(){
//        List<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
//
//        try {
//            noticeList = mapper.noticeList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return noticeList;
//    }

    public NoticeDTO noticeDetail(NoticeDTO dto) {
        return mapper.noticeDetail(dto);
    }

    public List<NoticeDTO> searchList(SearchCriteria cri){
        return mapper.searchList(cri);
    };

    public int searchTotalCount(SearchCriteria cri){
        return mapper.searchTotalCount(cri);
    };

    // ** Criteria PageList
    public List<NoticeDTO> criList(Criteria cri){
        return mapper.criList(cri);
    };
    public int criTotalCountAnInt(){
        return mapper.criTotalCount();
    };


    public void noticeInsert(NoticeDTO dto){
        mapper.noticeInsert(dto);
    }

    @Transactional
    public int noticeUpdate(NoticeDTO dto){
        return mapper.noticeUpdate(dto);
    }

    @Transactional
    public void noticeDelete(NoticeDTO dto){
        mapper.noticeDelete(dto);
    }
}
