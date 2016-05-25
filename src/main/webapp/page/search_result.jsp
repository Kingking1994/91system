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
	<script type="text/javascript" src="../js/login.js"></script>
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
			<input type="text" value="${searchString}" name="searchString" class="search_text" placeholder="医院、科室、或医生名称">
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
			<li class="active">综合</li>
			<div class="clear"></div>
		</ul>
	</div>
</div>
<div class="search_box">

	<div class="search_title clearfix">
		<h2>相关医生</h2>
		<a href="<%=path%>/search/doctors">更多>></a>
	</div>

	<div class="search_main clearfix">

		<c:if test="${fn:length(doctorPager.dataList) eq 0}">
			没有相关结果
		</c:if>
		<c:if test="${fn:length(doctorPager.dataList) gt 0}">
			<c:forEach items="${doctorPager.dataList}" var="doctor">
		<div class="d_item">
		    <div class="clearfix">
			<div  class="i-pic fl">
				<div>
					<img src="${doctor.path}">
				</div>
			</div>
			<div class="d_name fr">
				<h2><a href="<%=path%>/doctors/info?did=${doctor.did}">${doctor.name}</a></h2>
				<c:if test="${doctor.title eq 0}">主任医师</c:if>
				<c:if test="${doctor.title eq 1}">副主任医师</c:if>
				<c:if test="${doctor.title eq 2}">主治医师</c:if>
			</div>
			</div>
			<div class="i-hpt">
                <div class="i-adep">${doctor.goodat}</div>
			</div>
		</div>
			</c:forEach>
		</c:if>

	</div>
</div>
<!--search_box结束-->
<div class="search_box">

	<div class="search_title clearfix">
		<h2>相关科室</h2>
		<a href="<%=path%>/search/offices">更多>></a>
	</div>

	<div class="search_main">
       <ul class="bor clearfix">

		   <c:if test="${fn:length(officePager.dataList) eq 0}">
			   没有相关结果
		   </c:if>
		   <c:if test="${fn:length(officePager.dataList) gt 0}">
		   <c:forEach items="${officePager.dataList}" var="office">
       	   <li>
       	   	 <a href="#" class="searchpic fl">
       	   	 	<img src="http://images.91160.com/cache/20151125/145x97/upload/unit/4/unit_3132_14589873131821.jpg">
       	   	 </a>
       	   	 <div class="fl searchcon">
				 <a href="<%=path%>/offices/info?oid=${office.oid}"><h3>${office.name}</h3></a>
				 <c:if test="${office.level eq 0}"><span>普通科室</span></c:if>
				 <c:if test="${office.level eq 1}"><span>国级科室</span></c:if>
				 <c:if test="${office.level eq 2}"><span>省级科室</span></c:if>
				 <c:if test="${office.level eq 3}"><span>市级科室</span></c:if>
				 <c:if test="${office.level eq 4}"><span>区级科室</span></c:if>
       	   	 </div>
       	   	 <div class="yuyuenum fr">
       	   	 	累计
       	   	 	<em>2</em>
       	   	 	人预约
       	   	 	<br>
       	   	 	累计
       	   	 	<em>0</em>
       	   	 	人点评
       	   	 </div>
       	   </li>
		   </c:forEach>
		   </c:if>
       </ul>
	</div>
</div>
<!--search_box结束-->
<div class="search_box">

    <div class="search_title clearfix">
		<h2>相关医院</h2>
		<a href="<%=path%>/search/hospitals">更多>></a>
	</div>

	<div class="search_main">
       <ul class="bor clearfix">
		   <c:if test="${fn:length(hospitalPager.dataList) eq 0}">
			   没有相关结果
		   </c:if>
		   <c:if test="${fn:length(hospitalPager.dataList) gt 0}">
			   <c:forEach items="${hospitalPager.dataList}" var="hospital">
       	   <li>
       	   	 <a href="#" class="searchpic fl">
       	   	 	<img src="http://images.91160.com/cache/20151125/145x97/upload/unit/4/unit_3132_14589873131821.jpg">
       	   	 </a>
       	   	 <div class="fl searchcon">
       	   	 	 <h4><a href="<%=path%>/hospitals/info?hid=${hospital.hid}">${hospital.name}</a></h4>
       	   	 	 <p>
       	   	 	 	<i class=" fl searchicon siconA1"></i>
       	   	 	 	${hospital.telephone}
       	   	 	 </p>
       	   	 	 <p>
       	   	 	 	<i class=" fl searchicon siconA2"></i>
       	   	 	 	${hospital.address}
       	   	 	 </p>
       	   	 </div>
       	   	 <div class="yuyuenum fr">
       	   	 	累计
       	   	 	<em>2</em>
       	   	 	人预约
       	   	 	<br>
       	   	 	累计
       	   	 	<em>0</em>
       	   	 	人点评
       	   	 </div>
       	   </li>
			   </c:forEach>
		   </c:if>


       </ul>
	</div>
</div>
<!--search_box结束-->
<div class="footer">
	<img src="../images/footer.png">
</div>
</body>
</html>