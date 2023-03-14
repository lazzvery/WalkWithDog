const findIdForm = document.querySelector(".findIdForm"),
    findIdContainer = findIdForm.querySelector(".findIdContainer"),
    checkBox = findIdForm.querySelector(".checkBox");


checkBox.addEventListener("click", (e) => {


    if (e.target.id === "emailCheck") {
        findIdContainer.children[1].style.display = "block"
        findIdContainer.children[2].style.display = "none"
    } else if (e.target.id === "phoneCheck") {
        findIdContainer.children[1].style.display = "none"
        findIdContainer.children[2].style.display = "block"
    }
});

function idButton(event) {
    let html = '';


    let user_name = $('#user_name').val(),
        user_email = $('#user_email').val(),
        user_phone = $('#user_phone').val();



    let sendData = "userEmail="+user_email+"userPhone="+user_phone+"userName"+user_name;

    $.ajax({
        type: "POST",
        url: '/user/userFindId',
        datatype: "text",
        data: sendData,
        success: function (text) {
            html += <div>성공</div>;
        },
        error: function (xhr) {
            alert('저장에 실패하였습니다. 다시 시도해주세요.');
        }
    });

}