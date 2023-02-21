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
    window.scrollTo({ top: 0, behavior: "smooth" });
  }
};

toTop.addEventListener("click", moveTop);

// ----------------------------------- 검색창
headerTop.addEventListener("click", function (e) {
  if (e.target == searchBtn) {
    searchBarWrap.style.opacity = "1";
    searchBarWrap.classList.remove("hidden_");
    console.log(e.target);
  } else if (e.target == searchCloseBtn) {
    searchBarWrap.classList.add("hidden_");
    searchBarWrap.style.opacity = "0";
  }
});

// ====================================  드롭다운 메뉴
// function showMenu(v) {
//   categoryHover[v].style.height = "auto";
//   categoryHover[v].style.opacity = "0";
//   categoryHover[v].style.backgroundColor = "rgb(255, 255, 255)";

//   if (matchMedia("screen and (min-width: 901px)").matches) {
//     categoryHover[1].style.background = "none";
//   }

//   if (matchMedia("screen and (max-width: 900px)").matches) {
//     subTitle[v].style.backgroundColor = "white";
//   }
// }

// for (let i = 0; i < subTitle.length; i++) {
//   subTitle[i].addEventListener("mouseenter", function (e) {
//     for (let x = 0; x < subTitle.length; x++) {
//       showMenu(x);
//     }
//     for (let i = 0; i < categoryHoverA.length; i++) {
//       categoryHoverA[i].style.cursor = 'pointer';
//       categoryHoverA[i].style.display = 'block';
//     }

//     if (e.target == subTitle[i]) {
//       categoryHover[i].style.opacity = "1";
//       subTitle[i].style.opacity = "1";
//       // categoryHoverUl[i].style.display = "flex";
//     }
//   });
//   category[i].addEventListener("mouseleave", function (e) {
//     for (let x = 0; x < categoryHover.length; x++) {
//       (categoryHover[x].style.height = "0"),
//         (categoryHover[x].style.opacity = "0"),
//         (categoryHover[x].style.transition = ".5s");

//       if (matchMedia("screen and (min-width: 900px)").matches) {
//         category[i].style.background = "none";
//         subTitle[i].style.background = "none";
//       }
//     }

//     for (let i = 0; i < categoryHoverA.length; i++) {
//       categoryHoverA[i].style.cursor = 'default';
//       categoryHoverA[i].style.display = 'none';
//     }
//   });
// }

// ------------------------------ 햄버거버튼
let idx = 0;
hbgBtn.addEventListener("click", function (e) {
  idx++;
  console.log(idx);
  e.target.preventDefault
  for (let i = 0; i < category.length; i++) {
    console.log(hbgBtn);
    console.log(category[0]);
    if (idx % 2 == 1) {
      category[i].style.visibility = "visible";
    } else {
      category[i].style.visibility = "hidden";
    }

    category[i].addEventListener("mouseenter", function (e) {
      if (matchMedia("screen and (max-width: 900px)").matches) {
      }
      category[i].style.background = "none";
    });
  }
  return false;
});
