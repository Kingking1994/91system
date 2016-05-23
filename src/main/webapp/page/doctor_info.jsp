<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
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
<!-- 背景图片 -->
<div>
	<img src="../images/doctorbackground.jpg">
</div>

<div class="doctor">
	<div class="doctor_title">
		<div class="doctor_img">
			<img src="${doctor.path}" alt="医生">
		</div>
		<div class="doctor_name">
			<div>${doctor.name}</div>
			<c:if test="${doctor.title eq 0}"><div>主任医师</div></c:if>
			<c:if test="${doctor.title eq 1}"><div>副主任医师</div></c:if>
			<c:if test="${doctor.title eq 2}"><div>主治医师</div></c:if>
			<div><a href="<%=path%>/hospitals/info?hid=${hospital.hid}">${hospital.name}</a></div>
		</div>
		<div class="doctor_ewm">
			<img src="../images/doctorewm.png">
		</div>
	</div>
	<div class="mainpagelist">
		<ul>
			<li class="active">医生主页</li>
			<div class="clear"></div>
		</ul>
	</div>
	<div class="mainpage">
		<div class="mainpage_left">
			<div class="mainpage_left_title">
				<div class="mainpage_left_title_name">科室排班</div>
				<span>（放号时间和可预约天数，请以医院为准）</span>
				<div class="mainpage_left_title_pep">已预约<span>1234</span>人</div>
			</div>
			<div class="mainpage_left_title_keshi">
				<div>科室</div>
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
			<div class="doctorpage">
				<div class="doctorpage_dep">
						<p><a href="<%=path%>/offices/info?oid=${office.oid}">${office.name}</a></p>
				</div>
				<c:set var="scheduleSet" value="${doctor.scheduleSet}" scope="page"></c:set>
				<div class="doctorpage_time">
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
		</div>
		<div class="mainpage_right">
			<h3>医生擅长</h3>
			<p>${doctor.goodat}</p>
			<br>
			<br>
			<h3>医生简介</h3>
			<p>${doctor.intro}</p>
		</div>
	</div>

</div>

<!--尾部-->
<div class="footer">
	<img src="../images/footer.png">
</div>
</body>
</html>