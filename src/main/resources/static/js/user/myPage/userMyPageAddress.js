const myPageAddressContainer = document.querySelector(".myPageAddressContainer"),
    tbody = myPageAddressContainer.querySelector("tbody"),
    tbodyTr = tbody.querySelectorAll("tr"),
    inputBox = myPageAddressContainer.querySelectorAll(".inputBox"),
    inputBoxinput = myPageAddressContainer.querySelectorAll("input"),
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



inputBoxinput[0].addEventListener("click", function () {

    for (let i = 0; i < inputBoxinput.length; i++) {
        inputBoxinput[i].checked = this.checked;
    }
});

for (let i = 0; i < inputBoxinput.length; i++) {
    inputBoxinput[i].checked = this.checked;

    inputBoxinput[i].addEventListener("click", function () {
        if (this === inputBoxinput[0] && inputBoxinput[0].checked) {
            inputBoxinput[i].checked = true;
        } else if (this === inputBoxinput[0]) {
            inputBoxinput[i].checked = false;
        } else {
            inputBoxinput[0].checked = false;
        }
    });
}


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