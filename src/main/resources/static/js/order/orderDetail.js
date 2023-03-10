'use strict';

const selfDelivery = document.querySelector('.shop_deliveryplz'),
    selfDeliverybox = document.querySelector('.selfDeliverybox'),
    optionDelivery = selfDelivery.getElementsByTagName('option'),
    payContainer = document.querySelector('.couponpaydiv'),
    cardTab = payContainer.querySelector('.cardTab'),
    paycontainer_easy = payContainer.querySelector('.paycontainer_easy'),
    paycontainer_card = payContainer.querySelector('.paycontainer_card'),
    cardSelect = payContainer.getElementsByTagName('select'),
    checkBox = document.querySelector('.orderprivacybox'),
    checkList = checkBox.getElementsByTagName('input'),
    totalBtn = document.querySelector('.totalorderbutton');

selfDelivery.addEventListener('click', (e) => {
    optionDelivery[0].disabled = true;
    if (e.target.value === '5') {
        selfDeliverybox.style.display = 'inline-block';
    } else {
        selfDeliverybox.style.display = 'none';
    }
});     // 직접 입력시 text창 나오게

let tmp = cardTab;
payContainer.addEventListener('click', (e) => {
    if (e.target.tagName === 'BUTTON') {
        e.preventDefault();
        if (e.target != tmp) {
            e.target.classList.add('bordButton');
            tmp.classList.remove('bordButton');
            tmp = e.target;

            if (e.target.classList.contains('cardTab')) {
                paycontainer_card.style.display = 'flex';
                paycontainer_easy.style.display = 'none';
            } else if (e.target.classList.contains('easyTab')) {
                paycontainer_easy.style.display = 'block';
                paycontainer_card.style.display = 'none';
            } else {
                paycontainer_card.style.display = 'none';
                paycontainer_easy.style.display = 'none';
            }
        }
    }
});     // 결제 수단 탭 display

cardSelect[0].addEventListener('click', (e) => {
    if (e.target.value != 0) {
        cardSelect[1].style.backgroundColor = "white";
        cardSelect[1].style.color = "#353535";
        cardSelect[1].disabled = false;
    } else {
        cardSelect[1].style.backgroundColor = "#f5f5f5";
        cardSelect[1].style.color = "#bdbdbd";
        cardSelect[1].disabled = true;
    }
});     // 신용카드 select 설정 탭

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
});     // 개인정보 약관 동의

// totalBtn.addEventListener('click', (e) => {
//     e.preventDefault();
//     if (selfDelivery.value === '0' || (selfDelivery.value === '5' && !selfDeliverybox.value)) {
//         alert('배송 정보를 다시 확인해 주세요!');
//     } else if (cardSelect[0].value === '0') {
//         alert('결제 수단을 선택해 주세요!');
//     } else if (!checkList[0].checked && (!checkList[1].checked || !checkList[2].checked || !checkList[3].checked)) {
//         alert('개인 정보 수집 제공에 동의해 주세요!');
//     } else {
//         requestPay();
//     }
// });     // 버튼 클릭시 유효성 검사

//=============================================================
// 쿠폰 합산 금액 ajax

function addCouponPrice() {
    $.ajax({
        type: "Patch",
        url: '/order/orderDetail',
        data: {
            'selected': $('.order_coupon option:selected').val()
        },
        success: function (result) {
            let benefits = result.benefits;
            let totalPrice = parseInt(result.orderPrice) - parseInt(benefits);

            let html = '<div class="order_couponpay"><div>쿠폰 사용</div><span> - ' + benefits + '원</span></div><hr>';
            html += '<div class="order_totalpay"><div>최종 결제 금액</div><div><strong>' + totalPrice.toLocaleString() + '원</strong></div></div>';
            html += '<input type="hidden" id="totalPriceId" value="' + totalPrice + '">';

            $('.ajaxCouponPrice').html(html);
        },
        error: function (xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

//=============================================================
// 결제 api

function proceedPay() {
    $.ajax({
        url: '/payment/proceed',
        type: 'POST',
        data: {
            'coupon': $('.order_coupon option:selected').val(),
            'price': $('#totalPriceId').val(),
        },
        success: function (result) {
            requestPay(result);
        },
        error: function (xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

function requestPay(result) {
    var IMP = window.IMP;
    IMP.init("imp82561317");

    IMP.request_pay({
        pg: 'html5_inicis',
        pay_method: 'card',
        merchant_uid: result.orderCode,
        name: '결제테스트',
        amount: result.price,
        buyer_email: result.userDTO.user_email,
        buyer_name: result.userDTO.user_name,
        buyer_tel: result.userDTO.user_phone,
        buyer_addr: result.addrDTO.addr_addr + result.addrDTO.addr_addr2,
        buyer_postcode: result.addrDTO.addr_postcode,
    }, function (rsp) { // callback
        if (rsp.success) {
            // 결제 성공
            jQuery.ajax({
                url: "/payment/succeed",
                method: "POST",
                data: {
                    imp_uid: rsp.imp_uid,            // 결제 고유번호
                    merchant_uid: rsp.merchant_uid   // 주문번호
                },
            }).done(function (data) {
                // 가맹점 서버 결제 API 성공시 로직
                alert("결제 성공!!");
                window.location.href = '/home';
            });
        } else {
            // 결제 실패
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            alert(msg);
        }
    });
}

