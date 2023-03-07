'use strict';

const checkBox = document.querySelector('.shop_likelist'),
    checkList = document.querySelectorAll('.checkedCheck');

checkBox.addEventListener('click', (e) => {
    for (let i = 1; i <= checkList.length - 1; i++) {
        if (e.target.tagName === 'INPUT') {
            if (e.target === checkList[0] && checkList[0].checked) {
                checkList[i].checked = true;
            } else if (e.target === checkList[0]) {
                checkList[i].checked = false;
            } else {
                checkList[0].checked = false;
            }
        }
    }

    if(document.querySelectorAll('.checkedCheck:checked').length == checkList.length - 1) {
        checkList[0].checked = true;
    }
});      // 전체 수량 체크

//========================================================

function deleteHeart(index) {
    $.ajax({
        type: "DELETE",
        url: '/user/heart/' + $('#agreeCheck' + index).val(),
        success: function(result) {
            alert(result.message);
            location.reload();
        },
        error: function(xhr) {
            alert('삭제에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

function deleteHearts(event) {
    event.preventDefault();

    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]:checked');
    checkboxes.forEach((checkbox) => {
        items.push(checkbox.value);
    });

    $.ajax({
        type: "DELETE",
        url: '/user/heart/',
        data: JSON.stringify(items),
        contentType: 'application/json',
        success: function(result) {
            alert(result.message);
            location.reload();
        },
        error: function(xhr) {
            alert('삭제에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

function deleteAll(event) {
    event.preventDefault();

    if(!confirm("좋아요 목록을 전부 삭제하시겠습니까?")) {
        return;
    }

    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]');
    checkboxes.forEach((checkbox) => {
        items.push(checkbox.value);
    });

    $.ajax({
        type: "DELETE",
        url: '/user/heart/',
        data: JSON.stringify(items),
        contentType: 'application/json',
        success: function(result) {
            location.reload();
        },
        error: function(xhr) {
            alert('삭제에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

//================================================================
// 장바구니 ajax

function savetoCart() {

    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]:checked');
    checkboxes.forEach((checkbox) => {
        items.push(checkbox.value);
    });

    $.ajax({
        type: "POST",
        url: '/user/cart/',
        cache: false,
        contentType: "application/json",
        data: JSON.stringify(items),
        success: function(result) {
            if (result.success) {
                if(confirm(result.message)) {
                    window.location.href = '/user/cart';
                }
            } else {
                alert(result.message);
            }
        },
        error: function(xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}