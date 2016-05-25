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
			<input type="text" value="" name="searchString" class="search_text" placeholder="医院、科室、或医生名称">
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
				<c:if test="${identify eq 1}">
					${userName}
				</c:if>
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
    		<span>钱包管理</span>
    	</div>
      <div class="right_content">

    	<div class="order col_main" >
    		<div class="col_recharge title">
    			您当前的余额：
    			<span>¥ ${wallet.account}</span>
    			<span>
    				<a class="recharge_btn">充值</a>
    			</span>
    		</div>

    		<div class="col_content">
              <div class="account_list">
                <ul class="">
                    <li class="current">
						<a href="<%=path%>/wallets/trade">交易记录</a>
					</li>
                    <li>
						<a href="<%=path%>/wallets/refund">退款记录</a>
					</li>
                </ul>
             </div>

				<c:if test="${fn:length(wallet.refundSet) eq 0}">
					<div class="lan_left">没有相关记录</div>
				</c:if>

				<c:if test="${fn:length(wallet.tradeSet) gt 0}">
             <div class="lan_left">
    			<table class="col_table">
    				<thead>
    					<tr>
    						<th>时间</th>
    						<th>订单号</th>
    						<th>金额（元）</th>
    					</tr>

						<c:forEach items="${wallet.tradeSet}" var="trade">
						<tr>
							<td>${trade.time}</td>
							<td>
								<a href="<%=path%>/orders/detail?oiid=${trade.orderItem.oiid}">${trade.orderItem.oiid}</a>
							</td>
							<td>${trade.amount}</td>
						</tr>
						</c:forEach>
    				</thead>
    			</table>
             </div>

				</c:if>

             <div class="shadow"></div>


             <div class="recharge_dialog" style="display: none;">
                 <div class="dialog_title">
                     <span>充值</span>
                     <a class="glyphicon glyphicon-remove fr"></a>
                 </div>
				 <form action="recharge" method="post">
                 <div class="dialog_main">
                     充值金额:
                     <input value="30" name="rechargeAmount"/>元
                    <ul class="fr">
                        <li class="cur">30元</li>
                        <li>50元</li>
                        <li>100元</li>
                    </ul>
                    </div>
                    <div class="dialog_btn">
                     <input type="submit" class="btn" value="确定，去付款" />
                     </div>
				 </form>
             </div>



    		</div>
    	</div>


      </div>
    </div> 
</div>
</body>
</html>