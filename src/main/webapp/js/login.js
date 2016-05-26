/**
 * Created by xiaohang on 2016/5/4.
 */
$(document).ready(function(){
   //findcontent();
   //detailshow();
   //settingchange();
   dialogshow();
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

function change2(obj){
    if($(obj).attr('class')=='banner_title2')
    { $("#sAdminLogin").hide();
        $(".banner_title").removeClass("blue");
        $("#hAdminLogin").show();
        $(".banner_title2").addClass("blue");
        $(".tit_span").text("医院管理员登录");
    }
    if($(obj).attr('class')=='banner_title')
    { $("#hAdminLogin").hide();
        $(".banner_title2").removeClass("blue");
        $("#sAdminLogin").show();
        $(".banner_title").addClass("blue");
        $(".tit_span").text("系统管理员登录");
    }
}
//function settingchange(){
//   $(".account_list").delegate('li', 'click', function() {
//
//      $(this).addClass('current');
//      $(this).siblings().removeClass('current');
//      if($(this).text()=="账号信息"||$(this).text()=="交易记录")
//      {
//         $(".lan_left").show();
//          $(".lan_right").hide();
//      }
//      else
//      {
//         $(".lan_right").show();
//          $(".lan_left").hide();
//      }
//   });
//}
//function findcontent(){
//    $(".user_menu").delegate('.user_f', 'click', function() {
//      // $(this) .addClass('bg_on');
//        $(".order").filter(":visible").hide();
//      if($(this).text()=="订单管理")
//        {
//          $(".right_title").text($(this).text());
//          $(".right_content .order_list").show();
//
//        }
//        else{
//          if($(this).text()=="账号设置")
//        {
//          $(".right_title").text($(this).text());
//          $(".right_content .account").show();
//        }
//        else{
//          $(".right_title").text($(this).text());
//          $(".right_content .col_main").show();
//        }
//
//        }
//    });
//}
//function detailshow(){
//    $(".order_list").delegate('.right_item', 'click', function() {
//    $(".order_detail").show();
//    $(".right_content .order_list").hide();
//  });
//    $(".order_detail .title a").bind('click',  function() {
//    $(".order_detail").hide();
//    $(".right_content .order_list").show();
//  /* Act on the event */
//});
//}
function dialogshow(){
  $(".recharge_btn").bind('click',  function() {
     $(".recharge_dialog").show();
      $(".shadow").show();
  });
   $(".dialog_title a").bind('click',  function() {
     $(".recharge_dialog").hide();
      $(".shadow").hide();
  });
   $(".dialog_main ul ").delegate('li','click',function(){
      $(this).addClass('cur');
      $(this).siblings().removeClass('cur');
      var nu=$(this).text();
      var index=nu.indexOf('元');
      nu=nu.substring(0,index);
     $(".dialog_main input").attr({
       'value':nu ,
     });
   });
}