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
});
function whatDay(a){
	var dayArray = ["周一","周二","周三","周四","周五","周六","周日"]
	return dayArray[a];
}
// function changeTag(n){
// 	$(".tag_content ul li").removeClass("active");
// 	$(".tag_content ul li:nth-child(n)").addClass("active");
// }