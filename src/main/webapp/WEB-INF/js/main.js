$(document).ready(function(){
	$(".list_more").click(function(){
		$(".list_body span:gt(6)").toggle(400);
	});
	var d = new Date();
	$(".doctorlist_title ul li").each(function(index){
		var dateString = (1 + d.getMonth()) + "/" + (index + d.getDate()) 
		 + "<br>" + whatDay((index + d.getDate()-1)%7);
		$(this).find("div").html(dateString);
	});
	$(".mainpage_left_title_keshi ul li").each(function(index){
		var dateString = (1 + d.getMonth()) + "/" + (index + d.getDate()) 
		 + "<br>" + whatDay((index + d.getDate()-1)%7);
		$(this).find("div").html(dateString);
	});
	var timeString = d.getFullYear() + "年" + (1 + d.getMonth()) + "月" + d.getDate() + "日";
	$(".doctor_time h2").html(timeString);
	$(".doctor_time>span").html(whatTime((d.getDate()-1)%7));


	$(".doctor_time_list p").each(function(index){
		$(this).click(function(){
			$(".doctor_time_list p input").removeAttr("checked");
			$(".doctor_time_list p").css("background", "#EDEDED");
			$(this).find("input").attr("checked",true);
			$(this).find("input").attr("value",index);
			$(this).css("background", "#FFFFFF");
		});
	});

	function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    $('#captchaOperation').html([randomNumber(1, 100), '+', randomNumber(1, 200), '='].join(' '));
    
    var item = $("#captchaOperation").html().split(" ");
    var number2 =parseInt(item[0]) + parseInt(item[2]);
    $("#number").keyup(function(){
    	var number1 = $("#number").val();
    	if(number1 == number2){
    		console.log("ee");
    		$("#sure_information").html("验证码正确");
    	}else{
    		console.log("11e");
    		$("#sure_information").html("验证码错误");
    	}
    	
    });





});
function whatDay(a){
	var dayArray = ["周一","周二","周三","周四","周五","周六","周日"]
	return dayArray[a];
}
function whatTime(a){
	var dayArray = ["星期一","星期二","星期三","星期四","星期五","星期六","星期日"]
	return dayArray[a];
}
// function changeTag(n){
// 	$(".tag_content ul li").removeClass("active");
// 	$(".tag_content ul li:nth-child(n)").addClass("active");
// }