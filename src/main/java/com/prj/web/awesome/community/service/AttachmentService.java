package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.dto.AttachmentDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;

import java.util.List;

public interface AttachmentService {

    void saveFile1(AttachmentDTO attachmentDTO);
    void saveFile2(AttachmentDTO attachmentDTO);
    void saveFile3(AttachmentDTO attachmentDTO);
    void saveNotice(NoticeDTO noticeDTO);
    void saveQnA(QnaDTO qnaDTO);
    void  saveReview(ReviewDTO reviewDTO);
    int selectLastInsertSeq();
    String findNoticeMainImg(int notice_seq);
    String findQnAMainImg(int qna_seq);
    String findQnASubImg(int qna_seq);
    String findReviewMainImg(int review_seq);
    String findReviewSubImg(int review_seq);
    String findReviewInfoImg(int review_seq);

}

