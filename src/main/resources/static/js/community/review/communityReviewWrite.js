'use strict'

const title = document.querySelector('.c_review_title'),
  pwBox = document.querySelector('.inputPassword > input'),
  warning = document.getElementsByTagName('span'),
  file = document.querySelector('.files > input'),
  textarea = document.querySelector('textarea'),

  confirm = document.querySelector('button');

let checkPW;

pwBox.addEventListener("input", function () {
  checkPW = this.value;
});

confirm.addEventListener('click', function () {

  if (!title.value) {
    alert('제목을 입력해 주세요.')
  } else if (!textarea.value) {
    alert('내용을 입력해 주세요.')
  } else if (!file.value) {
    alert('파일을 첨부해 주세요.')
  } else if (!checkPW) {
    alert('비밀번호를 입력해 주세요.')
  }
});

