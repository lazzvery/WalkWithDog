package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoticeMapper {

    List<NoticeDTO> noticeList() throws Exception;

    NoticeDTO noticeDetail(NoticeDTO dto);
}
