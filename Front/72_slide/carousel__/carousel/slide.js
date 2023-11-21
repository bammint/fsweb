const carouselSlide = document.querySelector(".carousel-slide");
const carouselImages = document.querySelectorAll(".carousel-slide img");

// Buttons
const prevBtn = document.querySelector("#prevBtn");
const nextBtn = document.querySelector("#nextBtn");

const indi = document.querySelectorAll(".indi li");
// Counter
let counter = 1;
// 인디케이터 index
let index = 1;

/*
Element.clientWidth 속성은 인라인 요소나 CSS 상에 존재하지 않는 요소에 대해서는 0을 나타내고, 그렇지 않다면 엘리먼트의 내부 너비를 픽셀로 나타냅니다. 내부 너비는 안쪽 여백(패딩)을 포함하지만, 테두리, 바깥 여백(마진) 그리고 수직 스크롤바의 너비는 포함하지 않습니다.
*/
// html에서 0번째 요소인 Clone요소를 가리기 위해 첫번쨰 이미지의 width값 만큼     carousel-slide의 translateX값을 이동시킨다.
const size = carouselImages[0].clientWidth;
carouselSlide.style.transform = `translateX(${-size * counter}px)`;

prevBtn.addEventListener("click", () => {
  if (counter <= 0) return;
  carouselSlide.style.transition = `transform 0.4s ease-in-out`;
  counter--;
  index = counter;
  //   console.log(counter);
  carouselSlide.style.transform = `translateX(${-size * counter}px)`;
  console.log(counter);
  indicator(counter);
});

nextBtn.addEventListener("click", () => {
  if (counter >= carouselImages.length - 1) return;
  carouselSlide.style.transition = `transform 0.4s ease-in-out`;
  counter++;
  index = counter;
  //   console.log(counter);
  carouselSlide.style.transform = `translateX(${-size * counter}px)`;
  console.log(counter);
  indicator(counter);
});

carouselSlide.addEventListener("transitionend", () => {
  if (carouselImages[counter].id === "lastClone") {
    carouselSlide.style.transition = "none";
    counter = carouselImages.length - 2;
    carouselSlide.style.transform = `translateX(${-size * counter}px)`;
  }
  if (carouselImages[counter].id === "firstClone") {
    carouselSlide.style.transition = "none";
    counter = carouselImages.length - counter;
    carouselSlide.style.transform = `translateX(${-size * counter}px)`;
  }
  console.log(counter);
  indicator(counter);
});

// 인디케이터
// console.log(indi);
for (let i = 0; i < indi.length; i++) {
  indi[i].addEventListener("click", () => {
    for (let j = 0; j < indi.length; j++) {
      indi[j].style.background = "#777";
    }
    counter = i + 1;
    index = counter;
    indi[i].style.background = "#fff";
    carouselSlide.style.transition = `transform 0.4s ease-in-out`;
    carouselSlide.style.transform = `translateX(${-size * counter}px)`;
  });
}

function indicator(index) {
  if (index === 0 || index === 5) return;
  for (let i = 0; i < indi.length; i++) {
    indi[i].style.background = "#777";
  }
  //   console.log("index -1 :" + (index - 1));

  indi[index - 1].style.background = "#fff";
}
