const carousel = document.querySelector('.carousel');
const prevBtn = document.querySelector('.prevBtn');
const nextBtn = document.querySelector('.nextBtn');
// 이미지 index값
let index = 0;


prevBtn.addEventListener('click', () => {
    // 첫번째 이미지에서 뒤로 가기했을때, 마지막 페이지로 이동
    if(index ===0){
        index = 2;
    }else{
        // 이미지 하나씩 뒤로 넘기기
        index -= 1;
    };
    // console.log(index);
    // 이미지 height 만큼 밀어서 다음이미지 표시
      //     `translate3d( 0, -${300 * index}px, 0)`  y축으로 이동하여 이미지 위로 이동
    carousel.style.transform = `translate3d( 0, -${300 * index}px, 0)`;
})

nextBtn.addEventListener('click', ()=> {
    // 마지막 이미지에서 클릭 시 초기 이미지로 이동
    if(index ===2){
        index = 0;
    }else{
        // 이미지 하나씩 넘기기
        index += 1;
    }
    // console.log(index);
       // 이미지 height 만큼 밀어서 다음이미지 표시
    //     `translate3d( 0, -${300 * index}px, 0)`  y축으로 이동하여 이미지 위로 이동
    carousel.style.transform = `translate3d( 0, -${300 * index}px, 0)`;
})


// 추후 추가사항
// 이미지를 배열로 하여 구현


// ex  [a, b, c]  ->  a, b, c 슬라이드