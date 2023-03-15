const findIdForm = document.querySelector(".findIdForm");
    // findIdContainer = findIdForm.querySelector(".findIdContainer"),
    // checkBox = findIdForm.querySelector(".checkBox");


// checkBox.addEventListener("click", (e) => {
//
//
//     if (e.target.id === "emailCheck") {
//         findIdContainer.children[2].style.display = "block"
//         findIdContainer.children[3].style.display = "none"
//     } else if (e.target.id === "phoneCheck") {
//         findIdContainer.children[2].style.display = "none"
//         findIdContainer.children[3].style.display = "block"
//     }
// });


function pwButton() {
    let id = $('#user_id').val(),
        name = $('#user_name').val(),
        phone = $('#user_phone').val();

    console.log(name, phone);

    $.ajax({
        url: "/user/findpw",
        type: "POST",
        data: {"user_name": name, "user_phone": phone, "user_id": id},
        success: function (data) {
            if(data !== "" && data !== null){
                $('.findPwBox').css("display","none");
                $('.modifyForm').css("display","block");
                document.querySelector('#user_id2').value = data;
                console.log($('#user_id2').val());
            }else{
                alert("이름이나 전화번호가 일치하지 않습니다.");
            }

        },
        error: function () {
            alert("에러입니다");
        }
    });

}