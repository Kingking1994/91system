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
    		<span>账号设置</span>
    	</div>
      <div class="right_content">

    	<div class="account order">
    	    <div class="account_list">
    	    	<ul class="">
    	    		<li >
						<a href="<%=path%>/users/info">账号信息</a>
					</li>
    	    		<li class="current">
						<a href="reset_password.jsp">修改密码</a>
					</li>
    	    	</ul>
    	    </div>


            <div class="lan_right" >
    	    <div class="password">
    		<form class="pass" action="<%=path%>/users/password" method="post">
				<input name="phone" value="${userPhone}" type="hidden">
               <table>
               <tr>
            <td><label for="txtname">旧密码：</label></td>
            <td><input type="password" id="txtname" name="password" /></td>
              </tr>
              <tr>
            <td><label for="txtpswd">新密码：</label></td>
            <td><input type="password" id="txtpswd" name="newPassword" /></td>
             </tr>
             <tr>
            <td colspan=1>
                <input type="submit" class="btn" />
            </td>
            </tr>
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