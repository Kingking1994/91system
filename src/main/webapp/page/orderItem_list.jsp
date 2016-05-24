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
	<script src="http://www.imooc.com/data/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
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
					<div style="display: inline-block">${userPhone}</div>
					<div class="usering" >
						<a href="http://www.baidu.com"><span class="glyphicon glyphicon-cog" aria-hidden="true">&nbsp;用户中心</span></a>
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
		<form action="" class="search_form">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
		    <input type="text" value="" class="search_text" placeholder="医院、医生、或疾病名称"/>
		    <input type="submit" value="搜索" class="search_button"/>
		</form>
	</div>
    <div class="clear"></div>
</div>

<!--标签页-->
<div class="tag">
	<div class="tag_content">
		<ul>
			<li>找医院</li>
			<li>找科室</li>
			<li>找医生</li>
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
				<img src="http://static.91160.com/usercenter/style/global/avatar_0.png">
			</div>
			<div class="user_info_name fl">
				用户名
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
       <div class="order order_list" id="order_list" >
    	  <div class="right_menu">

			  <c:if test="${fn:length(userInfo.orderItemSet) eq 0}">
				  <div class="right_menu_title">
					  <span>没有相关记录</span>
				  </div>
			  </c:if>
			  <c:if test="${fn:length(userInfo.orderItemSet) gt 0}">

    		<div class="right_menu_title">
    			<ul class="clearfix">
    				<li>订单号</li>
    				<li>就诊人</li>
    				<li>状态</li>
    				<li>操作</li>
    			</ul>
    		</div>

				  <c:forEach items="${userInfo.orderItemSet}" var="orderItem">
    		<div class="right_item">
    			<div class="item_detail">
    				<ul class="clearfix">
    					<li>${orderItem.oiid}</li>
    					<li>${orderItem.patient.pname}</li>
						<c:if test="${orderItem.status eq 0}">
    					<li>成功预约</li>
						</c:if>
						<c:if test="${orderItem.status eq 1}">
						<li>已取消</li>
						</c:if>
						<li>
							<span>
								<a href="<%=path%>/orders/detail?oiid=${orderItem.oiid}">查看</a>
							</span>
							<span>
								<a href="<%=path%>/orders/cancel?oiid=${orderItem.oiid}">取消</a>
							</span>
						</li>
    				</ul>
    			</div>
    		</div>
				  </c:forEach>
			  </c:if>



    	  </div>
    	</div>
    	<!--order_list结束-->

      </div>
    </div> 
</div>
</body>
</html>