/* fullpage.js - layout */

const docEle = document.documentElement;
const sec = document.querySelectorAll('.sec');
const wh = window.innerHeight;

console.log(sec.length);
for (let i = 0; i < sec.length; i++) {
    sec[i].onwheel = (e) => {
        // 기본 이벤트 방지
        e.preventDefault();
        if (e.deltaY > 0) {
            // 마우스 휠 내림
            // 이벤트 함수 안에서 사용한 e.currentTarget은 이벤트가 발생한 요소
            if (docEle.scrollTop > wh * (sec.length - 2) + 100) return;
            let next = e.currentTarget.nextElementSibling.offsetTop;
            docEle.scrollTop = next;
        } else {
            //마우스 휠 올림
            // html의 스크롤 값이 창의 높이 보다 작으면 휠 이벤트 멈춤
            // if (docEle.scrollTop < wh) return;
            /*
            try ~ catch 예외 처리
            
            try {
                정상코드;
            } catch(err) {
                에러일 때 코드;
            } finally {
                무조건 실행할 코드;
            }
            */

            try {
                let prev = e.currentTarget.previousElementSibling.offsetTop;
                docEle.scrollTop = prev;
            } catch(err) {
                
            }
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
//     };
}
