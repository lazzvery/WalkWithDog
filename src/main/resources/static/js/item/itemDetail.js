'use strict';

const img_container = document.querySelector('.img_container'),
    shop_container = document.querySelector('.shopInfo_container'),
    main_image = img_container.getElementsByClassName('main_image'),
    sub_image = img_container.getElementsByClassName('sub_image'),
    heartBtn = shop_container.querySelector('.heartbBtn'),
    shareBtn = shop_container.querySelector('.sharebBtn'),
    shareBox = shop_container.querySelector('.shareProduct'),
    sideCategory = document.querySelector('.categoryProduct'),
    urlCopyBtn = document.querySelector('.urlCopy'),
    qna_write = document.querySelector('.itemQnaPopUp'),
    qna_update = document.querySelector('.updateQnaPopUp'),
    qna_write_btn = document.querySelector('.writebtn'),
    body = document.querySelector("body");

//===========================================================
// 이미지 슬라이드

for (let i = 0; i < sub_image.length; i++) {
    sub_image[i].addEventListener('mouseenter', function (event) {
        if (event.target === sub_image[i]) {
            main_image[(i + 1) % main_image.length].src = `${sub_image[i].src}`;
            main_image[(i + 1) % main_image.length].classList.remove('img_hidden');
            main_image[i % main_image.length].classList.add('img_hidden');
        }
    })
}

//===========================================================
// url 복사

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


//===========================================================
// 공유 아이콘

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
});

urlCopyBtn.addEventListener('click', clip);

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
// qna 게시판 컨텐츠 보이게 하기

let open = false;

function checkId(check, password, index) {
    let content = document.getElementById("content" + index);

    if (!!check) {
        openbtn(content);
    } else {
        if (!!password) {
            alert("비밀글입니다");
        } else {
            openbtn(content);
        }
    }
}

function openbtn(content) {
    if (!open) {
        content.style.display = "block";
        open = true;
    } else {
        content.style.display = "none";
        open = false;
    }
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

function updateForm(title, content, seq, password) {
    qna_update.style.display = "block";
    body.style.overflow = "hidden";
    document.querySelector("#uitem_qna_title").value = title;
    document.querySelector("#uitem_qna_content").value = content;
    document.querySelector("#item_qna_seq").value = seq;
    document.querySelector("#ubtCheck").checked = password == 1 ? "checked" : "";
}

//==========================================================
// 스크롤 저장 코드

function saveScrollPosition() {
    localStorage.setItem("scrollPosition", window.pageYOffset);
}

window.onload = function() {
    let scrollPosition = localStorage.getItem("scrollPosition");
    if (scrollPosition !== null) {
        window.scrollTo(0, scrollPosition);
        localStorage.removeItem("scrollPosition");
    }
}

//===========================================================
// 결제 금액



//==========================================================
// A-jax

function addPrice() {
    $.ajax({
        type: "POST",
        url: '/item/itemDetail/' + $('#item_id').val(),
        data: {
            'selected': $('.form-control option:selected').val()
        },
        success: function(result) {
            let totalPay = result.orderPrice.toLocaleString();
            let html = '<span>주문 금액</span><strong class="totalPay">' + totalPay + '원</strong>';
            $('.product_totalPay').html(html);
        },
        error: function(xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

//==========================================================
// A-jax

function insertQna(event) {
    let titleInput = document.getElementById('item_qna_title');
    let contentTextarea = document.getElementById('item_qna_content');
    let formData = $('#insert-form').serialize(); // 폼 데이터 직렬화

    event.preventDefault(); // 원래 submit 버튼 동작 안 하게

    if (!titleInput.value.trim()) {
        alert('문의글의 제목을 입력해주세요.');
        return false;
    } else if(!contentTextarea.value.trim()) {
        alert('문의글의 내용을 입력해주세요.');
        return false;
    }

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
                window.location.href = '/user/login';
            }
        },
        error: function(xhr) {
            // 실패 시 처리할 내용
            alert('등록에 실패하였습니다. 다시 시도해주세요.');
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
            alert('수정에 실패하였습니다. 다시 시도해주세요.');
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
            alert('삭제에 실패하였습니다. 다시 시도해주세요.');
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
            if (result.success) {
                alert(result.message);
                updateHeart(true); // 세션에 저장된 상품인 경우
                $('.product_summary').load('/item/itemDetail/' + $('#item_id').val() + ' .product_summary');
            } else {
                alert(result.message);
                window.location.href = '/user/login';
            }
        },
        error: function(xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
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
            alert('삭제에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}

//===========================================================
// 장바구니 관련 ajax

function saveCart() {
    $.ajax({
        type: "POST",
        url: '/user/cart/' + $('#item_id').val(),
        data: {
            'selected': $('.form-control option:selected').val()
        },
        cache: false,
        success: function(result) {
            if (result.success) {
                alert(result.message);
            } else {
                alert(result.message);
                window.location.href = '/user/login';
            }
        },
        error: function(xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}