<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<form action="" class="search_form">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
		    <input type="text" value="" class="search_text" placeholder="医院、医生、或疾病名称"></input>
		    <input type="submit" value="搜索" class="search_button"></input
		</form>
	</div>
    <div class="clear"></div>
</div>

<!--标签页-->
<div class="tag">
	<div class="tag_content">
		<ul>
			<li ><a href="<%=path%>/hospitals/list">找医院</a></li>
			<li class="active"><a href="<%=path%>/offices/list">找科室</a></li>
			<li ><a href="<%=path%>/doctors/list">找医生</a></li>
			<div class="clear"></div>
		</ul>
	</div>
</div>

<!--医院详细科室列表-->
<div class="mainlist">
	<div class="department">
		<div class="department_name">${office.name}</div>
		<c:if test="${office.level eq 0}"><span>普通科室</span></c:if>
		<c:if test="${office.level eq 1}"><span>国级科室</span></c:if>
		<c:if test="${office.level eq 2}"><span>省级科室</span></c:if>
		<c:if test="${office.level eq 3}"><span>市级科室</span></c:if>
		<c:if test="${office.level eq 4}"><span>区级科室</span></c:if>
		<div class="department_hos"><a href="<%=path%>/hospitals/info?hid=${hospital.hid}">${hospital.name}</a></div>
	</div>
	<div class="department1">
		<div class="department_name1">科室排班</div>
		<span>（放号时间和可预约天数，请以医院为准）</span>
		<div class="department_hos1">已预约<span>1234</span>人</div>
	</div>
	<div class="doctorlist_title">
		<div>科室专家</div>
		<div>擅长</div>
		<ul>
			<li>
				<div></div>
			</li>
			<li>
				<div></div>
			</li>
			<li>
				<div></div>
			</li>
			<li>
				<div></div>
			</li>
			<li>
				<div></div>
			</li>
			<li>
				<div></div>
			</li>
			<li>
				<div></div>
			</li>
		</ul>
	</div>

	<div class="doctorlist">


		<!--医生循环开始-->
		<c:forEach items="${office.doctorSet }" var="doctor">
			<c:set var="scheduleSet" value="${doctor.scheduleSet}" scope="page"></c:set>
		<div class="doctor_list_first">
			<div class="doctor_list_information">
				<%--<div class="doctor_list_information_img">--%>
					<%--<a href="<%=path%>/doctors/info?did=${doctor.did}">--%>
					<%--<img src="../images/doctor.jpg" alt="医生">--%>
				<%--</div>--%>
				<div class="doctor_list_information_name">
					<div><a href="<%=path%>/doctors/info?did=${doctor.did}">${doctor.name}</a></div>
					<c:if test="${doctor.title eq 0}"><div>主任医师</div></c:if>
					<c:if test="${doctor.title eq 1}"><div>副主任医师</div></c:if>
					<c:if test="${doctor.title eq 2}"><div>主治医师</div></c:if>
				</div>
			</div>
			<div class="doctor_list_goodat">
				<p>${doctor.goodat}</p>
			</div>
			<div class="doctor_list_time">
				<ul>
					<li class="time_am">上午</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 0}">
								<c:if test="${schedule.date.getTime() lt today.getTime() && (schedule.date.getTime() + 86400000) gt today.getTime()}">
						<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 0}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 0}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*2) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*2)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 0}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*3) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*3)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 0}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*4) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*4)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 0}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*5) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*5)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 0}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*6) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*6)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
				</ul>
				<ul>
					<li class="time_am">下午</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 1}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*0) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*0)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 1}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*1) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*1)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 1}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*2) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*2)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 1}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*3) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*3)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 1}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*4) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*4)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 1}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*5) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*5)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
					<li>
						<c:forEach items="${scheduleSet}" var="schedule">
							<c:if test="${schedule.time eq 1}">
								<c:if test="${schedule.date.getTime() lt (today.getTime() +86400000*6) && (schedule.date.getTime() + 86400000) gt (today.getTime() +86400000*6)}">
									<a href="<%=path%>/orders/order?sid=${schedule.sid}">预约</a>
								</c:if>
							</c:if>
						</c:forEach>
					</li>
				</ul>
			</div>
		</div>
		</c:forEach>
		<!--医生循环结束-->


	</div>
</div>

<!--尾部-->
<div class="footer">
	<img src="../images/footer.png">
</div>
</body>
</html>