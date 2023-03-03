'use strict';

const img_container = document.querySelector('.img_container'),
    shop_container = document.querySelector('.shopInfo_container'),
    main_image = img_container.getElementsByClassName('main_image'),
    sub_image = img_container.getElementsByClassName('sub_image'),
    heartBtn = shop_container.querySelector('.heartbBtn'),
    shareBtn = shop_container.querySelector('.sharebBtn'),
    shareBox = shop_container.querySelector('.shareProduct'),
    [reviewBtn, qnaBtn] = document.getElementsByClassName('writebtn'),
    reviewCate = document.getElementsByClassName('reviewtitle'),
    checkBox = document.querySelector('.product_check'),
    deleteBtn = shop_container.getElementsByClassName('product_checklist'),
    selectBox = document.querySelector('.optionSelect'),
    option = selectBox.getElementsByTagName('option'),
    totalPay = document.querySelector('.totalPay'),
    input = checkBox.getElementsByTagName('input'),
    sideCategory = document.querySelector('.categoryProduct'),
    urlCopyBtn = document.querySelector('.urlCopy'),
    addCart = shop_container.querySelector('.btn_cart'),
    butNow = shop_container.querySelector('.btn_buy'),
    qna_box = document.querySelector('.qna_box'),
    qna_list = qna_box.getElementsByTagName('li'),
    qna_title = qna_box.getElementsByTagName('span'),
    qna_content = document.getElementsByClassName('qna_content'),
    qna_write = document.querySelector('.itemQnaPopUp'),
    qna_write_btn = document.querySelector('.writebtn'),
    qna_close = qna_write.getElementsByTagName('img'),
    body = document.querySelector("body");


const optionSelect = [
    {
        name: "캐시미어 블루 M",
        price: 29900,
        amount: 1,
    },
    {
        name: "캐시미어 블루 L",
        price: 39900,
        amount: 1,
    },
    {
        name: "라벤더 포그 M",
        price: 29900,
        amount: 1,
    },
    {
        name: "라벤더 포그 L",
        price: 39900,
        amount: 1,
    }
];

function loginCheck() {
    if (confirm('로그인이 필요한 서비스입니다, 로그인 하시겠습니까?')) {
        window.open('../User/login/login.html', '_self');
    }
}

function clip() {
    let url = '';
    let textarea = document.createElement("textarea");

    document.body.appendChild(textarea);
    url = window.document.location.href;
    textarea.value = url;
    textarea.select();
    document.execCommand("copy");
    document.body.removeChild(textarea);

    alert("URL이 복사되었습니다.");
}

// 함수 ==========================================================

for (let i = 0; i < sub_image.length; i++) {
    sub_image[i].addEventListener('mouseenter', function (event) {
        if (event.target === sub_image[i]) {
            main_image[(i + 1) % main_image.length].src = `${sub_image[i].src}`;
            main_image[(i + 1) % main_image.length].classList.remove('img_hidden');
            main_image[i % main_image.length].classList.add('img_hidden');
        }
    })
}       // 이미지 슬라이드

let heart = false;
heartBtn.addEventListener('click', function () {
    if (!heart) {
        heartBtn.src = "../../../img/icon/iheartfill.png";
        heartBtn.style.opacity = "1";
        heart = true;
    } else {
        heartBtn.src = "../../../img/icon/iheart.png";
        heartBtn.style.opacity = ".5";
        heart = false;
    }
});     // 좋아요 아이콘

let share = false;
shareBtn.addEventListener('click', () => {
    if (!share) {
        shareBox.style.opacity = '1';
        shareBox.style.visibility = 'visible';
        share = true;
    } else {
        shareBox.style.opacity = "0";
        shareBox.style.visibility = 'hidden';
        share = false;
    }
});     // 공유 아이콘

//===========================================================
// 결제 금액

let price = 0;
selectBox.addEventListener('change', function (e) {
    let selectIndex = e.target.value;

    if (deleteBtn[selectIndex].classList.contains('hidden')) {
        deleteBtn[selectIndex].classList.remove('hidden');
        option[0].disabled = true;

        price += optionSelect[selectIndex].price * optionSelect[selectIndex].amount;
        totalPay.textContent = `${price.toLocaleString()}원`;
    }
});     // 옵션 선택시 상품 탭 보이게

