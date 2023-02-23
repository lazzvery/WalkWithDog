package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReviewMapper {

    List<ReviewDTO> reviewList() throws Exception;
}
