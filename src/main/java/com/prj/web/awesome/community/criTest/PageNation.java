package com.prj.web.awesome.community.criTest;

import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class PageNation {
    private int totalRowsCount;  // DB에서 읽어온다
    private int spageNo;  // 계산
    private int epageNo;  // 계산
    // ※ 주의 필드명이 ePage 처럼 두번쨰 알파벳이 대문자인 경우
    //    => setter, getter 는 setsPageNo , getsPageNo 형태로 만들어지기때문에
    //       Lombok.. 등등 과 규칙이다르므로 사용시 불편
    //			-> 그러므로 대.소문자 섞어사용시 주의.

    private int displayPageNo=3;  // 1Page당 표시할 pageNo갯수
    private int lastPageNo; // 출력 가능한 마지막 PageNo : 계산

    private boolean prev; // 이전 PageBlock 으로
    private boolean next; // 다음 PageBlock 으로

    SearchCriteria cri; // ver02

    // ** 필요한 값 set
    // 1) Criteria
    public void setCriteria(SearchCriteria cri) {
        this.cri=cri;
    }
    // 2) totalRowsCount
    public void setTotalRowsCount(int totalRowsCount) {
        this.totalRowsCount=totalRowsCount;
        calcData();
    }
    // 3) 위외 필요값 계산
    // => totalRowsCount 를 이용해서
    //    spageNo, epageNo, prev, next, lastPageNo 계산
    public void calcData() {
        // 3.1) currPage가 속한 페이지블럭의 spageNo, epageNo 를 계산

        epageNo = (int)Math.ceil(cri.getCurrPage()/(double)displayPageNo) * displayPageNo ;
        spageNo = (epageNo-displayPageNo) + 1;

        // 3.2) lastPageNo 계산, epageNo 확인
        lastPageNo = (int)Math.ceil(totalRowsCount/(double)cri.getRowsPerPage());
        if ( epageNo>lastPageNo ) epageNo = lastPageNo ;

        // 3.3) prev, next
        prev = spageNo==1 ? false : true ;
        next = epageNo==lastPageNo ? false : true ;

    } //calcData

    // 4) QueryString 자동 만들기

    public String makeQuery(int currPage) {
        UriComponents uriComponents =
                UriComponentsBuilder.newInstance().
                        queryParam("currPage", currPage).
                        queryParam("rowsPerPage", cri.getRowsPerPage()).
                        build();
        return uriComponents.toString();
    } //makeQuery

    public String searchQuery(int currPage) {
        // ** check 처리 ( -> MultiValueMap 으로 )
        // => MultiValueMap 생성
        MultiValueMap<String, String> checkMap = new LinkedMultiValueMap<String, String>();

        // => check 에 선택한 값이 있는 경우에만
        //    배열 check 의 원소들을 checkMap 으로
        if ( cri.getCheck()!=null ) {
            for ( String c:cri.getCheck() ) {
                checkMap.add("check", c);
            } //for
        }

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance().
                        queryParam("currPage", currPage).
                        queryParam("rowsPerPage", cri.getRowsPerPage()).
                        queryParam("searchType", cri.getSearchType()).
                        queryParam("keyword", cri.getKeyword()).
                        queryParams(checkMap).
                        build().
                        encode();
        return uriComponents.toString();
    } //searchQuery
}
