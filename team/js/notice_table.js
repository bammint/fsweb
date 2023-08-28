// 테이블을 불러온다
const t1 = document.querySelector('.t1');
const t2 = document.querySelector('.t2');
// 버튼을 불러온다
const btn1 = document.querySelector('.nbtn1');
const btn2 = document.querySelector('.nbtn2');
// 버튼을 클릭했을때 이벤트

// 함수
function table1(){
    t2.style.display = 'none';
    t1.style.display = 'block';
    t1.style.border = 'none';
};
function table2(){
    t1.style.display = 'none';
    t2.style.display = 'block';
    t2.style.border = 'none';
};
// 실행
btn1.addEventListener('click', table1);
btn2.addEventListener('click', table2);