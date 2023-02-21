const body = document.querySelector("body"),
  popupOpen = document.querySelector(".c_img_container .img"),
  popupPage = document.querySelector(".popup_page"),
  closeBtn = document.querySelector(".close-area"),
  openReply = document.querySelector(".fa-caret-down"),
  replyDetail = document.querySelector(".replyContent"),
  closeReply = document.querySelector(".fa-caret-up");

popupOpen.addEventListener("click", () => {
  popupPage.style.display = "flex";
  body.style.overflow = "hidden";
})

closeBtn.addEventListener("click", () => {
  popupPage.style.display = "none";
  body.style.overflow = "auto";
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