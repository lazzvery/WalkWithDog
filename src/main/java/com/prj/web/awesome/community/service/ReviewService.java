package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper mapper;

    public List<ReviewDTO> reviewList(){
        List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();

        try {
            reviewList = mapper.reviewList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reviewList;
    }

    // ** SearchCriteria PageList
    public List<ReviewDTO> searchList(SearchCriteria cri){
        return mapper.searchList(cri);
    };

    public int searchTotalCount(SearchCriteria cri){
        return mapper.searchTotalCount(cri);
    };

    // ** Criteria PageList
    public List<ReviewDTO> criList(Criteria cri){
        return mapper.criList(cri);
    };
    public int criTotalCountAnInt(){
        return mapper.criTotalCount();
    };


    public ReviewDTO reviewDetail(ReviewDTO dto) {
        return mapper.reviewDetail(dto);
    }

    public void reviewInsert(ReviewDTO dto){
        mapper.reviewInsert(dto);
    }

    @Transactional
    public int reviewUpdate(ReviewDTO dto){
        return mapper.reviewUpdate(dto);
    }

    @Transactional
    public void reviewDelete(ReviewDTO dto){
        mapper.reviewDelete(dto);
    }

}
