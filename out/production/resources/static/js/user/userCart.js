'use strict';

const checkBox = document.querySelector('.shop_cartlist'),
    checkList = document.querySelectorAll('.checkedCheck'),
    product_checkNum = document.querySelectorAll('.product_checkNum'),
    cartAmountValue = document.querySelectorAll('#cartAmountValue');

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

for (let i = 0; i < product_checkNum.length; i++) {
    product_checkNum[i].addEventListener('click', (e) => {
        e.preventDefault();

        if (e.target.classList.contains('UpCheckbtn') || e.target.parentNode.classList.contains('UpCheckbtn')) {
            if(cartAmountValue[i].value < 10) {
                cartAmountValue[i].value = parseInt(cartAmountValue[i].value) + 1;
            }
        } else if(e.target.classList.contains('downCheckbtn') || e.target.parentNode.classList.contains('downCheckbtn')) {
            if(cartAmountValue[i].value > 1) {
                cartAmountValue[i].value = parseInt(cartAmountValue[i].value) - 1;
            }
        }
    }); // 장바구니 수량
}


//===============================================================
// ajax 장바구니 주문 금액 조회

function changeValue() {
    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]:checked');
    checkboxes.forEach((checkbox) => {
        const item = {
            item_id: checkbox.value,
            item_amount: null
        };

        const amountInput = checkbox.closest('.shop_cartleft').nextElementSibling.querySelector('input#cartAmountValue');
        item.item_amount = amountInput.value;
        items.push(item);
    });

    $.ajax({
        type: "POST",
        url: '/user/cart/calcPrice',
        data: JSON.stringify(items),
        contentType: "application/json",
        success: function (result) {
            let totalPay = result.price.toLocaleString();
            let totalDelivery = result.delivery.toLocaleString();
            let html = '<div class="payBoxContainer"><div class="paydeliverybox"><div class="paybox"><strong>주문금액</strong><span>' + totalPay + '원</span></div>';
            html += '<div class="deliverybox"><strong>배송비</strong><span>' + totalDelivery + '원</span></div></div>';
            html += '<div class="totalbox"><strong class="importantTotal">합계</strong><span>'
                + (parseInt(result.price) + parseInt(result.delivery)).toLocaleString() + '원</span></div></div>';
            $('.payBoxContainer').html(html);
        },
        error: function (xhr, status, error) {
            alert('조회에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

$(document).ready(function() {
    $('.product_checkNum').on('click', '.amountBtn', function() {
        changeValue();
    });

    $('.shop_cartlist').on('change', function() {
        changeValue();
    });
});



//===============================================================
// ajax 장바구니 삭제

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

//===============================================================
// ajax 주문 페이지 추가

function cartToOrder(event) {
    event.preventDefault();

    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]:checked');
    checkboxes.forEach((checkbox) => {
        const item = {
            item_id: checkbox.value,
            item_amount: null
        };

        const amountInput = checkbox.closest('.shop_cartleft').nextElementSibling.querySelector('input#cartAmountValue');
        item.item_amount = amountInput.value;
        items.push(item);
    });

    console.log(items);

    $.ajax({
        type: "POST",
        url: '/order/orderDetail',
        cache: false,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(items),
        success: function(result) {
            if(result.success) {
                window.location.href = '/order/orderDetail';
            }
        },
        error: function(xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
        }
    });

}

// 전체 상품 주문

function cartToOrderAll(event) {
    event.preventDefault();

    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]');
    checkboxes.forEach((checkbox) => {
        const item = {
            item_id: checkbox.value,
            item_amount: null
        };

        const amountInput = checkbox.closest('.shop_cartleft').nextElementSibling.querySelector('input#cartAmountValue');
        item.item_amount = amountInput.value;
        items.push(item);
    });

    console.log(items);

    $.ajax({
        type: "POST",
        url: '/order/orderDetail',
        cache: false,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(items),
        success: function(result) {
            if(result.success) {
                window.location.href = '/order/orderDetail';
            }
        },
        error: function(xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
        }
    });

}