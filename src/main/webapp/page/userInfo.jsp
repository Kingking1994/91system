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
    		<span>账号设置</span>
    	</div>
      <div class="right_content">

    	<div class="account order">
    	    <div class="account_list">
    	    	<ul class="">
    	    		<li class="current">
						<a href="<%=path%>/users/info">账号信息</a>
					</li>
    	    		<li >
						<a href="reset_password.jsp">修改密码</a>
					</li>
    	    	</ul>
    	    </div>


            <div class="lan_left">
    	    <div class="account_setting">
            <form action="info_save" method="post">
              <table>
                  <tr>
                      <td>姓名：</td>
                      <td><input name="name" value="${userInfo.name}"/>&nbsp;&nbsp;*(真实姓名)</td>
                  </tr>
				  <tr>
					  <td>性别：</td>
					  <td><input name="gender" value="${userInfo.gender}"/>&nbsp;&nbsp;*(0：男性；1：女性)</td>
				  </tr>
				  <tr>
					  <td>出生日期：</td>
					  <td><input name="birthday" value="${userInfo.birthday}"/>&nbsp;&nbsp;*(格式：2016-01-01)</td>
				  </tr>
                    <tr>
                      <td>身份证：</td>
                      <td><input name="idcard" value="${userInfo.idcard}"/>&nbsp;&nbsp;*(长度为18位)</td>
                  </tr>
                    <tr>
                      <td>手机：</td>
                      <td><input name="phone" value="${userInfo.phone}"/>&nbsp;&nbsp;*(长度为11位)</td>
                  </tr>
                    <tr>
                      <td>邮箱：</td>
                      <td><input name="email" value="${userInfo.email}"/></td>
                  </tr>
				  <tr>
					  <td>住址：</td>
					  <td><input name="address" value="${userInfo.address}"/></td>
				  </tr>
				  <tr>
					  <td>血型：</td>
					  <td><input name="blood" value="${userInfo.blood}"/>&nbsp;&nbsp;(0:未知&nbsp;1:A型&nbsp;2:B型&nbsp;3:AB型&nbsp;4:O型)</td>
				  </tr>
				  <tr>
					  <td>是否已婚：</td>
					  <td><input name="married" value="${userInfo.married}"/>&nbsp;&nbsp;(0:未知&nbsp;1:未婚&nbsp;2:已婚)</td>
				  </tr>
				  <tr>
					  <td>职业：</td>
					  <td><input name="career" value="${userInfo.career}"/></td>
				  </tr>
                    <input type="submit" class="register_btn save fr" value="保存" />
                 
              </table>
              </form>
    	    </div>
            </div>



    	</div>
    		<!--password结束-->



      </div>
    </div> 
</div>
</body>
</html>