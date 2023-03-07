package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReviewMapper {

    List<ReviewDTO> reviewList() throws Exception;
    // list 호출

    List<ReviewDTO> searchList(SearchCriteria cri);
    int searchTotalCount(SearchCriteria cri);

    // ** Criteria PageList
    List<ReviewDTO> criList(Criteria cri);
    int criTotalCount();
    ReviewDTO reviewDetail(ReviewDTO dto);

    void reviewInsert(ReviewDTO dto);

    int reviewUpdate(ReviewDTO dto);

    void reviewDelete(ReviewDTO dto);



}
