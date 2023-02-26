"use strict";

$(function() {
    let html = '';

    html += '<div class="categoryContainer">';
    html += '   <div class="subContainer">';
    html += '       <div class="headerLogo">';
    html += '           <a class="hamburgerBtn"></a>';
    html += '           <a href="#">';
    html += '               <img src="./image/logo.png">';
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
                        if(el.ctgr_cd == ch.prt_ctgr_cd) {
                            html += '               <li><a href="#">'+ch.ctgr_nm+'</a></li>';
                        }
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

    html += '   </div>';
    html += '</div>';
    html += '<div class="fullDown"></div>';
    html += '<div class="searchBarWrap hidden_">';
    html += '   <form class="mainSearch">';
    html += '       <input type="text" id="keyword" placeholder="상품명 검색" />';
    html += '       <input type="submit" value="Search" />';
    html += '       <a class="searchCloseBtn searchClose" alt="검색창닫기"></a>';
    html += '   </form>';
    html += '</div>';


/*

    let test = $('#headerTop').html();
    alert(test);
*/
    $('#headerTop').html(html);


});
