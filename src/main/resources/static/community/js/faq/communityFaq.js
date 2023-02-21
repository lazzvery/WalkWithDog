'use strict';

const notice = document.querySelector('.c_noticed'),
  li = notice.getElementsByTagName('li');

let tmp = li[0];

notice.addEventListener('click', function (e) {
  const list = e.target.parentNode;

  function tmpRemove() {
    tmp.classList.add('c_hidden');
  }

  if (list.classList.contains('c_service_list')) {
    tmpRemove();
    list.classList.remove('c_hidden');
    tmp = list;
  }
});

const menucategory = document.querySelector('.c_menucategory'),
  accordionBox = menucategory.querySelectorAll('.c_accordion li'),
  accordion = menucategory.querySelectorAll('.c_accordion li a'),
  contents = document.querySelectorAll('#accordionWrap li');

accordion[0].addEventListener('click', function (e) {
  e.preventDefault();

  for (let i = 0; i < accordion.length; i++) {
    accordionBox[i].style.borderBottom = 'none';
    accordion[i].style.fontWeight = 'normal';
  }

  accordionBox[0].style.borderBottom = 'solid 1px #477A7B';
  this.style.fontWeight = 'bold';

  for (let i = 0; i < contents.length; i++) {
    contents[i].style.display = 'block';
  }
});

accordion[1].addEventListener('click', function (e) {
  e.preventDefault();
  for (let i = 0; i < accordion.length; i++) {
    accordionBox[i].style.borderBottom = 'none';
    accordion[i].style.fontWeight = 'normal';
  }

  accordionBox[1].style.borderBottom = 'solid 1px #477A7B';
  this.style.fontWeight = 'bold';

  for (let i = 0; i < contents.length; i++) {
    contents[i].style.display = 'none';

    if (contents[i].dataset.filter === '주문/결제') {
      contents[i].style.display = 'block';
    }
  }
});

accordion[2].addEventListener('click', function (e) {
  e.preventDefault();
  for (let i = 0; i < accordion.length; i++) {
    accordionBox[i].style.borderBottom = 'none';
    accordion[i].style.fontWeight = 'normal';
  }

  accordionBox[2].style.borderBottom = 'solid 1px #477A7B';
  this.style.fontWeight = 'bold';

  for (let i = 0; i < contents.length; i++) {
    contents[i].style.display = 'none';

    if (contents[i].dataset.filter === '입금') {
      contents[i].style.display = 'block';
    }
  }
});

accordion[3].addEventListener('click', function (e) {
  e.preventDefault();
  for (let i = 0; i < accordion.length; i++) {
    accordionBox[i].style.borderBottom = 'none';
    accordion[i].style.fontWeight = 'normal';
  }

  accordionBox[3].style.borderBottom = 'solid 1px #477A7B';
  this.style.fontWeight = 'bold';
  for (let i = 0; i < contents.length; i++) {
    contents[i].style.display = 'none';

    if (contents[i].dataset.filter === '배송') {
      contents[i].style.display = 'block';
    }
  }
});

accordion[4].addEventListener('click', function (e) {
  e.preventDefault();
  for (let i = 0; i < accordion.length; i++) {
    accordionBox[i].style.borderBottom = 'none';
    accordion[i].style.fontWeight = 'normal';
  }

  accordionBox[4].style.borderBottom = 'solid 1px #477A7B';
  this.style.fontWeight = 'bold';
  for (let i = 0; i < contents.length; i++) {
    contents[i].style.display = 'none';

    if (contents[i].dataset.filter === '교환/반품') {
      contents[i].style.display = 'block';
    }
  }
});

accordion[5].addEventListener('click', function (e) {
  e.preventDefault();
  for (let i = 0; i < accordion.length; i++) {
    accordionBox[i].style.borderBottom = 'none';
    accordion[i].style.fontWeight = 'normal';
  }

  accordionBox[5].style.borderBottom = 'solid 1px #477A7B';
  this.style.fontWeight = 'bold';
  for (let i = 0; i < contents.length; i++) {
    contents[i].style.display = 'none';

    if (contents[i].dataset.filter === '회원') {
      contents[i].style.display = 'block';
    }
  }
});