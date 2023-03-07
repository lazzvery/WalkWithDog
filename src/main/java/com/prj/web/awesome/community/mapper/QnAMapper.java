package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QnAMapper {

//    List<QnaDTO> qnaList() throws Exception;

    QnaDTO qnaPassword(QnaDTO dto);
    QnaDTO qnaDetail(QnaDTO dto);

    void qnaInsert(QnaDTO dto);

    int qnaUpdate(QnaDTO dto);

    void qnaDelete(QnaDTO dto);

    List<QnaDTO> searchList(SearchCriteria cri);
    int searchTotalCount(SearchCriteria cri);

    // ** Criteria PageList
    List<QnaDTO> criList(Criteria cri);
    int criTotalCount();

    void qnaReply(QnaDTO dto);
}
