// header의 변경할 요소 지정
const header = document.querySelector("#header_inner");
// scrollEvent는 스크롤이 움직이는 걸 인식하고
// 스크롤이 top에서부터 70만큼 움직이면 요소에 클래스 추가
function scrollEvent(){
    document.addEventListener("scroll", function(){
        if(document.documentElement.scrollTop > 70){
            header.classList.add("scroll_down");
            header.classList.remove("header_inner");
            // 스크롤 top으로 부터 얼마나 내려오는지 식별
            // console.log(document.documentElement.scrollTop);
        }else{
            // 스크롤이 Top에서부터 70보다 작을 떄
            header.classList.remove("scroll_down");
            header.classList.add("header_inner");
        }
    });
}
// 스크롤이 움직일때 scrollEvent 실행
function init(){
    document.addEventListener("scroll", scrollEvent);
}
// function init 실행
init();