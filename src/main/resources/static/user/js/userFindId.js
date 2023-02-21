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