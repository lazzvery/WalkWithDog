const myPageAddressContainer = document.querySelector(".myPageAddressContainer"),
    tbody = myPageAddressContainer.querySelector("tbody"),
    tbodyTr = tbody.querySelectorAll("tr"),
    inputBox = myPageAddressContainer.querySelectorAll(".inputBox"),
    checkBox = myPageAddressContainer.querySelector("table"),
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

            checkList[i].checked = false;
            e.target.checked = true;
        }
    }

})      // 개인정보 약관 동의


// choiceButton.addEventListener('click', function () {
//     const removeTr = tbody.querySelectorAll('tr input:checked');
//
//     for (let i = 0; i < removeTr.length; i++) {
//         removeTr[i].closest('tr').remove();
//     }
//
//     trNumber -= removeTr.length;
//
//     if (trNumber === 0) {
//         for (let i = 0; i < tbodyTr.length; i++) {
//             tbodyTr[i].style.display = "none";
//         }
//         inputBox[0].style.display = "none";
//         choiceButton.style.display = "none";
//         noAddress.style.display = "block";
//     }
//
//
// })


function addrUpdate() {

    let item = document.querySelector('input[name="agreeCheck"]:checked').value;

    console.log(item);

    $.ajax({
        type: 'POST',
        url: '/order/addrList',
        data: JSON.stringify(item), // 폼 데이터
        contentType: 'application/json',
        success: function(result) {
            // 성공 시 처리할 내용
            opener.location.reload();
            window.close();
        },
        error: function(xhr) {
            // 실패 시 처리할 내용
            alert('등록에 실패하였습니다. 다시 시도해주세요.');
        }
    });
}