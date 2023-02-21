'use strict';

const infoContainer = document.querySelector('.shop_oderinfo'),
    phoneInput = infoContainer.querySelector('.phoneInput'),
    emailInput = infoContainer.querySelector('.emailInput'),
    nameInput = infoContainer.querySelector('.nameInput'),
    alertEmail = infoContainer.querySelector('.alertEmail'),
    alertName = infoContainer.querySelector('.alertName'),
    alertPhone = infoContainer.querySelector('.alertPhone'),
    selfTextbox = infoContainer.querySelector('.selfTextbox'),
    selectEmail = document.querySelector('.emailSelect'),
    optionEmail = selectEmail.getElementsByTagName('option'),
    selfDelivery = document.querySelector('.shop_deliveryplz'),
    selfDeliverybox = document.querySelector('.selfDeliverybox'),
    optionDelivery = selfDelivery.getElementsByTagName('option'),
    payContainer = document.querySelector('.couponpaydiv'),
    cardTab = payContainer.querySelector('.cardTab'),
    paycontainer_easy = payContainer.querySelector('.paycontainer_easy'),
    paycontainer_card = payContainer.querySelector('.paycontainer_card'),
    cardSelect = payContainer.getElementsByTagName('select'),
    checkBox = document.querySelector('.orderprivacybox'),
    checkList = checkBox.getElementsByTagName('input'),
    pointBtn = document.querySelector('.pointBtn'),
    totalBtn = document.querySelector('.totalorderbutton');

let Checkup = true;

function checkAlert(check, input, alert) {
    if (!check.test(input.value)) {
        input.style.border = "1px solid rgb(182, 182, 182)"
        alert.style.display = "none";
        Checkup = 1;
    } else {
        input.style.border = "1px solid red"
        alert.style.display = "block";
        Checkup = 0;
    }
}       // 틀린 정보 입력시 alert 주는 함수

function selfInput(self, box) {
    if (self.target.value === '5') {
        box.style.display = 'inline-block';
    } else {
        box.style.display = 'none';
    }
}       // 직접 입력시 style 지정 함수


infoContainer.addEventListener('input', (e) => {
    let checkKor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/,
        checkNum = /[0-9]+$/,
        checkkorEng = /[a-z|A-Z|ㄱ-ㅎ|가-힣]/;

    if (e.target.classList.contains('phoneInput')) {
        checkAlert(checkkorEng, phoneInput, alertPhone);
        if (phoneInput.value.length >= 5 && phoneInput.value.slice(4, 5) !== '-') {
            phoneInput.value = phoneInput.value.slice(0, 4) + '-' + phoneInput.value.slice(4);
        }
    } else if (e.target.classList.contains('emailInput')) {
        checkAlert(checkKor, emailInput, alertEmail);
    } else if (e.target.classList.contains('nameInput')) {
        checkAlert(checkNum, nameInput, alertName);
    } else if (e.target.classList.contains('selfTextbox')) {
        checkAlert(checkKor, selfTextbox, alertEmail);
    }
});     // 주문자 정보 유효성 검사

selectEmail.addEventListener('click', (e) => {
    optionEmail[0].disabled = true;
    selfInput(e, selfTextbox);
});

selfDelivery.addEventListener('click', (e) => {
    optionDelivery[0].disabled = true;
    selfInput(e, selfDeliverybox);
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

pointBtn.addEventListener('click', (e) => {
    e.preventDefault();
    alert('사용 가능한 적립금이 없습니다!');
});

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
    if (nameInput.value === '' || !Checkup || !selectEmail.value || (selectEmail.value === '5' && !selfTextbox.value)) {
        alert('입력 정보를 다시 확인해 주세요!');
    } else if (selfDelivery.value === '0' || (selfDelivery.value === '5' && !selfDeliverybox.value)) {
        alert('배송 정보를 다시 확인해 주세요!');
    } else if (cardSelect[0].value === '0') {
        alert('결제 수단을 선택해 주세요!');
    } else if (!checkList[0].checked && (!checkList[1].checked || !checkList[2].checked || !checkList[3].checked)) {
        alert('개인 정보 수집 제공에 동의해 주세요!');
    } else if (phoneInput.value.length != 9) {
        alert('휴대폰 번호를 8자리 입력해 주세요!')
    } else {
        window.open('./product_popup.html', '_self');
    }
});     // 버튼 클릭시 유효성 검사