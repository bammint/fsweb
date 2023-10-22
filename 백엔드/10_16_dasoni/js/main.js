$(function () {
    // sec1 slide
    setTimeout(function () {
        $('.slider li .text0').addClass('on');
        $('.slider li .atext0').addClass('on');
    }, 1000);//1초후 최초 한번만 실행


    var bx = $('.slider').bxSlider({
        auto: true,
        controls: false,
        pager: false,
        mode: 'fade',
        pause: 5000, //실제 슬라이드 속도 - setInterval과 비슷
        autoHover: true,
        onSlideBefore: function () { },
        onSlideAfter: function () {
            var k = bx.getCurrentSlide();
            $('.slider li').find('h2').removeClass('on');
            $('.slider li').find('p').removeClass('on');
            $('.slider li .text' + k).addClass('on');
            $('.slider li .atext' + k).addClass('on');
        }
    });
    // //sec1 slide

    // sec2
    const s2_img = document.querySelector(".s2_tit img");
    const s2_h2 = document.querySelector(".s2_tit h2");
    const s2_p = document.querySelector(".s2_tit p");
    const s2_li = document.querySelectorAll(".s2_table li");

    // sec3
    const s3_img = document.querySelector(".s3_tit img");
    const s3_h2 = document.querySelector(".s3_tit h2");
    const s3_p = document.querySelector(".s3_tit p");
    const s3_li = document.querySelectorAll(".s3_table li");

    // sec4
    const s4_img = document.querySelector(".s4_tit img");
    const s4_h2 = document.querySelector(".s4_tit h2");
    const s4_p = document.querySelector(".s4_tit p");
    const s4_li = document.querySelectorAll(".s4_table li");

    // sec5
    const s5_tit = document.querySelector(".s5_tit");

    // sec6
    const s6_wrap = document.querySelector(".s6_wrap");
    const s6_tit1 = document.querySelector(".s6_tit1");
    const s6_tit2 = document.querySelector(".s6_tit2");
    const s6_img1 = document.querySelector(".s6_tit1 img");
    const s6_img2 = document.querySelector(".s6_tit2 img");


    // float_menu
    const float = document.querySelector("#float_menu ul");

    $(window).scroll(function () {
        var sct = $(window).scrollTop();
        console.log(sct);

        // sec2
        if (sct >= 300) {
            s2_img.style.transform = "translate(0)";
            s2_img.style.opacity = "1";
            s2_img.style.transition = ".7s";
        }
        if (sct >= 420) {
            s2_h2.style.transform = "translate(0)";
            s2_h2.style.opacity = "1";
            s2_h2.style.transition = ".7s";
        }
        if (sct >= 520) {
            s2_p.style.transform = "translate(0)";
            s2_p.style.opacity = "1";
            s2_p.style.transition = ".7s";
        }
        if (sct >= 600) {
            s2_li[0].style.transform = "translate(0)";
            s2_li[0].style.opacity = "1";
            s2_li[0].style.transition = "1s";
            s2_li[1].style.transform = "translate(0)";
            s2_li[1].style.opacity = "1";
            s2_li[1].style.transition = "1s .3s";
            s2_li[2].style.transform = "translate(0)";
            s2_li[2].style.opacity = "1";
            s2_li[2].style.transition = "1s .6s";
            s2_li[3].style.transform = "translate(0)";
            s2_li[3].style.opacity = "1";
            s2_li[3].style.transition = "1s .9s";
        }

        //sec3
        if (sct >= 970) {
            s3_img.style.transform = "translate(0)";
            s3_img.style.opacity = "1";
            s3_img.style.transition = ".7s";
        }
        if (sct >= 1020) {
            s3_h2.style.transform = "translate(0)";
            s3_h2.style.opacity = "1";
            s3_h2.style.transition = ".7s";
        }
        if (sct >= 1120) {
            s3_p.style.transform = "translate(0)";
            s3_p.style.opacity = "1";
            s3_p.style.transition = ".7s";
        }
        if (sct >= 1220) {
            s3_li[0].style.transform = "translate(0)";
            s3_li[0].style.opacity = "1";
            s3_li[0].style.transition = "1s";
            s3_li[1].style.transform = "translate(0)";
            s3_li[1].style.opacity = "1";
            s3_li[1].style.transition = "1s .3s";
            s3_li[2].style.transform = "translate(0)";
            s3_li[2].style.opacity = "1";
            s3_li[2].style.transition = "1s .6s";
            s3_li[3].style.transform = "translate(0)";
            s3_li[3].style.opacity = "1";
            s3_li[3].style.transition = "1s .9s";
            s3_li[4].style.transform = "translate(0)";
            s3_li[4].style.opacity = "1";
            s3_li[4].style.transition = "1s 1.2s";
        }

        // sec4
        if (sct >= 1610) {
            s4_img.style.transform = "translate(0)";
            s4_img.style.opacity = "1";
            s4_img.style.transition = ".7s";
        }
        if (sct >= 1730) {
            s4_h2.style.transform = "translate(0)";
            s4_h2.style.opacity = "1";
            s4_h2.style.transition = ".7s";
        }
        if (sct >= 1830) {
            s4_p.style.transform = "translate(0)";
            s4_p.style.opacity = "1";
            s4_p.style.transition = ".7s";
        }
        if (sct >= 1910) {
            s4_li[0].style.transform = "translate(0)";
            s4_li[0].style.opacity = "1";
            s4_li[0].style.transition = "1s";
            s4_li[1].style.transform = "translate(0)";
            s4_li[1].style.opacity = "1";
            s4_li[1].style.transition = "1s .3s";
            s4_li[2].style.transform = "translate(0)";
            s4_li[2].style.opacity = "1";
            s4_li[2].style.transition = "1s .6s";
            s4_li[3].style.transform = "translate(0)";
            s4_li[3].style.opacity = "1";
            s4_li[3].style.transition = "1s .9s";
        }

        // sec5
        if (sct >= 2225) {
            s5_tit.style.transform = "translateX(0)";
            s5_tit.style.opacity = "1";
            s5_tit.style.transition = "1s";
        }

        // sec6
        if (sct >= 2730) {
            s6_wrap.style.transform = "translate(-50%,-50%)";
            s6_wrap.style.opacity = "1";
            s6_wrap.style.transition = "1s";
        }
        s6_tit1.addEventListener('mouseenter', () => {
            s6_img1.style.transform = "rotate(180deg)";
            s6_img1.style.transition = ".5s";

        });
        s6_tit1.addEventListener('mouseleave', () => {
            s6_img1.style.transform = "rotate(0)";
            s6_img1.style.transition = ".5s";

        });
        s6_tit2.addEventListener('mouseenter', () => {
            s6_img2.style.transform = "rotate(180deg)";
            s6_img2.style.transition = ".5s";

        });
        s6_tit2.addEventListener('mouseleave', () => {
            s6_img2.style.transform = "rotate(0)";
            s6_img2.style.transition = ".5s";

        });

        // float_menu
        float.style.top = `${sct + 400}px`;

    });
    // popup
    var chk = $('#expiresChk');

    $('.closeBtn').on('click', closePop);
    
    if ($.cookie('popup') == 'none') {
        $('#popup').hide();
    }
    function closePop() {
        if (chk.is(":checked")) {
            $.cookie('popup', 'none', { expires: 1 });
            // chk 변수가 checked를 가지고 있으면 
            // popup에 none을 3일 동안 저장한 값을 가지고 있어라
        }
        $('#popup').fadeOut('fast');
    }
});