package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.dto.AttachmentDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AttachmentMapper {

    @Insert("insert into attachment (attachment_name,  notice_seq, attachment_flag)" +
            "values (#{attachment_name},  #{notice_seq}, #{attachment_flag})")
    void saveFile1(AttachmentDTO attachmentDTO);
    @Insert("insert into attachment (attachment_name,  qna_seq, attachment_flag)" +
            "values (#{attachment_name},  #{qna_seq}, #{attachment_flag})")
    void saveFile2(AttachmentDTO attachmentDTO);

    @Insert("insert into attachment (attachment_name,  review_seq, attachment_flag)" +
            "values (#{attachment_name},  #{review_seq}, #{attachment_flag})")
    void saveFile3(AttachmentDTO attachmentDTO);

    @Insert("insert into notice( notice_title, notice_content, notice_reg_date)" +
            "values(#{notice_file},  #{notice_content}, now())")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "notice_seq", before = false, resultType = int.class)
    void saveNotice(NoticeDTO noticeDTO);

    @Insert("insert into review(review_title, review_content, user_id, review_reg_date, review_rank, item_id)" +
            "values(#{review_title}, #{review_content}, #{user_id}, now(), #{review_rank}, '10000016')")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "review_seq", before = false, resultType = int.class)
    void saveReview(ReviewDTO reviewDTO);
    @Insert("insert into QnA(qna_title, ctgr_cd, qna_content, qna_reg_date, user_id, qna_password)" +
            "values(#{qna_title}, '0016', #{qna_content}, now(), #{user_id}, #{qna_password})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "qna_seq", before = false, resultType = int.class)
    void saveQnA(QnaDTO qnaDTO);

    @Select("select last_insert_id()")
    int selectLastInsertSeq();

    @Select("select attachment_name from attachment where notice_seq=${notice_seq} and attachment_flag='m'")
    String findNoticeMainImg(int notice_seq);

    @Select("select attachment_name from attachment where qna_seq=${qna_seq} and attachment_flag='m'")
    String findQnAMainImg(int qna_seq);

    @Select("select attachment_name from attachment where qna_seq=${qna_seq} and attachment_flag='s'")
    String findQnASubImg(int qna_seq);

    @Select("select attachment_name from attachment where review_seq=${review_seq} and attachment_flag='m'")
    String findReviewMainImg(int review_seq);

    @Select("select attachment_name from attachment where review_seq=${review_seq} and attachment_flag='s'")
    String findReviewSubImg(int review_seq);

    @Select("select attachment_name from attachment where review_seq=${review_seq} and attachment_flag='i'")
    String findReviewInfoImg(int review_seq);

}
