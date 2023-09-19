const tabBtn = document.querySelectorAll('#tabs li');
const tabCont = document.querySelectorAll('#tabs div');

// 탭 버튼을 클릭하면
for(let i=0; i<tabBtn.length; i++) {
    tabBtn[i].onclick = ()=>{
        console.log('몇 번을 눌렀니?', i);
        // tabs div의 on클래스를 모두 제거
        for(let j=0; j<tabBtn.length; j++) {
            tabCont[j].classList.remove('on');
        }
        // tabs div의 on클래스를 버튼 누를 것만 추가
        tabCont[i].classList.add('on');
    };
}
// #tabs div에 on 클래스가 있으면 보이고(display:flex;), 없으면 숨겨짐(display:none;)
// 요소.classList.add('클래스')
// 요소.classList.remove('클래스')
