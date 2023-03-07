package com.prj.web.awesome.community.criTest;

import lombok.Data;

@Data
public class Criteria {
    private int rowsPerPage;
    // 1Page에 출력할 Row 갯수
    private int	currPage;
    // 현재 출력 Page
    private int	sno;
    // start Row 순서번호 : 계산필요
    private int eno;

    // 1) 필요한 초기값 생성자로 초기화 (Default 생성자)
    public Criteria() {
        this.rowsPerPage=9;
        this.currPage=1;
    }
    // 2) setCurrPage : 요청받은(출력할) PageNo set
    public void setCurrPage(int	currPage) {
        if (currPage>1) this.currPage=currPage;
        else this.currPage=1;
    }
    // 3) setRowsPerPage
    // => 1페이지당 보여줄 Row(Record,튜플) 갯수 확인
    // => 제한조건 점검 ( 50개 까지만 허용)
    // => 당장은 사용하지 않지만 사용가능하도록 작성
    public void setRowsPerPage(int rowsPerPage) {
        if ( rowsPerPage>5 && rowsPerPage<=50 ){
            this.rowsPerPage=rowsPerPage;
        } else {
            this.rowsPerPage=5;
        }
    }
    // 4) setSnoEno : sno, eno 계산
    // => currPage, rowsPerPage 를 이용해 계산
    // => MySql 검색조건 :  limit sno, n -> sno 다음 부터 n개
    public void setSnoEno() {
        if ( this.sno<1 ) {
            this.sno=1;
        }
        this.sno=(this.currPage-1)*this.rowsPerPage; //MySql
    }
}
