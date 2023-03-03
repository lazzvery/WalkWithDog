'use strict';

const img_container = document.querySelector('.img_container'),
    shop_container = document.querySelector('.shopInfo_container'),
    main_image = img_container.getElementsByClassName('main_image'),
    sub_image = img_container.getElementsByClassName('sub_image'),
    heartBtn = shop_container.querySelector('.heartbBtn'),
    shareBtn = shop_container.querySelector('.sharebBtn'),
    shareBox = shop_container.querySelector('.shareProduct'),
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
    title_list = document.getElementsByClassName('title'),
    qna_content = document.getElementsByClassName('qna_content'),
    qna_write = document.querySelector('.itemQnaPopUp'),
    qna_update = document.querySelector('.updateQnaPopUp'),
    qna_write_btn = document.querySelector('.writebtn'),
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
// 스크롤 이벤트 (하단 오른쪽 메뉴바)

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
// qna 게시판 컨텐츠 보이게 하기

let before;
let count = 0;
for (let i = 0; i < qna_list.length; i++) {
    qna_box.addEventListener('click', (e) => {
        if (e.target == qna_list[i] || e.target == title_list[i]) {
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
// Form 열고 닫기

qna_write_btn.addEventListener('click', () => {
    qna_write.style.display = "block";
    body.style.overflow = "hidden";
});

function closeForm() {
    qna_write.style.display = "none";
    qna_update.style.display = "none";
    body.style.overflow = "auto";
}

function updateForm(title, content, seq) {
    qna_update.style.display = "block";
    body.style.overflow = "hidden";
    document.querySelector("#uitem_qna_title").value = title;
    document.querySelector("#uitem_qna_content").value = content;
    document.querySelector("#item_qna_seq").value = seq;
}

//==========================================================
// A-jax

function insertQna(event) {
    event.preventDefault(); // 원래 submit 버튼 동작 안 하게

    let formData = $('#insert-form').serialize(); // 폼 데이터 직렬화

    $.ajax({
        type: 'POST',
        url: '/item/itemDetail/' + $('#item_id').val(),
        data: formData, // 폼 데이터
        success: function(result) {
            $(".popBox").scrollTop(0);
            // 성공 시 처리할 내용
            if (result.success) {
                alert(result.message);

                $('.itemQnaPopUp').css('display', 'none');  // 팝업창 내리기
                $('body').css('overflow', 'auto');  // body의 스크롤 다시 생기게
                $('.qna_box').load('/item/itemDetail/' + $('#item_id').val() + ' .qna_box');    // 데이터 reload
                $('#insert-form')[0].reset();   // form 안의 인풋들 전부 원상복구

            } else {
                alert(result.message);
            }
        },
        error: function(xhr) {
            // 실패 시 처리할 내용
        }
    });

    return false;
}

function updateQna(event) {
    event.preventDefault(); // 원래 submit 버튼 동작 안 하게

    let formData = $('#update-form').serialize(); // 폼 데이터 직렬화

    $.ajax({
        type: 'Patch',
        url: '/item/itemDetail/' + $('#item_id').val(),
        data: formData, // 폼 데이터
        success: function(result) {
            $(".popBox").scrollTop(0);
            // 성공 시 처리할 내용
            if (result.success) {
                alert(result.message);

                $('.itemQnaPopUp').css('display', 'none');  // 팝업창 내리기
                $('body').css('overflow', 'auto');  // body의 스크롤 다시 생기게
                $('.qna_box').load('/item/itemDetail/' + $('#item_id').val() + ' .qna_box');    // 데이터 reload
                $('#update-form')[0].reset();   // form 안의 인풋들 전부 원상복구

            } else {
                alert(result.message);
            }
        },
        error: function(xhr) {
            // 실패 시 처리할 내용
        }
    });

    return false;
}

function deleteQna(itemQnaSeq) {
    $.ajax({
        type: "DELETE",
        url: '/item/itemDetail/' + $('#item_id').val(),
        data: {
            itemQnaSeq: itemQnaSeq
        },
        success: function(result) {
            if (result.success) {
                alert(result.message);
                $('body').css('overflow', 'auto');  // body의 스크롤 다시 생기게
                $('.qna_box').load('/item/itemDetail/' + $('#item_id').val() + ' .qna_box');    // 데이터 reload
            }
        },
        error: function(xhr) {
            // 실패 시 처리할 내용
        }
    });
}

//===========================================================
// 좋아요 관련 ajax

function updateHeart(hearted) {
    if (hearted) {
        heartBtn.src = "../../../img/icon/iheartfill.png";
    } else {
        heartBtn.src = "../../../img/icon/iheart.png";
    }
}

function saveHeart() {
    $.ajax({
        type: "POST",
        url: '/user/heart/' + $('#item_id').val(),
        cache: false,
        success: function(result) {
            alert(result.message);
            updateHeart(true); // 세션에 저장된 상품인 경우
            $('.product_summary').load('/item/itemDetail/' + $('#item_id').val() + ' .product_summary');
        },
        error: function(xhr) {
        }
    });
}

function deleteHeart() {
    $.ajax({
        type: "DELETE",
        url: '/user/heart/' + $('#item_id').val(),
        cache: false,
        success: function(result) {
            alert(result.message);
            updateHeart(false); // 세션에 저장되지 않은 상품인 경우
            $('.product_summary').load('/item/itemDetail/' + $('#item_id').val() + ' .product_summary');
        },
        error: function(xhr) {
        }
    });
}