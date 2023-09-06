/* 요소 불러오기 */
const btn = document.querySelector('.button');
const modal = document.querySelector('.modal');
const close = document.querySelector('.close');

/* 이벤트 */
btn.addEventListener('click', ()=>{
    // console.log(btn);
    modal.style.display = 'block';
}) 
close.addEventListener('click', ()=>{
    // console.log(close);
    modal.style.display = 'none';
})
/* 실행 */

btn.addEventListener('click', ()=>{
    // console.log(btn);
    modal.style.display = 'block';
}) 


function btnClick() {
    modal.style.display = 'block';
}

btn.addEventListener("click", btnClick);

function closeBtn() {
    modal.style.display = 'none';
}

/* close가 click 이벤트 인식 =>
클릭을 하면 함수 closeBtn()이 실행된다  */

close.addEventListener('click', closeBtn);
