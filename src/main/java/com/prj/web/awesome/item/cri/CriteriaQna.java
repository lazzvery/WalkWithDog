package com.prj.web.awesome.item.cri;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class CriteriaQna {
    private int onePageCount; // 한 페이지에 출력할 게시글 개수
    private int currPage; // 현재 출력하는 페이지
    private int stPage; // 시작 페이지
    private int edPage; // 종료 페이지
    private int totalCount; // 총 게시글 수
    private int item_id; // 상품 코드

    public CriteriaQna(int onePageCount, int currPage) {
        this.onePageCount = onePageCount;
        this.currPage = currPage;
        this.stPage = (currPage - 1) * onePageCount;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.edPage = (int) Math.ceil((double) totalCount / onePageCount);
    }
}
