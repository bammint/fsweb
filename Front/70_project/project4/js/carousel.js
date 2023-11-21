/* carousel */
// 변수 선언
let idx = 0,
    eDelay = 0,
    currentIdx = 0,
    auto;

const slide = document.querySelector('.slide'),
    slideList = slide.querySelectorAll('li'),
    npBtn = document.querySelectorAll('.ctls a'),
    indiBtn = document.querySelectorAll('.indi li'),
    speed = 700;

// 로딩 시 자동 슬라이드
autoSlide();

function autoSlide() {
    // setInterval(함수, 시간): 시간(밀리초) 후 반복
    // auto 변수는 사용자가 버튼 클릭 시 자동 슬라이드를 정지
    auto = setInterval(() => nextSlide(), speed * 4);
}

// prev
npBtn[0].onclick = () => {
    // 사용자가 버튼 클릭 시 자동 슬라이드 정지
    clearInterval(auto);

    // 만약 dDelay가 0이 아니면 click 이벤트 벗어남.
    if (eDelay) return;
    // 두 번째 클릭시 적용
    eDelay = 1;
    setTimeout(() => { eDelay = 0; autoSlide(); }, speed);

    prevSlide();

}; //prev

// next
npBtn[1].onclick = () => {
    // 사용자가 버튼 클릭 시 자동 슬라이드 정지
    clearInterval(auto);

    // 만약 dDelay가 0이 아니면 click 이벤트 벗어남.
    if (eDelay) return;
    // 두 번째 클릭시 적용
    eDelay = 1;
    setTimeout(() => { eDelay = 0; autoSlide(); }, speed);

    nextSlide();

}; //next

function prevSlide() {
    // 0 -> 4 -> 3 -> 2 -> 1
    slideList[idx].style.left = '-100%';
    slideList[idx].style.transition = `left ${speed / 1000}s ease-out`;
    // 4 -> 3 -> 2 -> 1 -> 0
    if (idx === 0) idx = slideList.length;
    slideList[idx - 1].style.left = '0%';
    slideList[idx - 1].style.transition = `left ${speed / 1000}s ease-out`;
    indiActive(idx - 1, idx);

    // setTimeout(함수, 시간): 시간후 1회
    // setInterval(함수, 시간): 시간후 반복
    setTimeout(function () {
        if (idx === slideList.length) idx = 0;
        slideList[idx].style.left = '100%';
        slideList[idx].style.transition = 'none';
        idx--;
        if (idx === -1) idx = slideList.length-1;
    }, 700);
}

function nextSlide() {
    // 0 -> 1 -> 2 -> 3 -> 4
    slideList[idx].style.left = '-100%';
    slideList[idx].style.transition = `left ${speed / 1000}s ease-out`;
    // 1 -> 2 -> 3 -> 4 -> slideList.length
    if (idx === slideList.length-1) idx = -1;
    slideList[idx + 1].style.left = '0%';
    slideList[idx + 1].style.transition = `left ${speed / 1000}s ease-out`;
    indiActive(idx + 1, idx);

    // setTimeout(함수, 시간): 시간후 1회
    // setInterval(함수, 시간): 시간후 반복
    setTimeout(function () {
        if (idx === -1) idx = slideList.length-1;
        slideList[idx].style.left = '100%';
        slideList[idx].style.transition = 'none';
        idx++;
        if (idx === slideList.length) idx = 0;
    }, 700);
}

for (let i = 0; i < indiBtn.length; i++) {
    indiBtn[i].onclick = () => {
        // 사용자가 버튼 클릭 시 자동 슬라이드 정지
        clearInterval(auto);

        // 만약 dDelay가 0이 아니면 click 이벤트 벗어남.
        if (eDelay) return;
        // 두 번째 클릭시 적용
        eDelay = 1;
        setTimeout(() => { eDelay = 0; autoSlide(); }, speed);

        // 인디케이터의 누른 버튼 순번과 0%의 이미지 순번이 같으면 클릭 함수를 벗어남.
        if (currentIdx === i) return;

        // i = 0,1,2,3,slideList.length-1
        currentIdx = i;

        // idx는 0
        // 0% 이미지(currentIdx)는 -100%로
        slideList[idx].style.left = '-100%';
        slideList[idx].style.transition = `left ${speed / 1000}s ease-out`;

        // i는 0,1,2,3,slideList.length-1
        // 인디 버튼 순번에 해당하는 이미지는 0%로
        slideList[currentIdx].style.left = '0%';
        slideList[currentIdx].style.transition = `left ${speed / 1000}s ease-out`;
        indiActive(currentIdx, idx);


        // 일정 시간 후 -100% 이미지는 100%로
        setTimeout(function () {
            slideList[idx].style.left = '100%';
            slideList[idx].style.transition = 'none';

            idx = currentIdx;
        }, speed);
    }; // indiBtn[i].onclick
} // for

function indiActive(currentIdx, idx) {
    // -1(x), 0,1,2,3,slideList.length-1, slideList.length(x)
    // next
    if (idx === slideList.length) idx = 0;
    // prev
    if (idx === -1) idx = slideList.length-1;
    indiBtn[idx].classList.remove('on');
    indiBtn[currentIdx].classList.add('on');
}