for (let i = 0; i < deleteBtn.length; i++) {
    deleteBtn[i].addEventListener('click', function (event) {
        event.preventDefault();
        if (event.target.className === "deleteoptionBtn") {
            if (confirm('정말 삭제하시겠습니까?')) {
                deleteBtn[i].classList.add('hidden');
                option[0].selected = true;

                price -= optionSelect[i].price * optionSelect[i].amount;
                totalPay.textContent = `${price.toLocaleString()}원`;
                optionSelect[i].amount = 1;
                input[i].value = optionSelect[i].amount;
            }
        }

        if (event.target.parentNode.className === "downCheckbtn" ||
            event.target.className === "downCheckbtn") {
            if (optionSelect[i].amount > 1) {
                optionSelect[i].amount = optionSelect[i].amount - 1;
                input[i].value = optionSelect[i].amount;
                price -= optionSelect[i].price;
                totalPay.textContent = `${price.toLocaleString()}원`;
            }
        } else if (event.target.parentNode.className === "UpCheckbtn" ||
            event.target.className === "UpCheckbtn") {
            if (optionSelect[i].amount < 10) {
                optionSelect[i].amount = optionSelect[i].amount + 1;
                input[i].value = optionSelect[i].amount;
                price += optionSelect[i].price;
                totalPay.textContent = `${price.toLocaleString()}원`;
            }
        }
    })
}       // 상품 탭 x버튼 클릭시 삭제

shop_container.addEventListener('click', function (event) {
    let eventObj = event.target;

    if (eventObj === butNow || eventObj === addCart) {
        if (price !== 0) {
            eventObj.href = eventObj === addCart ? "./product_shopping_cart.html" : "./product_shopping_payment.html";
        } else {
            alert('구매하실 상품을 선택해 주세요!');
        }
    }
});     // 상품 미선택시 경고창 띄우는 이벤트

//===========================================================
// review, q&a 카테고리

let pastlist = reviewCate[0];
for (let i = 0; i < reviewCate.length; i++) {
    reviewCate[i].addEventListener('click', function (event) {
        let currentlist = event.target;

        currentlist.classList.add('focustitle');
        pastlist.classList.remove('focustitle');
        pastlist = currentlist;
    })
}

// reviewBtn.addEventListener('click', loginCheck);
// qnaBtn.addEventListener('click', loginCheck);

//===========================================================
// 스크롤 이벤트

document.addEventListener('scroll', () => {
    let posY = parseInt(window.scrollY);

    if (posY > 600) {
        sideCategory.style.opacity = '1';
        sideCategory.style.visibility = 'visible';
    } else {
        sideCategory.style.opacity = '0';
        sideCategory.style.visibility = 'hidden';
    }
});

//===========================================================
// 공유버튼 (카피 이벤트)

urlCopyBtn.addEventListener('click', clip);

//===========================================================
let before;
let count = 0;
for (let i = 0; i < qna_list.length; i++) {
    qna_box.addEventListener('click', (e) => {
        if (e.target == qna_list[i]) {
            qna_content[i].style.display = "block";
            if (count > 0) {
                before.style.display = "none";
            }
            before = qna_content[i];
            count++;
        }
    });
}

//===========================================================

qna_write_btn.addEventListener('click', () => {
    qna_write.style.display = "block";
    body.style.overflow = "hidden";
});

qna_close[0].addEventListener('click', () => {
    qna_write.style.display = "none";
    body.style.overflow = "auto";
});

//==========================================================
// A-jax

function insertQna(event) {
    event.preventDefault();

    let formData = $('#insert-form').serialize(); // 폼 데이터 serialize

    $.ajax({
        type: $('form').attr("method"),
        url: $('form').attr("action"), // 요청 URL
        data: formData, // 폼 데이터
        success: function(result) {
            // 성공 시 처리할 내용
            if (result.success) {
                // 성공적으로 질문이 등록되었다는 메시지를 사용자에게 알림
                alert(result.message);

                // 새로운 질문을 목록에 추가
                let qnaList = $("#qnaList");
                let newQuestion = $(result.html).find(".question");
                qnaList.append(newQuestion);

                // 입력 필드 초기화
                $("form#qnaForm input[type=text]").val("");
            } else {
                // 요청 처리 중 에러가 발생했다는 메시지를 사용자에게 알림
                alert(result.message);
            }
        },
        error: function(xhr) {
            // 실패 시 처리할 내용
        }
    });

    return false;
}