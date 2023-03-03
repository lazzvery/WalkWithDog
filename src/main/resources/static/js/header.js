"use strict";

$(function() {

    initDialogue();

    $(".categoryHover ul li a").click(function(){
        console.log($(this).text() + ' | ' + $(this).data('ctgrCd'));

       /*let inDs = {
             itemInDto : {
                 ctgr_cd : $(this).data('ctgrCd'),
                 prt_ctgr_cd : ''
             }
        };

        alert(inDs.itemInDto.ctgr_cd);*/

        $('input[name="ctgr_cd"]').val($(this).data('ctgrCd'));

        // alert($('input[name="ctgr_cd"]').val());

        $('#transData').attr('action', '/item/list');
        $('#transData').attr('method', 'get');
        $('#transData').submit();
/*
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
            },
            error : function (request, status, error) {
                console.log('실패');
            }
        });
        */
    });


    // ----------------------------------- 검색창
    $(".searchBtn_a").click(function() {
        $(".searchBarWrap").css("opacity" , "1");
        $(".searchBarWrap").removeClass("hidden_");
    });

    $(".searchCloseBtn").click(function() {
        $(".searchBarWrap").css("opacity" , "0");
        $(".searchBarWrap").addClass("hidden_");
    });

});


//-------------------------------------------

let initDialogue = function() {
    let html = '';

    html += '<div class="categoryContainer">';
    html += '   <div class="subContainer">';
    html += '       <div class="headerLogo">';
    html += '           <a class=""></a>';
    html += '           <a href="/home">';
    html += '               <img src="/img/bannerImg/logo.png" class="mainLogo">';
    html += '           </a>';
    html += '       </div>';

    $.ajax({
        method : 'POST',
        url : '/category/list',
        async : false,
        dataType : 'json',
        headers : {
            "Content-Type" : "application/json",
            "X-HTTP-Method-Override" : "POST"
        },
        success : function(result) {
            let arr = result.arrOutDto;

            let prntArr     = new Array();
            let childrenArr = new Array();

            $.each(arr, function(idx, el) {

                //부모
                if(el.prt_ctgr_cd == '') {
                    prntArr.push(el);
                    //자식
                } else {
                    childrenArr.push(el);
                }

            });

            $.each (prntArr, function(idx, el){
                console.log(el.ctgr_nm);
                html += '<ul class="category list' + (idx+1) + '">';
                html += '   <div class="subList">';
                html += '       <li class="subTitle"><strong>'+el.ctgr_nm+'</strong></li>';
                html += '       <div class="categoryHover">';
                html += '           <ul>';


                $.each(childrenArr, function(cIdx, ch) {
                    if( ch.prt_ctgr_cd == '0001' && el.ctgr_nm == 'SHOP' ) {
                        html += '               <li><a href="#" data-ctgr-cd="' + ch.ctgr_cd + '" >'+ch.ctgr_nm+'</a></li>';
                    } else if( ch.prt_ctgr_cd == '0003' && el.ctgr_nm == 'EVENT' ) {
                        html += '               <li><a href=#>'+ch.ctgr_nm+'</a></li>';

                    } else if( ch.ctgr_cd == '0014' && el.ctgr_nm == 'COMMUNITY' ) {
                        html += '               <li><a href="/community/notice">'+ch.ctgr_nm+'</a></li>';
                    } else if( ch.ctgr_cd == '0015' && el.ctgr_nm == 'COMMUNITY' ) {
                        html += '               <li><a href="/community/faq">'+ch.ctgr_nm+'</a></li>';
                    } else if( ch.ctgr_cd == '0016' && el.ctgr_nm == 'COMMUNITY' ) {
                        html += '               <li><a href="/community/QnA">'+ch.ctgr_nm+'</a></li>';
                    } else if( ch.ctgr_cd == '0017' && el.ctgr_nm == 'COMMUNITY' ) {
                        html += '               <li><a href="/community/review">'+ch.ctgr_nm+'</a></li>';
                    }
                    // if(el.ctgr_cd == ch.prt_ctgr_cd) {
                    //     html += '               <li><a href="/item/list">'+ch.ctgr_nm+'</a></li>';
                    // }
                });

                html += '           </ul>';
                html += '       </div>';
                html += '   </div>';
                html += '</ul>';
            });
        },
        error    : function(request, status, error) {       // 호출 실패 시 처리
            console.log('ajax Call Error : ' + error);
        }
    });

    html += '<ul class="category list5">';
    html += '   <li class="searchBtn">';
    html += '       <a class="searchBtn_a" title="검색">검색</a>';
    html += '   </li>';
    html += '   <li class="cartBtn">';
    html += '       <a class="cartBtn_a" href="/user/cart" title="장바구니">카트</a>';
    html += '   </li>';

    html += '   <li><a href="/user/login" title="로그인">Login</a></li>';
    html += '   <li><a href="/user/join" title="회원가입">Join</a></li>';
    html += '   <li><a href="/user/myPage/myHome" title="마이페이지">My Page</a></li>';
    html += '</ul>';

    html += '   </div>';
    html += '</div>';
    html += '<div class="fullDown"></div>';
    html += '<div class="searchBarWrap hidden_">';
    html += '   <form class="mainSearch">';
    html += '       <input type="text" id="keyword" placeholder="상품명 검색" />';
    html += '       <input type="submit" value="" />';
    html += '       <a class="searchCloseBtn searchClose" alt="검색창닫기" title="닫기"></a>';
    html += '   </form>';
    html += '</div>';
    html += '<div id="fakeHeader"></div>';

    html += '<form id="transData">';
    html += '   <input type="hidden" name="ctgr_cd">';
    html += '</form>';

    $('#headerTop').html(html);
};