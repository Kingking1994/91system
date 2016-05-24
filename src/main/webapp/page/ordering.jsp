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
	<script type="text/javascript" src="../js/bootstrapValidator.js"></script>
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
		<form action="searching.html" method="post" class="search_form">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
		    <input type="text" value="" class="search_text" placeholder="医院、医生、或疾病名称">
		    <input type="submit" value="搜索" class="search_button">
		</form>
	</div>
    <div class="clear"></div>
</div>

<!-- 预约详情 -->
<div class="booking">
	<div class="doctor_information_title">
		医生信息
	</div>
	<div class="doctor_information">
		<div class="doctor_information_all">
			<div class="doctor_information_img">
				<img src="${doctor.path}" alt="医生">
			</div>
			<div class="doctor_information_name">
				<div><a href="<%=path%>/doctors/info?did=${doctor.did}">${doctor.name}</a></div>
				<div><a href="<%=path%>/hospitals/info?hid=${hospital.hid}">${hospital.name}</a></div>
				<div><a href="<%=path%>/offices/info?oid=${office.oid}">${office.name}</a></div>
				<c:if test="${doctor.title eq 0}"><div>主任医师</div></c:if>
				<c:if test="${doctor.title eq 1}"><div>副主任医师</div></c:if>
				<c:if test="${doctor.title eq 2}"><div>主治医师</div></c:if>
			</div>
		</div>
		<div class="doctor_money">
			<div>门诊类型：<span><a href="<%=path%>/offices/info?oid=${office.oid}">${office.name}</a></span></div>
			<div>挂号费用：<span>${schedule.fee}</span>元</div>
		</div>
	</div>

	<!--订单提交信息-->
	<form action="submit" method="post">

	<div class="doctor_time">
		<div>就诊时间（必填）</div>
		<div>${schedule.date}</div>
		<hr>
		<div class="doctor_time_list">
			<c:if test="${schedule.time eq 0}">
			<p><input type="radio" name="timing" value="9:00:00"/><span>9:00:00</span></p>
			<p><input type="radio" name="timing" value="9:30:00"/><span>9:30:00</span></p>
			<p><input type="radio" name="timing" value="10:00:00"/><span>10:00:00</span></p>
			<p><input type="radio" name="timing" value="10:30:00"/><span>10:30:00</span></p>
			<p><input type="radio" name="timing" value="11:00:00"/><span>11:00:00</span></p>
			<p><input type="radio" name="timing" value="11:30:00"/><span>11:30:00</span></p>
			</c:if>
			<c:if test="${schedule.time eq 1}">
			<p><input type="radio" name="timing" value="14:00:00"/><span>14:00:00</span></p>
			<p><input type="radio" name="timing" value="14:30:00"/><span>14:30:00</span></p>
			<p><input type="radio" name="timing" value="15:00:00"/><span>15:00:00</span></p>
			<p><input type="radio" name="timing" value="15:30:00"/><span>15:30:00</span></p>
			<p><input type="radio" name="timing" value="16:00:00"/><span>16:00:00</span></p>
			<p><input type="radio" name="timing" value="16:30:00"/><span>16:30:00</span></p>
			</c:if>
		</div>
	</div>

	<div class="doctor_patient">
		<div>就诊人信息</div>
		<div>
			<span>姓名<input type="text" name="patient.pname" value="${userInfo.name}"></span>
			<span>性别<input type="text" name="patient.pgender" value="${userInfo.gender}"></span>
			<span>出生日期<input type="text" name="patient.pbirthday" value="${userInfo.birthday}"></span>
			<span>手机号码<input type="text" name="patient.pphone" value="${userInfo.phone}"></span>
		</div>
	</div>
	<div class="doctor_sick">
		<div>疾病信息</div>
		<div>
			<textarea name="patient.pinfo" placeholder="请填写病史，症状，发病时间，接受过的治疗等信息，提前告知医生您的病情，有助于医生对您的诊疗。"></textarea>
		</div>
		<img src="../images/sick.png">
	</div>
	<div class="doctor_other">
		<div>医院预约规则</div>
		<div >
1.为了方便患者就诊，我院开通了网上预约挂号服务。<br>
2.网上预约挂号采用实名制，预约前请先注册，一个手机号和身份证只能申请一个注册号，持注册号可预约14天内出诊专家号。<br>
3.必须填写就诊患者的真实姓名,必须填写就诊患者的真实身份证号,并在就诊时携带我院就诊卡（如果没有请在一楼先办理）,
否则系统会将您的预约信息作废,您将无法在预约取号窗口取号。<br>
4.每位专家限约一个号，当天00：00以后停止预约次日号。<br>
5.网上预约挂号不收取手续费。挂号费及诊金收费标准与现场挂号相同，
即主任医师号9元，副主任医师7元，主治医师4元。<br>
6.为保证您准时就诊，请于就诊当日按所预约时间段提前15分钟到门诊一楼预约取号窗口取号，逾期作废。<br>
7.医生门诊资源有限，如预约成功后因故确定不能按时就诊，请务必于就诊日前一天23：59前及时取消预约，否则按违约处理，累计三次，您将无法进行预约。<br>
8.如果您预约的专家临时请假，我们会通过电话或者短信告知，请注意网上专家门诊停诊通知或进行电话咨询。<br>
		</div>
		<div>
			<input type="checkBox"  value="q" />我已经了解此医院的预约规则
		</div>
	</div>
	<div class="doctor_submit">
		<button><input type="submit" value="提交订单"></button>
		<div class="form-group doctor_sure">
            <label class="control-label" id="captchaOperation"></label>
            <div class="doctor_sure_input">
                <input type="text" id="number" class="form-control" />
            </div>
            <span id="sure_information"></span>
        </div>
	</div>

	</form>

</div>
<!--尾部-->
<div class="footer">
	<img src="../images/footer.png">
</div>
</body>
</html>