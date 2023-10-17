$(function () {
    var he;
    $(window).resize(function () {
        he = $(window).height();
        // 현재 브라우저 높이를 he에 저장
        $('section>div').height(he);
        // 저장한 높이 he를 section > div에 각각 넣는다
    });
    $(window).trigger('resize');
    // 브라우저 시작시 강제로 resize를 실행

    var dTop = $('#floatdiv').offset().top; //250

    $(window).scroll(function () {
        var sct = $(window).scrollTop();
        $('#sTop').text(sct);
        pdt = sct * 0.0005;
        if (pdt <= 1) {
            $("#pdt_basic").css('opacity', pdt);
        }
        if (sct >= 100) {
            $('nav').addClass('fixed');
        } else {
            $('nav').removeClass('fixed');
        }
        if (sct >= 2700) {
            $('.s4_cover>div').addClass('active');
        }
        $("#floatdiv").stop().animate({ top: dTop + sct }, 500);
        if (sct >= $('section>div').eq(0).offset().top) {
            $('nav ul li').removeClass('on');
            $('nav ul li').eq(0).addClass('on');
            $('#floatdiv ul li').removeClass('on');
            $('#floatdiv ul li').eq(0).addClass('on');
            $('#leftdiv ul li').removeClass('on');
            $('#leftdiv .leftdiv_title').addClass('on');
        }
        if (sct >= $('section>div').eq(1).offset().top) {
            $('nav ul li').removeClass('on');
            $('nav ul li').eq(1).addClass('on');
            $('#floatdiv ul li').removeClass('on');
            $('#floatdiv ul li').eq(1).addClass('on');
            $('#leftdiv .leftdiv_title').removeClass('on');

            $('#leftdiv ul li').removeClass('on');
            $('#leftdiv ul li').eq(0).addClass('on');
        }
        if (sct >= $('section>div').eq(2).offset().top) {
            $('nav ul li').removeClass('on');
            $('nav ul li').eq(2).addClass('on');
            $('#floatdiv ul li').removeClass('on');
            $('#floatdiv ul li').eq(2).addClass('on');
            $('#leftdiv ul li').removeClass('on');
            $('#leftdiv ul li').eq(1).addClass('on');
        }

        if (sct >= $('section>div').eq(3).offset().top) {
            $('nav ul li').removeClass('on');
            $('nav ul li').eq(3).addClass('on');
            $('#floatdiv ul li').removeClass('on');
            $('#floatdiv ul li').eq(3).addClass('on');
            $('#leftdiv ul li').removeClass('on');
            $('#leftdiv ul li').eq(2).addClass('on');
        }
        if (sct >= $('section>div').eq(4).offset().top) {
            $('nav ul li').removeClass('on');
            $('nav ul li').eq(4).addClass('on');
            $('#floatdiv ul li').removeClass('on');
            $('#floatdiv ul li').eq(4).addClass('on');
            $('#leftdiv ul li').removeClass('on');
            $('#leftdiv ul li').eq(3).addClass('on');
        }
        if (sct >= $('section>div').eq(5).offset().top) {
            $('nav ul li').removeClass('on');
            $('nav ul li').eq(5).addClass('on');
            $('#floatdiv ul li').removeClass('on');
            $('#floatdiv ul li').eq(5).addClass('on');
            $('#leftdiv ul li').removeClass('on');
            $('#leftdiv ul li').eq(4).addClass('on');
        }
    });
    $('nav ul li').click(function () {
        var index_nav = $(this.index()); // 클릭한 nav ul li 인덱스 번호
        var offset_nav = $('section div').eq(index_nav).offset().top;

        $('html,body').stop().animate({ scrollTop: offset_nav }, 1000);
    });

    $('#floatdiv ul li').click(function () {
        var index_f = $(this.index()); // 클릭한 f ul li 인덱스 번호
        var offset_f = $('section div').eq(index_f).offset().top;

        $('html,body').stop().animate({ scrollTop: offset_f }, 1000);
    });

    $('#leftdiv ul li').click(function () {
        var index_leftdiv = $(this).index();
        var offset_leftdiv = $('section div').eq(index_leftdiv + 1).offset().top;
        console.log(offset_leftdiv);
        $('#floatdiv ul li').removeClass('on');
        $(this).addClass('on');

        $('nav ul li').removeClass('on');
        $('nav ul li').eq(index_leftdiv).addClass('on');

        $('#leftdiv ul li').removeClass('on');
        $('#leftdiv ul li').eq(index_leftdiv).addClass('on');

        $('html,body').stop().animate({ scrollTop: offset_leftdiv }, 1000);
    });

    $('.leftdiv_title').click(function () {
        var offset_leftdiv = $('section div').eq(0).offset().top;
        $('html,body').stop().animate({ scrollTop: offset_leftdiv }, 1000);
    });

    $('#leftdiv ul li').hover(function () {
        $(this).addClass('on');
    }, function () {
        $('#leftdiv ul li').removeClass('on');
        $(window).trigger('scroll');
    });

    $('.leftdiv_title').hover(function () {
        $(this).addClass('on');
    }, function () {
        $(this).removeClass('on');
    });

    $('#popup').draggable();

    // 'pop이라는 쿠키가 존재하고 그 값이 no와 다르면'
    if ($.cookie('pop') != 'no') {
        $('#popup').show();
    }

    $('#popup area:eq(0)').click(function () {
        $('#popup').fadeOut('fast');
    });

    $('#popup area:eq(1)').click(function () {
        $.cookie('pop', 'no', { expires: 1 });
        $('#popup').fadeOut('fast');
    });

    if ($.cookie('popup') == 'none') {
        $('#notice_wrap').hide();
    }

    var chk = $('#expiresChk');

    $('.closeBtn').on('click', closePop);

    function closePop() {
        if (chk.is(":checked")) {
            $.cookie('popup', 'none', { expires: 3 });
            // chk 변수가 checked를 가지고 있으면 
            // popup에 none을 3일 동안 저장한 값을 가지고 있어라
        }
        $('#notice_wrap').fadeOut('fast');
    }
});