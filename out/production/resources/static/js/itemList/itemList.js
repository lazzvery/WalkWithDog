"use strict";
const active = document.querySelectorAll(".itemSub"),
    pageList = document.querySelector(".pageList"),
    itemSub = pageList.querySelectorAll("a");


const urlParams = new URL(location.href).searchParams;
let name = urlParams.get('ctgr_cd');



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
    if(name == "0005"){
        itemSub[0].style.backgroundColor = "#8E83A9";
        itemSub[0].style.color = "white";
    }

    else if(name == "0006"){
        itemSub[1].style.backgroundColor = "#8E83A9";
        itemSub[1].style.color = "white";
    }

    else if(name == "0007"){
        itemSub[2].style.backgroundColor = "#8E83A9";
        itemSub[2].style.color = "white";
    }

    else if(name == "0008"){
        itemSub[3].style.backgroundColor = "#8E83A9";
        itemSub[3].style.color = "white";
    }

    else if(name == "0009"){
        itemSub[4].style.backgroundColor = "#8E83A9";
        itemSub[4].style.color = "white";
    }

    else if(name == "0010"){
        itemSub[5].style.backgroundColor = "#8E83A9";
        itemSub[5].style.color = "white";
    }

});