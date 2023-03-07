"use strict";
const active = document.querySelectorAll(".itemSub"),
    pageList = document.querySelector(".pageList"),
    itemSub = pageList.querySelectorAll("a");

function handleClick(event) {
    event.preventDefault(); // 기본 이벤트 동작(페이지 이동)을 방지합니다.
    // 인라인 스타일로 배경색을 변경합니다.
    event.target.style.setProperty('background-color', '#8E83A9', 'important');
    // 페이지를 이동합니다.
    window.location.href = event.target.href;
}

// let code = [[${param.ctgr_cd}]];
// if (code) {
//     // 가져온 코드 값을 사용하는 자바스크립트 코드
//    console.log(code);
// }

// function change() {}
// items.forEach(category => {
//     category.addEventListener('click', () => {
//         items.forEach(c => c.classList.add('change'));
//         category.classList.add('change');
//     })
// })



// 카테고리 클릭시 카테고리 색깔 변경
// console.log(subs);
// let tmp = active[0];
//
//
// tmp.style.backgroundColor = "#8E83A9";
// tmp.style.color = "#ffffff";
// subs.forEach(function(itemSub) {
//     itemSub.addEventListener('click', function() {
//         // 현재 선택된 카테고리에 selected 클래스를 추가하고,
//         // 나머지 카테고리에서는 selected 클래스를 제거한다
//         subs.forEach(function(otherCategory) {
//             // otherCategory.classList.remove('selected');
//         });
//         category.classList.add('selected');
//     });
// });

// function change() {
//     for (let i = 0; i < active.length; i++) {
//         active[i].addEventListener('click', function (e) {
//             e.target.style.backgroundColor = "#8E83A9";
//             e.target.style.color = "#ffffff";
//             tmp.style.backgroundColor = "#f3f3f3";
//             tmp.style.color = "#BAAAD7";
//
//             tmp = e.target;
//         });
//     }
// }


$(function(){

    let inDs = {
        itemInDto : {
            ctgr_cd : $('input[name="ctgr_cd"]').val(),
            prt_ctgr_cd : ''
        }
    };

    console.log(inDs);

    // var ctgr_cd = document.getElementsByName("ctgr_cd")[0].value;
    //
    // if (ctgr_cd == )

    $.ajax({
        method: 'POST',
        url: '/item/list',
        async: false,
        dataType: 'json',
        data: JSON.stringify(inDs),
        headers: {
            "Content-Type": "application/json",
            "X-HTTP-Method-Override": "POST"
        },
        success: function (result) {
            //console.log(result.itemOutArr[0].item_name);
            console.log('성공');

            $.each(result.itemOutArr, function(idx, item) {
                console.log('item.item_name : ' + item.item_name);
                console.log('item.item_price : ' + item.item_price);
            });
        },
        error : function (request, status, error) {
            console.log('실패');
        }
    });
});

// -----------------------------------


// $(function() {
//
//     $().ready(function() {
//         let i=0;
//         let tmp = $(".pageList a");
//         console.log(tmp);
//         let turnBC = new Array("#8E83A9");
//         let turnFC = new Array("#ffffff");
//         tmp.click(function() {
//             let resultBC = turnBC[i];
//             let resultFC = turnFC[i];
//             $(this).css("background",resultBC);
//             $(this).css("color",resultFC);
//             i++;
//         });
//     });
//
//
// });

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

window.addEventListener("load", (e) =>{


});