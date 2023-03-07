'use strict';

function deleteCart(index) {
    $.ajax({
        type: "DELETE",
        url: '/user/cart/' + $('#agreeCheck' + index).val(),
        success: function(result) {
            alert(result.message);
            location.reload();
        },
        error: function(xhr) {
            alert('삭제에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

function deleteCarts(event) {
    event.preventDefault();

    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]:checked');
    checkboxes.forEach((checkbox) => {
        items.push(checkbox.value);
    });

    $.ajax({
        type: "DELETE",
        url: '/user/cart/',
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

function deleteAllCart(event) {
    event.preventDefault();

    if(!confirm("장바구니 목록을 전부 삭제하시겠습니까?")) {
        return;
    }

    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]');
    checkboxes.forEach((checkbox) => {
        items.push(checkbox.value);
    });

    $.ajax({
        type: "DELETE",
        url: '/user/cart/',
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