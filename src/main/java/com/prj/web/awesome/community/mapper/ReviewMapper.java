package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

//    void reviewInsert(ReviewDTO dto);

    int reviewUpdate(ReviewDTO dto);

    void reviewDelete(ReviewDTO dto);


    @Select("select r.review_seq, r.review_title, r.user_id, r.review_rank, a.attachment_name " +
            "from review r " +
            "join attachment a on r.review_seq = a.review_seq " +
            "where a.attachment_flag = 'm' " +
            "limit 5")
    List<ReviewDTO> findReview();


    @Select("SELECT \n" +
            "    r.review_seq, r.item_id, r.review_title, r.user_id, r.review_rank, \n" +
            "    (SELECT a.attachment_name FROM attachment a WHERE a.review_seq = r.review_seq LIMIT 1) AS attachment_name \n" +
            "FROM \n" +
            "    review r \n" +
            "    JOIN item i ON r.item_id = i.item_id \n" +
            "WHERE \n" +
            "    r.item_id = #{item_id}\n" +
            "LIMIT 4;")
    List<ReviewDTO> writeReview(int item_id);
}
