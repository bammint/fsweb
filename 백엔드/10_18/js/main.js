$(function(){
    var top1 = $("#item1").offset().top;    //40
    var left1 = $("#item1").offset().left;    //20
    var left2 = $("#item2").offset().left;    //100
    var left3 = $("#item3").offset().left;    //180
    var left4 = $("#item4").offset().left;    //260
    var left5 = $("#item5").offset().left;    //340
    console.log(top1,left1,left2,left3,left4,left5)

    $(window).scroll(function(){
        var sct = $(this).scrollTop();
        $('#value').text(sct);
        $('#item1').css({'top':top1 + sct/4});
        $('#item2').css({'top':top1 + sct/5, 'left':left2+sct/8});
        $('#item3').css({'top':top1 + sct/6, 'left':left3+sct/6});
        $('#item4').css({'top':top1 + sct/8, 'left':left4+sct/5});
        $('#item5').css({'left':left5+sct/4});
    });
});