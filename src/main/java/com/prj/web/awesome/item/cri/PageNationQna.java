package com.prj.web.awesome.item.cri;

import lombok.Data;

@Data
public class PageNationQna {
    private int stWrite; // 시작 게시글
    private int edWrite; // 종료 게시글
    private int pageViewCount; // 페이지 넘버 개수
    private boolean prev;   // 이전 페이지
    private boolean next;   // 다음 페이지

    private CriteriaQna qna;

    public PageNationQna(CriteriaQna qna) {
        this.qna = qna;
    }

    public void calc() {
        stWrite = (qna.getCurrPage() - 1) * qna.getOnePageCount() + 1;
        edWrite = stWrite + qna.getOnePageCount() - 1;
        if (edWrite > qna.getTotalCount()) {
            edWrite = qna.getTotalCount();
        }

        pageViewCount = qna.getEdPage();

        prev = stWrite == 1 ? false : true;
        next = qna.getCurrPage() == pageViewCount ? false : true;
    }

}
