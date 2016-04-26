$(document).ready(function(){
	$(".list_more").click(function(){
		$(".list_body span:gt(6)").toggle(400);
	});
});