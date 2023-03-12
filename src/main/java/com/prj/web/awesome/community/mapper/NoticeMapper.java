package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoticeMapper {

    List<NoticeDTO> noticeList() throws Exception;

    NoticeDTO noticeDetail(NoticeDTO dto);

    List<NoticeDTO> searchList(SearchCriteria cri);
    int searchTotalCount(SearchCriteria cri);

    // ** Criteria PageList
    List<NoticeDTO> criList(Criteria cri);
    int criTotalCount();

    void noticeInsert(NoticeDTO dto);

    int noticeUpdate(NoticeDTO dto);

    void noticeDelete(NoticeDTO dto);
}
