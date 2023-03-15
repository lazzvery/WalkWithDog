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

function idButton() {
    let name = $('#user_name').val();
    let email = $('#user_email').val();
    let phone = $('#user_phone').val();

    console.log(name, phone);

    $.ajax({
        url: "/user/findId",
        type: "POST",
        data: {"name": name, "phone": phone , "email": email},
        success: function (data) {
            $('.pageSelect').css("display","none");
            $('.findIdForm').css("display","none");
            $('.title').css("display","block");
            $('#id_value').text('"'+data+'"');
        },
        error: function () {
            alert("에러입니다");
        }
    });

}