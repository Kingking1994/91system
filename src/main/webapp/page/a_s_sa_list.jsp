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
    		<span>系统管理员管理</span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a style="font-size: 20px" href="<%=path%>/page/a_s_sa_detail.jsp"><button>添加</button></a>
    	</div>
      <div class="right_content">
       <div class="order order_list" id="order_list" >
    	  <div class="right_menu">

			  <c:if test="${fn:length(sAdminList) eq 0}">
				  <div class="right_menu_title">
					  <span>没有相关记录</span>
				  </div>
			  </c:if>
			  <c:if test="${fn:length(sAdminList) gt 0}">
    		<div class="right_menu_title">
    			<ul class="clearfix">
    				<li>said</li>
    				<li>account</li>
    				<li>password</li>
					<li>isroot</li>
    				<li>操作</li>
    			</ul>
    		</div>

				  <c:forEach items="${sAdminList}" var="sAdmin">
			  <div class="right_item">
				  <div class="item_detail">
					  <ul class="clearfix">
						  <li>${sAdmin.said}</li>
						  <li>${sAdmin.account}</li>
						  <li>${sAdmin.password}</li>
						  <li>${sAdmin.isroot}</li>
						  <li>
							<span>
								<a href="<%=path%>/sAdmin/sAdmin_delete?said=${sAdmin.said}">删除</a>
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