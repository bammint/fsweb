/* 요소 불러오기 */
const btn = document.querySelector('.button');
const modal = document.querySelector('.modal');
const close = document.querySelector('.close');
const mo_cls = document.querySelectorAll('.mo_cls');
const bg = document.querySelector('.bg');
// console.log(mo_cls);


/* 이벤트 */
btn.addEventListener('click', ()=>{
    // console.log(btn);
    mo_cls[0].style.display = 'block';
    mo_cls[1].style.display = 'block';
}) 
close.addEventListener('click', ()=>{
    // console.log(close);
    mo_cls[0].style.display = 'none';
    mo_cls[1].style.display = 'none';
})
bg.addEventListener('click', ()=>{
    mo_cls[0].style.display = 'none';
    mo_cls[1].style.display = 'none';
})

/* 실행 */

// btn.addEventListener('click', ()=>{
//     // console.log(btn);
//     mo_cls.style.display = 'block';
// }) 

// for(let i=0; i<mo_cls.length; i++) {
//     mo_cls[i].addEventListener('click' )
// }



/* function btnClick() {
    modal.style.display = 'block';
}

btn.addEventListener("click", btnClick);

function closeBtn() {
    modal.style.display = 'none';
}
 */
/* close가 click 이벤트 인식 =>
클릭을 하면 함수 closeBtn()이 실행된다  */

// close.addEventListener('click', closeBtn);
