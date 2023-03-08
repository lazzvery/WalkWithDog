'use strict'

const body = document.querySelector("body"),
    popupPage = document.querySelector("#popup_page"),
    closeBtn = document.querySelector(".closearea"),
    openReply = document.querySelector(".fa-caret-down"),
    replyDetail = document.querySelector(".replyContent"),
    closeReply = document.querySelector(".fa-caret-up");

closeBtn.addEventListener("click", () => {
  popupPage.style.display = "none";
  // body.style.overflow = "auto";
})

openReply.addEventListener("click", () => {
  openReply.style.display = "none";
  replyDetail.style.display = "block";
  closeReply.style.display = "inline-block";
})

closeReply.addEventListener("click", () => {
  closeReply.style.display = "none";
  replyDetail.style.display = "none";
  openReply.style.display = "inline-block";
})

