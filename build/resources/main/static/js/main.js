"use strict";

// const headerTop = document.getElementById("headerTop"); // 헤더
// const body = document.querySelector("body"); // 바디
let slideWrapper = document.querySelector(".slideWrapper"),
  slides = document.querySelector(".slides"),
  slidesLi = document.querySelectorAll(".slides li"),
  slideCount = slidesLi.length / 2, //끝인지 마지막인지 구분할 용도
  currentIdx = 0, //시작인덱스
  prevBtn = document.querySelector(".prevBtn"), // 이전 버튼
  nextBtn = document.querySelector(".nextBtn"); // 다음 버튼

// ----------------------------------- 이미지 슬라이드

// function moveSlide(num) {
//   slides.style.left = -num * 100 + "%";
//   currentIdx = num;
// }

// function leftMove() {
//   if (currentIdx < slideCount - 1) {
//     moveSlide(currentIdx + 1);
//   } else {
//     moveSlide(0);
//   }
// }

nextBtn.addEventListener("click", leftMove);

prevBtn.addEventListener("click", function () {
  if (currentIdx > 0) {
    moveSlide(currentIdx - 1);
    console.log(currentIdx);
  } else if (currentIdx <= 0) {
    moveSlide(slideCount - 1);
  } else {
    moveSlide(0);
  }
});

setInterval(leftMove, 5000);

// --------------------------------------- 이미지 내 글자
