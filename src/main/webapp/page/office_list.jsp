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

	<script type="text/javascript">
		// 当前第几页数据
		var currentPage = ${result.currentPage};

		// 总页数
		var totalPage = ${result.totalPage};


		// 第一页
		function firstPage(){
			if(currentPage == 1){
				alert("已经是第一页数据");
				return false;
			}else{
				var url = "<%=path%>/offices/list?pageNum=1";
				location.href = url;
				return true;
			}
		}

		// 下一页
		function nextPage(){
			if(currentPage == totalPage){
				alert("已经是最后一页数据");
				return false;
			}else{
				var url = "<%=path%>/offices/list?pageNum=" + (currentPage+1);
				location.href = url;
				return true;
			}
		}

		// 上一页
		function previousPage(){
			if(currentPage == 1){
				alert("已经是第一页数据");
				return false;
			}else{
				var url = "<%=path%>/offices/list?pageNum="+ (currentPage-1);
				location.href = url;
				return true;
			}
		}

		// 尾页
		function lastPage(){
			if(currentPage == totalPage){
				alert("已经是最后一页数据");
				return false;
			}else{
				var url = "<%=path%>/offices/list?pageNum=${result.totalPage}";
				location.href = url;
				return true;
			}
		}
	</script>
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
			<input type="text" value="" name="searchString" class="search_text" placeholder="医院、医生、或疾病名称">
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
			<li class="active"><a href="<%=path%>/offices/list">找科室</a></li>
			<li ><a href="<%=path%>/doctors/list">找医生</a></li>
			<div class="clear"></div>
		</ul>
	</div>
</div>

<!--列表-->
<div class="list">
	<ul>
			<li>
				<div class="list_item">科室:</div>
				<div class="list_body">
					<span><a href="#">妇产科</a></span>
					<span><a href="#">内科</a></span>
					<span><a href="#">儿科</a></span>
					<span><a href="#">五官科</a></span>
					<span><a href="#">外科</a></span>
					<span><a href="#">中药科</a></span>
					<span><a href="#">肿瘤科</a></span>
					<span><a href="#">皮肤科</a></span>
					<span><a href="#">男科</a></span>
					<span><a href="#">眼科</a></span>
					<span><a href="#">口腔科</a></span>
					<span><a href="#">精神科</a></span>
					<span><a href="#">整形科</a></span>
				</div>
				<div class="list_more"><a href="#">更多</a><span class="caret"></span></div>
			</li>
	</ul>
</div>

<!--详细列表-->
<div class="mainlist">
	<div class="mainleft" style="margin-left:185px">

		<!-- 后台返回结果为空 -->
		<c:if test="${fn:length(result.dataList) eq 0 }">
			<span>查询的结果不存在</span>
		</c:if>


		<c:if test="${fn:length(result.dataList) gt 0 }">
			<!--列表循环开始-->
			<c:forEach items="${result.dataList }" var="office">
				<div class="first_list">
					<div class="mainlist_image">
						<a href="<%=path%>/offices/info?oid=${office.oid}">
							<img src="../images/hospital.jpg" alt="医院">
						</a>
					</div>
					<div class="mainlist_mid">
						<a href="<%=path%>/offices/info?oid=${office.oid}"><h3>${office.name}</h3></a>
						<c:if test="${office.level eq 0}"><span>普通科室</span></c:if>
						<c:if test="${office.level eq 1}"><span>国级科室</span></c:if>
						<c:if test="${office.level eq 2}"><span>省级科室</span></c:if>
						<c:if test="${office.level eq 3}"><span>市级科室</span></c:if>
						<c:if test="${office.level eq 4}"><span>区级科室</span></c:if>
							<%--<span class="glyphicon glyphicon-ok-circle" aria-hidden="true">12</span>--%>
							<%--<span class="glyphicon glyphicon-question-sign" aria-hidden="true">0</span>--%>
							<%--<span class="glyphicon glyphicon-plus" aria-hidden="true">0</span>--%>
					</div>
					<div class="clear"></div>
				</div>
				<!--列表循环结束-->
			</c:forEach>

			<br> 共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
			<a href="#" onclick="firstPage();">首页</a>&nbsp;&nbsp;
			<a href="#" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
			<a href="#" onclick="nextPage();">下一页</a>&nbsp;&nbsp;
			<a href="#" onclick="lastPage();">尾页</a>

		</c:if>
	</div>

</div>

<!--尾部-->
<div class="footer">
	<img src="../images/footer.png">
</div>
</body>
</html>