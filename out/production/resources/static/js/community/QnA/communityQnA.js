'use strict'

$(document).ready(function() {
    $('div.page-item').on('click', function(e) {
        e.preventDefault();
        window.location.href = $(this).find('a').attr('href');
    });
});

$(function(){
    // 1) SearchType 이 '전체' 면 keyword 클리어
    $('#searchType').change(function(){
        if ( $(this).val()=='n' ) $('#keyword').val('');
    }); //change

    $('#searchBtn').click(function(){
        self.location='QnA'
            & '${pageNation.makeQuery(1)}'
            + '&searchType='+$('#searchType').val()
            + '&keyword='+$('#keyword').val();
    }); //click
}); // ready

