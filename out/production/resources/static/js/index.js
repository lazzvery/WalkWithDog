"use strict";

const headerTop = document.getElementById("headerTop"), // 헤더
    body = document.querySelector("body"); // 바디

const toTop = body.querySelector(".toTop"); // 탑버튼

// 드롭메뉴
const categoryContainer = document.querySelector(".categoryContainer");
const subTitle = document.querySelectorAll(".subTitle");
const categoryHover = document.querySelectorAll(".categoryHover");
const categoryHoverA = document.querySelectorAll(".categoryHover a");

const category = document.querySelectorAll(".category");
const searchBarWrap = document.querySelector(".searchBarWrap"); // 숨긴 검색바
const searchBtn = headerTop.querySelector(".searchBtn_a"); // 검색버튼
const searchCloseBtn = headerTop.querySelector(".searchCloseBtn"); //창닫기

const hbgBtn = headerTop.querySelector(".headerLogo .hamburgerBtn");

// ==============================================================================
window.addEventListener("scroll", btnView);

// 탑버튼이 스크롤 일정구간 밑에서 보이게
function btnView() {
    if (window.pageYOffset > this.innerHeight / 1.5) {
        toTop.classList.remove("hidden_");
    } else {
        toTop.classList.add("hidden_");
    }
}

const moveTop = (e) => {
    e.preventDefault();
    if (window.pageYOffset > 0) {
        window.scrollTo({top: 0, behavior: "smooth"});
    }
};

toTop.addEventListener("click", moveTop);

// ----------------------------------- 검색창
headerTop.addEventListener("click", function (e) {
    if (e.target == searchBtn) {
        searchBarWrap.style.opacity = "1";
        searchBarWrap.classList.remove("hidden_");
    } else if (e.target == searchCloseBtn) {
        searchBarWrap.classList.add("hidden_");
        searchBarWrap.style.opacity = "0";
    }
});


// ------------------------------------- 상품명 검색 기능

$(function () {
    $('#searchBtn').click(function (event) {
        event.preventDefault(); // 기본 동작 중지
        let keyword = $('#keyword').val(); // 검색어 가져오기
        if (keyword === '') {
            alert('찾고 싶은 상품명을 입력해 주세요!');
            return false;
        }
        console.log('성공 => ' + $('#keyword').val());
        $.ajax({
            type: 'GET',
            url: '/itemSearch?keyword=' + keyword, // 검색 결과를 불러올 컨트롤러 URL
            // data : { keyword : keyword }, // 검색어를 파라미터로 전달

            success: function (response) {
                // 검색 결과를 처리하는 코드
                // 예: 검색 결과를 출력하는 함수 호출
                let noResult = '<p>검색 결과가 없습니다.</p>';
                if (response.trim() == '') {
                    $('.productContainer').html(noResult);
                } else {
                    $('.productContainer').html(response);
                }
                console.log('성공했음');
                window.location.href = '/itemSearch?keyword=' + keyword;
            },
            error: function (xhr, status, error) {
                // 에러 처리하는 코드
                console.log("에러" + error);
            }
        });

        $('keyword').onkeydown(function (event) {
            if (event.keyCode === 13) { // 엔터 키 코드
                $('#searchBtn').trigger('click');
            }
        });

    });
});