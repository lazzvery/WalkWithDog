package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    public ReviewDTO reviewDetail(ReviewDTO dto) throws Exception{
//
//        ReviewMapper.up
//
//        ReviewDTO detail = ReviewMapper.selectReviewDetail();
//    }
}
