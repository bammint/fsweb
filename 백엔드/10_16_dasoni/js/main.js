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

    // #float_menu
    // var dTop = $('#float_menu').offset().top; //250

    // $(window).scroll(function () {
    //     var sct = $(window).scrollTop();
    // });
    // $('#float_menu').stop().animate({ top: dTop + sct }, 500);

    // $('#float_menu ul li').click(function () {
    //     var index_f = $(this.index()); // 클릭한 f ul li 인덱스 번호
    //     var offset_f = $('section div').eq(index_f).offset().top;

    //     $('html,body').stop().animate({ scrollTop: offset_f }, 1000);
    // });

    const float = document.querySelector("#float_menu ul");

    $(window).scroll(function () {
        var sct = $(window).scrollTop();
        // console.log(sct);
        float.style.top = `${sct+400}px`;
    });

    
});