'use strict';

const joinContainer = document.querySelector('.joinContainer'),
    inputJoin = joinContainer.getElementsByTagName('input'),
    phoneText = joinContainer.querySelector('.phoneText'),
    petInfoBox = document.querySelector('.petInfoCover'),
    [dogSelct, catSelect] = petInfoBox.getElementsByTagName('select');

console.log(joinContainer);

function checkAlert(check, input) {
    if (!check.test(input.value)) {
        input.style.borderBottom = "1px solid rgb(182, 182, 182)";
        input.name == "phone2" || input.name == "phone3" ?
            phoneText.style.display = "none"
            :
            input.nextSibling.nextSibling.style.display = "none";
        // 맞을 때
    } else {
        input.style.borderBottom = "1px solid red";
        console.log(input.name)
        input.name == "phone2" || input.name == "phone3" ?
            phoneText.style.display = "block"
            :
            input.nextSibling.nextSibling.style.display = "block";

        // 아닐 때
    }
}       // 유효성 검사 style 함수

let password = '';
for (let i = 0; i < inputJoin.length; i++) {
    inputJoin[i].addEventListener('input', (e) => {
        let eventObj = e.target,
            checkKor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/,   // 한글만
            checkNum = /[0-9]+$/,       // 숫자만
            checkkorEng = /[a-z|A-Z|ㄱ-ㅎ|가-힣]/,      // 한글 영어만
            pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

        if (eventObj.name === 'id') {
            checkAlert(checkKor, eventObj);
        } else if (eventObj.name === 'name') {
            checkAlert(checkNum, eventObj);
        } else if (eventObj.name === 'email') {
            checkAlert(checkKor, eventObj);
        } else if (eventObj.name === 'phone2' || eventObj.name === 'phone3') {
            checkAlert(checkkorEng, eventObj);
        } else if (eventObj.name === 'password') {
            if (!!pwdCheck.test(eventObj.value)) {
                if (eventObj.value.length >= 10) {
                    password = eventObj.value;
                    eventObj.style.borderBottom = "1px solid rgb(182, 182, 182)";
                    eventObj.nextSibling.nextSibling.style.display = "none";

                }
            } else {
                eventObj.style.borderBottom = "1px solid red";
                eventObj.nextSibling.nextSibling.style.display = "block";
            }
        } else if (eventObj.name === 'passwordConfirm') {
            if (password == eventObj.value) {
                eventObj.style.borderBottom = "1px solid rgb(182, 182, 182)";
                eventObj.nextSibling.nextSibling.style.display = "none";
            } else {
                eventObj.style.borderBottom = "1px solid red";
                eventObj.nextSibling.nextSibling.style.display = "block";
            }
        }
    });
}   // 정규식 유효성 검사


petInfoBox.addEventListener('click', (e) => {
    if (e.target.id === 'dog') {
        dogSelct.style.display = 'block';
        catSelect.style.display = 'none';
    } else if (e.target.id === 'cat') {
        catSelect.style.display = 'block';
        dogSelct.style.display = 'none';
    }
});     // 반려동물 선택

