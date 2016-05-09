$(document).ready(function(){
	$(".list_more").click(function(){
		$(".list_body span:gt(6)").toggle(400);
	});
});
// function changeTag(n){
// 	$(".tag_content ul li").removeClass("active");
// 	$(".tag_content ul li:nth-child(n)").addClass("active");
// }