package com.prj.web.awesome.community.service;

import com.prj.web.awesome.community.dto.AttachmentDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.mapper.AttachmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService{

    private final AttachmentMapper mapper;

    @Override
    public void saveFile1(AttachmentDTO attachmentDTO){
        mapper.saveFile1(attachmentDTO);
    }
    @Override
    public void saveFile2(AttachmentDTO attachmentDTO){
        mapper.saveFile2(attachmentDTO);
    }
    @Override
    public void saveFile3(AttachmentDTO attachmentDTO){
        mapper.saveFile3(attachmentDTO);
    }

    @Override
    public void saveNotice(NoticeDTO noticeDTO){
        mapper.saveNotice(noticeDTO);
    }

    @Override
    public void saveQnA(QnaDTO qnaDTO){
        mapper.saveQnA(qnaDTO);
    }
    @Override
    public void saveReview(ReviewDTO reviewDTO){
        mapper.saveReview(reviewDTO);
    }

    @Override
    public int selectLastInsertSeq() {
        return mapper.selectLastInsertSeq();
    }

    @Override
    public String findNoticeMainImg(int notice_seq) {
        return mapper.findNoticeMainImg(notice_seq);
    }

    @Override
    public String findQnAMainImg(int qna_seq) {
        return mapper.findQnAMainImg(qna_seq);
    }

    @Override
    public String findQnASubImg(int qna_seq) {
        return mapper.findQnASubImg(qna_seq);
    }

    @Override
    public String findReviewMainImg(int review_seq) {
        return mapper.findReviewMainImg(review_seq);
    }

    @Override
    public String findReviewSubImg(int review_seq) {
        return mapper.findReviewSubImg(review_seq);
    }

    @Override
    public String findReviewInfoImg(int review_seq) {
        return mapper.findReviewInfoImg(review_seq);
    }

}
