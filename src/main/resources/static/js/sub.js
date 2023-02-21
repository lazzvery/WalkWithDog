const prdContainer = document.querySelector(".productContainer"); //싱픔이미지리스트
const prdImg1 = prdContainer.querySelectorAll(".prdImg1"), // 마우스 호버를 위한 이미지1
  prdImg2 = prdContainer.querySelectorAll(".prdImg2"); // 마우스 호버를 위한 이미지2

// ----------------------------------- 이미지 위에 마우스 올렸을 때 다른 이미지로 변환

for (let i = 0; i < prdImg1.length; i++) {
  prdImg1[i].addEventListener("mouseover", function (e) {
    let tg = e.target;
    tg.style.zIndex = "0";
  });

  prdImg2[i].addEventListener("mouseout", function (e) {
    prdImg1[i].style.zIndex = "1";
  });
}
