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
				var url = "<%=path%>/hAdmin/office_list?pageNum=1";
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
				var url = "<%=path%>/hAdmin/office_list?pageNum=" + (currentPage+1);
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
				var url = "<%=path%>/hAdmin/office_list?pageNum="+ (currentPage-1);
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
				var url = "<%=path%>/hAdmin/office_list?pageNum=${result.totalPage}";
				location.href = url;
				return true;
			}
		}
	</script>
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
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a style="font-size: 20px" href="<%=path%>/page/a_h_o_add.jsp"><button>添加</button></a>
    	</div>
      <div class="right_content">
       <div class="order order_list" id="order_list" >
    	  <div class="right_menu">

			  <c:if test="${fn:length(result.dataList) eq 0}">
				  <div class="right_menu_title">
					  <span>没有相关记录</span>
				  </div>
			  </c:if>
			  <c:if test="${fn:length(result.dataList) gt 0}">
    		<div class="right_menu_title">
    			<ul class="clearfix">
    				<li>oid</li>
    				<li>name</li>
    				<li>type</li>
					<li>level</li>
    				<li>操作</li>
    			</ul>
    		</div>

				  <c:forEach items="${result.dataList}" var="office">
			  <div class="right_item">
				  <div class="item_detail">
					  <ul class="clearfix">
						  <li><a href="<%=path%>/hAdmin/office_update?oid=${office.oid}">${office.oid}</a></li>
						  <li>${office.name}</li>
						  <li>${office.type}</li>
						  <li>${office.level}</li>
						  <li>
							<span>
								<a href="<%=path%>/hAdmin/office_update?oid=${office.oid}">修改</a>
							</span>
							<span>
								<a href="<%=path%>/hAdmin/office_delete?oid=${office.oid}">删除</a>
							</span>
						  </li>
					  </ul>
				  </div>
			  </div>
				  </c:forEach>

			  <div >
			  <br> 共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
			  <a href="#" onclick="firstPage();">首页</a>&nbsp;&nbsp;
			  <a href="#" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
			  <a href="#" onclick="nextPage();">下一页</a>&nbsp;&nbsp;
			  <a href="#" onclick="lastPage();">尾页</a>
			  </div>

			  </c:if>

    	  </div>
    	</div>
    	<!--order_list结束-->

      </div>
    </div> 
</div>
</body>
</html>