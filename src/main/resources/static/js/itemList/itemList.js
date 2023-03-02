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

$(function(){

    let inDs = {
        itemInDto : {
            ctgr_cd : $('input[name="ctgr_cd"]').val(),
            prt_ctgr_cd : ''
        }
    };

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