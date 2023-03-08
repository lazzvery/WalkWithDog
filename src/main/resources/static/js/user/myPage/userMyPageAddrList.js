const myPageAddressContainer = document.querySelector(".myPageAddressContainer"),
    tbody = myPageAddressContainer.querySelector("tbody"),
    tbodyTr = tbody.querySelectorAll("tr"),
    checkBox = myPageAddressContainer.querySelector("table"),
    inputBox = myPageAddressContainer.querySelectorAll(".inputBox"),
    checkList = myPageAddressContainer.querySelectorAll("input"),
    choiceButton = myPageAddressContainer.querySelector(".choiceButton button"),
    noAddress = myPageAddressContainer.querySelector(".noAddress");


let trNumber;

window.onload = function () {
    trNumber = tbodyTr.length;
    if (tbodyTr.length === 0) {
        for (let i = 0; i < tbodyTr.length; i++) {
            tbodyTr[i].style.display = "none";
        }
        inputBox[0].style.display = "none";
        choiceButton.style.display = "none";
    } else {
        noAddress.style.display = "none";
    }
};



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
});      // 개인정보 약관 동의


choiceButton.addEventListener('click', function () {
    // const removeTr = tbody.querySelectorAll('tr input:checked');
    //
    //
    //
    // if (trNumber === 0) {
    //     for (let i = 0; i < tbodyTr.length; i++) {
    //         tbodyTr[i].style.display = "none";
    //     }
    //     inputBox[0].style.display = "none";
    //     choiceButton.style.display = "none";
    //     noAddress.style.display = "block";
    // }


})



function addrDelete() {

    let items = [];
    const checkboxes = document.querySelectorAll('input[name="agreeCheck"]:checked');
    checkboxes.forEach((checkbox) => {
        items.push(checkbox.value);
    });

    for (let i = 1; i < checkList.length; i++) {
        if(checkList[0].checked){
            if(!confirm("전체 배송 주소록을 삭제하시겠습니까?")) {
                return;
            }
        }else if(checkList[i].checked){
            if(!confirm("선택 배송 주소록을 삭제하시겠습니까?")) {
                return;
            }
        }
    }




    console.log(items);

    $.ajax({
        type: 'POST',
        url: '/user/myPage/addrDelete',
        data: JSON.stringify(items), // 폼 데이터
        contentType: 'application/json',
        success: function(result) {
            // 성공 시 처리할 내용
            $('#addrList').load('/user/myPage/addrList' + ' #addrList');    // 데이터 reload
        },
        error: function(xhr) {
            // 실패 시 처리할 내용
            alert('등록에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}
