"use strict";

const active = document.querySelectorAll(".pageList a");

// 카테고리 클릭시 카테고리 색깔 변경
console.log(active);
let tmp = active[0];


tmp.style.backgroundColor = "#8E83A9";
tmp.style.color = "#ffffff";
for (let i = 0; i < active.length; i++) {
    active[i].addEventListener('click', function (e) {
        e.target.style.backgroundColor = "#8E83A9";
        e.target.style.color = "#ffffff";
        tmp.style.backgroundColor = "#f3f3f3";
        tmp.style.color = "#BAAAD7";

        tmp = e.target;
    });
}

//-----------------------------------------------------------------

// $(function() {
//
//     let html = '';
//
//     $.ajax({
//         method : 'POST',
//         url : '/item/list',
//         async : false,
//         dataType : 'json',
//         headers : {
//             "Content-Type" : "application/json",
//             "X-HTTP-Method-Override" : "POST"
//         },
//         success : function(result) {
//             let arr = result.arrOutDto;
//
//             let prntArr     = new Array();
//             let childrenArr = new Array();
//
//             $.each(arr, function(idx, el) {
//
//                 //부모
//                 if(el.prt_ctgr_cd == '') {
//                     prntArr.push(el);
//                     //자식
//                 } else {
//                     childrenArr.push(el);
//                 }
//
//             });

// })