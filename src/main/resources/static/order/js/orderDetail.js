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

totalBtn.addEventListener('click', (e) => {
    e.preventDefault();
    if (selfDelivery.value === '0' || (selfDelivery.value === '5' && !selfDeliverybox.value)) {
        alert('배송 정보를 다시 확인해 주세요!');
    } else if (cardSelect[0].value === '0') {
        alert('결제 수단을 선택해 주세요!');
    } else if (!checkList[0].checked && (!checkList[1].checked || !checkList[2].checked || !checkList[3].checked)) {
        alert('개인 정보 수집 제공에 동의해 주세요!');
    } else {
        window.open('./product_popup.html', '_self');
    }
});     // 버튼 클릭시 유효성 검사