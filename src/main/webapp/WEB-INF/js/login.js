/**
 * Created by xiaohang on 2016/5/4.
 */
$(document).ready(function(){
   findcontent();
   detailshow();
});
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
function findcontent(){
    $(".user_menu").delegate('.user_f', 'click', function() {
       $(".order").filter(":visible").hide();
      if($(this).text()=="订单管理")
        { 
          $(".right_title").text($(this).text());
          $(".right_content .order_list").show();
      
        }
        else{
          if($(this).text()=="密码管理")
        { 
          $(".right_title").text($(this).text());
          $(".right_content .password").show();
        }
        else{
          $(".right_title").text($(this).text());
          $(".right_content .col_main").show();
        }

        }
    });
}
function detailshow(){
    $(".order_list").delegate('.right_item', 'click', function() {
         $(".order_detail").show();
    $(".right_content .order_list").hide();
  });
    $(".right_title a").bind('click',  function() {
    $(".order_detail").hide();
    $(".right_content .order_list").show();
  /* Act on the event */
});
}