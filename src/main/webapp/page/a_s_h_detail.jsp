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
				<span>账号：${s_account}</span>
				<br>
				<a href="<%=path%>/sAdmin/logout"><button>退出</button></a>
			</div>
		</div>
		<div class="user_menu tabs">
		<ul>
			<li class="user_f">
				<a href="<%=path%>/sAdmin/hAdmin_list">医院管理员</a>
			</li>
			<li class="user_f">
				<a href="<%=path%>/sAdmin/hospital_list">医院</a>
			</li>
			<li class="user_f">
				<a href="<%=path%>/page/a_s_password.jsp">密码</a>
			</li>
			<li class="user_f">
				<a href="<%=path%>/sAdmin/sAdmin_list">系统管理员</a>
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
			  <form action="hospital_save" method="post">
				  <table>
					  <tr>
						  <td>hid：</td>
						  <td>
							  <input disabled value="${hospital.hid}"/>&nbsp;*
							  <input name="hid" type="hidden" value="${hospital.hid}"/>
						  </td>
					  </tr>
					  <tr>
						  <td>name：</td>
						  <td><input name="name" value="${hospital.name}"/>&nbsp;*</td>
					  </tr>
					  <tr>
						  <td>address：</td>
						  <td><input name="address" value="${hospital.address}"/>&nbsp;*</td>
					  </tr>
					  <tr>
						  <td>telephone：</td>
						  <td><input name="telephone" value="${hospital.telephone}"/>&nbsp;*</td>
					  </tr>
					  <tr>
						  <td>intro：</td>
						  <td><input name="intro" value="${hospital.intro}"/></td>
					  </tr>
					  <tr>
						  <td>quality：</td>
						  <td><input name="quality" value="${hospital.quality}"/></td>
					  </tr>
					  <tr>
						  <td>region：</td>
						  <td><input name="region" value="${hospital.region}"/></td>
					  </tr>
					  <tr>
						  <td>level：</td>
						  <td><input name="level" value="${hospital.level}"/></td>
					  </tr>
					  <tr>
						  <td>type：</td>
						  <td><input name="type" value="${hospital.type}"/></td>
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