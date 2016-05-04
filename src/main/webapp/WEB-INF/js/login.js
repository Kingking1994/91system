/**
 * Created by xiaohang on 2016/5/4.
 */
function change(obj){
    if($(obj).attr('class')=='banner_title2')
    { $("#register").hide();
        $(".banner_title").removeClass("blue");
        $("#login").show();
        $(".banner_title2").addClass("blue");
        $(".tit_span").text("用户登录");
    }
    if($(obj).attr('class')=='banner_title')
    { $("#login").hide();
        $(".banner_title2").removeClass("blue");
        $("#register").show();
        $(".banner_title").addClass("blue");
        $(".tit_span").text("用户注册");
    }
}