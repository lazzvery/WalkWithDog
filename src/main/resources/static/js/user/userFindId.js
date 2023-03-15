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
    let phone = $('#user_phone').val();

    console.log(name, phone);

    $.ajax({
        url: "/user/findId",
        type: "POST",
        data: {"user_name": name, "user_phone": phone},
        success: function (data) {
            if(data !== "" && data !== null){
                $('.pageSelect').css("display","none");
                $('.findIdForm').css("display","none");
                $('.title').css("display","block");
                $('#id_value').text('"'+data+'"');
            }else{
                alert("이름이나 전화번호가 일치하지 않습니다.");
            }

        },
        error: function () {
            alert("에러입니다");
        }
    });

}