$(function(){
  var gap = 103;

  var top1 = $('.area1').offset().top;
  //$('.area1') 브라우저 위부터 떨어진거리
  var top2 = $('.area2').offset().top;
  var top3 = $('.area3').offset().top;
  var top4= $('.area4').offset().top;
  var top5 = $('.area5').offset().top;
  console.log(top1, top2, top3, top4, top5);
  //103 803 1503 2203 2903

  // document.addEventListener("DOMContentLoaded", function () {
  //   var gap = 103;
  
  //   var area1 = document.querySelector('.area1');
  //   var area2 = document.querySelector('.area2');
  //   var area3 = document.querySelector('.area3');
  //   var area4 = document.querySelector('.area4');
  //   var area5 = document.querySelector('.area5');
  
  //   var top1 = area1.getBoundingClientRect().top + window.scrollY;
  //   var top2 = area2.getBoundingClientRect().top + window.scrollY;
  //   var top3 = area3.getBoundingClientRect().top + window.scrollY;
  //   var top4 = area4.getBoundingClientRect().top + window.scrollY;
  //   var top5 = area5.getBoundingClientRect().top + window.scrollY;
  
  //   console.log(top1, top2, top3, top4, top5);
  
  //   window.addEventListener("scroll", function () {
  //     var h = window.scrollY;
  //     if (h < top2 - gap) {
  //       area1.classList.add("on");
  //     } else if (h < top3 - gap) {
  //       area2.classList.add("on");
  //     } else if (h < top4 - gap) {
  //       area3.classList.add("on");
  //     } else if (h < top5 - gap) {
  //       area4.classList.add("on");
  //     } else {
  //       area5.classList.add("on");
  //     }
  //   });
  
    window.dispatchEvent(new Event("scroll"));
  });

  $(window).scroll(function(){
    var h=$(window).scrollTop(); // 스크롤 위치
    if(h < top2-gap){
      $(".area1").addClass("on");
    }else if(h < top3-gap){
      $(".area2").addClass("on");
    }else if(h < top4-gap){
			$(".area3").addClass("on");
		}else if(h < top5-gap){
			$(".area4").addClass("on");
		}else{
			$(".area5").addClass("on");
		}
  });
  $(window).trigger("scroll");

