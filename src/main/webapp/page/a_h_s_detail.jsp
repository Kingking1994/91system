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

<!--logo  -->
<div class="header">
	<div class="logo_block">
		<div class="logo">
		</div>
	</div>
    <div class="clear"></div>
</div>

<!--标签页-->
<div class="tag">
	<div class="tag_content">
		<ul>
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
				<span>账号：${h_account}</span>
				<br>
				<a href="<%=path%>/hAdmin/logout"><button>退出</button></a>
			</div>
		</div>
		<div class="user_menu tabs">
			<ul>
				<li class="user_f">
					<a href="<%=path%>/hAdmin/office_list">科室管理</a>
				</li>
				<li class="user_f">
					<a href="<%=path%>/hAdmin/doctor_list">医生管理</a>
				</li>
				<li class="user_f">
					<a href="<%=path%>/hAdmin/schedule_list">排班管理</a>
				</li>
				<li class="user_f">
					<a href="<%=path%>/page/a_h_password.jsp">密码管理</a>
				</li>
			</ul>
		</div>
	</div>
    <div class="right_main">
        <div class="right_title title">
    		<span>医院管理</span>
    	</div>
      <div class="right_content">
       <div class="order order_list" id="order_list" >
    	  <div class="right_menu">
			  <div class="account_setting">
			  <form action="schedule_save" method="post">
				  <table>
					  <tr>
						  <td>sid：</td>
						  <td>
							  <input disabled value="${schedule.sid}"/>&nbsp;*
							  <input name="sid" type="hidden" value="${schedule.sid}"/>
						  </td>
					  </tr>
					  <tr>
						  <td>date：</td>
						  <td><input name="date" value="${schedule.date}"/>&nbsp;*</td>
					  </tr>
					  <tr>
						  <td>time：</td>
						  <td><input name="time" value="${schedule.time}"/>&nbsp;*</td>
					  </tr>
					  <tr>
						  <td>num：</td>
						  <td><input name="num" value="${schedule.num}"/>&nbsp;*</td>
					  </tr>
					  <tr>
						  <td>ordernum：</td>
						  <td><input name="ordernum" value="${schedule.ordernum}"/>&nbsp;*</td>
					  </tr>
					  <tr>
						  <td>fee：</td>
						  <td><input name="fee" value="${schedule.fee}"/>&nbsp;*</td>
					  </tr>
					  <tr>
						  <td>did：</td>
						  <td><input name="did" value="${schedule.did}"/>&nbsp;*</td>
					  </tr>
					  <input type="submit" class="register_btn save fr" value="保存" />

				  </table>
			  </form>
			  </div>

    	  </div>
    	</div>
    	<!--order_list结束-->

      </div>
    </div> 
</div>
</body>
</html>