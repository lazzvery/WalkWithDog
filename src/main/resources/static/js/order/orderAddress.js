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
    const removeTr = tbody.querySelectorAll('tr input:checked');

    for (let i = 0; i < removeTr.length; i++) {
        removeTr[i].closest('tr').remove();
    }

    trNumber -= removeTr.length;

    if (trNumber === 0) {
        for (let i = 0; i < tbodyTr.length; i++) {
            tbodyTr[i].style.display = "none";
        }
        inputBox[0].style.display = "none";
        choiceButton.style.display = "none";
        noAddress.style.display = "block";
    }


})

// choiceButton.addEventListener("click", function(){


// });