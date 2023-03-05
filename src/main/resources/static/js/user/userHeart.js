'use strict';

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
