/* fullpage.js - layout */

const docEle = document.documentElement;
const sec = document.querySelectorAll('.sec');

for (let i = 0; i < sec.length; i++) {
    sec[i].onwheel = (e) => {
        // 기본 이벤트 방지
        e.preventDefault();
        if (e.deltaY > 0) {
            // 마우스 휠 내림
            // 이벤트 함수 안에서 사용한 e.currentTarget은 이벤트가 발생한 요소
            let next = e.currentTarget.nextElementSibling.offsetTop;
            docEle.scrollTop = next;
        } else {
            //마우스 휠 올림
            let prev = e.currentTarget.previousElementSibling.offsetTop;
            docEle.scrollTop = prev;
        }
    };

    // this를 쓰려면 화살표함수 X
    // for(let i=0; i<sec.length;i++){
    // sec[i].onwheel = function (e) {
    //     // 기본 이벤트 방지
    //     e.preventDefault();
    //     if (e.deltaY > 0) {
    //         // 마우스 휠 내림
    //         // 이벤트 함수 안에서 사용한 this는 이벤트가 발생한 요소
    //         let next = this.nextElementSibling.offsetTop;
    //         docEle.scrollTop = next;
    //     } else {
    //         //마우스 휠 올림
    //         let prev = this.previousElementSibling.offsetTop;
    //         docEle.scrollTop = prev;
    //     }
    // };
}


