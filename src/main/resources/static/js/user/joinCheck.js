let form = document.querySelector(".joinForm"),
    idValue = document.getElementById('user_id'),
    passwordValue = document.getElementById('user_password'),
    password2Value = document.getElementById('user_password2'),
    nameValue = document.getElementById('user_name'),
    phoneValue = document.getElementById('user_phone'),
    emailValue = document.getElementById('user_email'),
    joinInput = document.querySelector('.join');


const idRegex = /^[a-zA-Z0-9]{5,20}$/;
const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[~!@#$%^&*])[a-zA-Z\d~!@#$%^&*]{8,20}$/;
const nameRegex = /^[A-Za-z가-힣]*$/;
const phoneRegex = /^\d{3}\d{3,4}\d{4}$/;
const emailRegex = /\S+@\S+\.\S+/;

form.addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        event.preventDefault(); // 폼 제출 이벤트 기본 동작 막기
    }
});


idValue.addEventListener("input",() => {

    if (!idRegex.test(idValue.value)) {
        idValue.nextElementSibling.style.display = "block";
        joinInput.type = "button";
    }else{
        idValue.nextElementSibling.style.display = "none";
        joinInput.type = "submit";
    }
    // document.getElementById('idDup').focus();
});

passwordValue.addEventListener("input",() => {

    if (!pwRegex.test(passwordValue.value)) {
        passwordValue.nextElementSibling.style.display = "block";
        joinInput.type = "button";
    }else{
        passwordValue.nextElementSibling.style.display = "none";
        joinInput.type = "submit";
    }
});

password2Value.addEventListener("input",() => {

    if (password2Value.value !== passwordValue.value) {
        password2Value.nextElementSibling.style.display = "block";
        joinInput.type = "button";
    }else{
        password2Value.nextElementSibling.style.display = "none";
        joinInput.type = "submit";
    }
});

nameValue.addEventListener("input",() => {

    if (!nameRegex.test(nameValue.value)) {
        nameValue.nextElementSibling.style.display = "block";
        joinInput.type = "button";
    }else{
        nameValue.nextElementSibling.style.display = "none";
        joinInput.type = "submit";
    }
});

phoneValue.addEventListener("input",() => {

    if (!phoneRegex.test(phoneValue.value)) {
        phoneValue.parentElement.nextElementSibling.style.display = "block";
        joinInput.type = "button";
    }else{
        phoneValue.parentElement.nextElementSibling.style.display = "none";
        joinInput.type = "submit";
    }
});

emailValue.addEventListener("input",() => {

    if (!emailRegex.test(emailValue.value)) {
        emailValue.nextElementSibling.style.display = "block";
        joinInput.type = "button";
    }else{
        emailValue.nextElementSibling.style.display = "none";
        joinInput.type = "submit";
    }
});

joinInput.addEventListener("click", () =>{

    if(joinInput.type === "button"){
        alert("정확히 입력해주세요");
    }

});