'use strict'
//
// const body = document.querySelector("body"),
//     popupOpen = document.querySelector(".c_username");
//
// popupOpen.addEventListener("click", () => {
//     window.open('./communityReviewPoPUp.html','_self');
// })
//
// $(document).on("click", ".c_img_container .img", function() {
//     const review_seq = $(this).data("review_seq");
//
//     $.ajax({
//         url: "/review/" + review_seq,
//         type: "POST",
//         dataType: "json",
//         success: function(response) {
//             // 상세 페이지 정보를 이용하여 모달창에 정보 표시
//             $("#review_title").text(response.title);
//             $("#review_content").text(response.content);
//             $("#popup_page").modal("show");
//         },
//         error: function(xhr, status, error) {
//             console.log("에러 발생: " + error);
//         }
//     });
// });
