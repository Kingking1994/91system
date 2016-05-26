<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>在线预约挂号系统</title>
	<link rel="stylesheet" type="text/css" href="../css/main.css">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../css/settings.css">
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/main.js"></script>
</head>
<body>
<!--头部-->
<div class="top">
	<div class="top_content">
		<div class="top_left">
		  	<ul>
		  		<li>在线预约挂号系统</li>
		  		<li class="line"></li>
		  		<li>挂号</li>
		  		<li class="line"></li>
		  		<li>咨询</li>
		  		<li class="line"></li>
		  		<li>社区</li>
		  		<div class="clear"></div>
		  	</ul>
		</div>
		<div class="top_right">
		  	<ul>
		  		<li class="erweima">
		  			<div style="display: inline-block">关注微信</div>
		  			<span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
		  			<div class="ewm" >
		  				<img src="../images/erweima.gif">
		  			</div>
		  		</li>
		  		<li>咨询</li>
				<li class="user">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					<c:if test="${identify eq 0}">
						<div style="display: inline-block">${userPhone}</div>
					</c:if>
					<c:if test="${identify eq 1}">
						<div style="display: inline-block">${userName}</div>
					</c:if>
					<div class="usering" >
						<a href="<%=path%>/orders/list"><span class="glyphicon glyphicon-cog" aria-hidden="true">&nbsp;用户中心</span></a>
						<a href="http://www.baidu.com"><span class="glyphicon glyphicon-list-alt" aria-hidden="true">&nbsp;私人医生</span></a>
						<a href="http://www.baidu.com"><span class="glyphicon glyphicon-bell" aria-hidden="true">&nbsp;消息</span></a>
						<a href="<%=path%>/users/logout"><span class="glyphicon glyphicon-off" aria-hidden="true">&nbsp;退出</span></a>
					</div>
				</li>
		  		<div class="clear"></div>
		  	</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>

<!--logo 和搜索框 -->
<div class="header">
	<div class="logo_block">
		<div class="logo">
		</div>
	</div>
	<div class="search">
		<form action="<%=path%>/search/all" method="post" class="search_form">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			<input type="text" value="" name="searchString" class="search_text" placeholder="医院、科室、或医生名称">
			<input type="submit" value="搜索" class="search_button">
		</form>
	</div>
    <div class="clear"></div>
</div>

<!--标签页-->
<div class="tag">
	<div class="tag_content">
		<ul>
			<li ><a href="<%=path%>/hospitals/list">找医院</a></li>
			<li ><a href="<%=path%>/offices/list">找科室</a></li>
			<li ><a href="<%=path%>/doctors/list">找医生</a></li>
			<div class="clear"></div>
		</ul>
	</div>
</div>
<!--主体部分-->
<div class="main_content">
<!--左侧边栏-->
	<div class="left_side">
	    <!--用户信息-->
		<div class="user_info">
			<div class="user_info_img fl">
				<img src="../images/user.jpg">
			</div>
			<div class="user_info_name fl">
				<c:if test="${identify eq 1}">
					${userName}
				</c:if>
			</div>
		</div>
		<div class="user_menu tabs">
		<ul>
				<li class="user_f">
					<a href="<%=path%>/orders/list">订单管理</a>
				</li>
				<li class="user_f">
					<a href="<%=path%>/users/info">账号设置</a>
				</li>
				<li class="user_f">
					<a href="<%=path%>/wallets/trade">钱包管理</a>
				</li>
		</ul>
		</div>
	</div>
    <div class="right_main">
        <div class="right_title title">
    		<span>订单管理</span>
    	</div>
      <div class="right_content">


    	<div class="order_detail order">
    		<div class="title">
    			<span>订单详情</span>
    			<a href="<%=path%>/orders/list"> <返回我的订单</a>
				<br>
				<br>
				<div>
					<c:if test="${orderItem.status eq 0}">
					<span>当前订单状态：成功预约</span>
					<br>
					<br>
					<span>您的订单已经成功预约</span>
					</c:if>
					<c:if test="${orderItem.status eq 1}">
						<span>当前订单状态：已取消</span>
						<br>
						<br>
						<span>您的订单已经取消</span>
					</c:if>
				</div>
    		</div>
    		<div class="detail_inf title">
    			<span>订单信息</span>
    			<p>订单号：${orderItem.oiid}</p>
    		</div>
    		<div class="detail_main">
    			<ul>
    				<li>预约医院：<a href="<%=path%>/hospitals/info?hid=${hospital.hid}">${hospital.name}</a></li>
    				<li>就诊时间：
    				<span class="money">${schedule.date}&nbsp;${orderItem.timing}</span></li>
    				<li>预约科室：<a href="<%=path%>/offices/info?oid=${office.oid}">${office.name}</a></li>
    				<li>就诊人：${orderItem.patient.pname}</li>
    				<li>预约医生：<a href="<%=path%>/doctors/info?did=${doctor.did}">${doctor.name}</a></li>
    				<li>下单时间：${orderItem.created}</li>
    				<li>挂号费：
    				<span class="money">${schedule.fee}</span></li>
    				<li>支付状态：已支付</li>
    			</ul>
    		</div>
    	</div>


      </div>
    </div> 
</div>
</body>
</html>