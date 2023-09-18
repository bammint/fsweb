// 섹션3: 텍스트 스크롤 모션

const tit1 = document.querySelector('#sec3 .tit1');
const tit2 = document.querySelector('#sec3 .tit2');
const proBtn = document.querySelector('#sec3 .proBtn');

window.onscroll = () => {
    console.log(document.documentElement.scrollTop);
    let st = document.documentElement.scrollTop;
    if (st > 1700) {
        tit1.style.transform = 'translateX(0)';
        tit2.style.transform = 'translateX(0)';
        proBtn.style.transform = 'translateX(0)';
        tit1.style.opacity = '1';
        tit2.style.opacity = '1';
        proBtn.style.opacity = '1';
    } else {
        tit1.style.transform = 'translateX(-400px)';
        tit2.style.transform = 'translateX(-400px)';
        proBtn.style.transform = 'translateX(-400px)';
        tit1.style.opacity = '0';
        tit2.style.opacity = '0';
        proBtn.style.opacity = '0';
    }
};