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
		  			<span class="icon-umbrella icon-umbrella" aria-hidden="true"></span>
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
			<input type="text" value="" name="searchString" class="search_text" placeholder="医院、医生、或疾病名称">
			<input type="submit" value="搜索" class="search_button">
		</form>
	</div>
    <div class="clear"></div>
</div>

<!--标签页-->
<div class="tag">
	<div class="tag_content">
		<ul>
			<li class="active"><a href="<%=path%>/hospitals/list">找医院</a></li>
			<li ><a href="<%=path%>/offices/list">找科室</a></li>
			<li ><a href="<%=path%>/doctors/list">找医生</a></li>
			<div class="clear"></div>
		</ul>
	</div>
</div>

<!--医院详细科室列表-->
<div class="mainlist">
	<div class="hospitaltitle">
		<h1>${result.name}</h1>
	</div>
	<div class="hospital_information">
		<div class="information_image">
			<img src="../images/information_img.jpg">
		</div>
		<div class="information_list">
			<p>地址：${result.address}</p>
			<p>电话：${result.telephone}</p>
			<p class="about">${result.intro}</p>
		</div>
	</div>
	<h2>门诊科室</h2>
	<hr>
	<div class="something">
		<div class="something_phone">电话：${result.telephone}</div>
		<div class="something_address">地址：${result.address}</div>
		<div class="something_sum">已预约<span>12333</span>人</div>
	</div>
	<img src="../images/yaoqiu.png">
	<div class="department_list">
		<ul>
				<li>
					<div class="department_list_item">科室:</div>
					<div class="department_list_body">
						<c:forEach items="${result.officeSet}" var="office">
						<span><a href="<%=path%>/offices/info?oid=${office.oid}">${office.name}</a></span>
						</c:forEach>
					</div>
				</li>

		</ul>
	</div>
</div>

<!--尾部-->
<div class="footer">
	<img src="../images/footer.png">
</div>
</body>
</html>