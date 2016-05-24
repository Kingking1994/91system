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
                    <li >
						<a href="<%=path%>/wallets/trade">交易记录</a>
					</li>
                    <li class="current">
						<a href="<%=path%>/wallets/refund">退款记录</a>
					</li>
                </ul>
             </div>

				<c:if test="${fn:length(wallet.refundSet) eq 0}">
				<div class="lan_right">没有相关记录</div>
				</c:if>

				<c:if test="${fn:length(wallet.refundSet) gt 0}">

             <div class="lan_right">
                <table class="col_table">
                    <thead>
                        <tr>
							<th>订单号</th>
                            <th>申请提交时间</th>
                            <th>退款金额（元）</th>
                            <th>退款状态</th>
                        </tr>

						<c:forEach items="${wallet.refundSet}" var="refund">
						<tr>
							<td>
								<a href="<%=path%>/orders/detail?oiid=${refund.orderItem.oiid}">${refund.orderItem.oiid}</a>
							</td>
							<td>${refund.apply}</td>
							<td>${refund.amount}</td>
							<c:if test="${refund.status eq 0}">
							<td>成功退款</td>
							</c:if>
							<c:if test="${refund.status eq 1}">
							<td>已取消</td>
							</c:if>
							<c:if test="${refund.status eq 2}">
							<td>正在处理</td>
							</c:if>
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