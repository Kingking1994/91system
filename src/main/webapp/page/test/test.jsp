<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2016/5/5
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
</head>
<body>

<form name="loginForm" action="<%=path%>/orders/submit" method="post">
  <!-- start of login form -->


  <div >
    <span class="item">具体时间</span>
    <span class="input"><input type="text" name="timing" class="form-input"></span>
  </div>
  <div >
    <span class="item">就诊者姓名</span>
    <span class="input"><input type="text" name="patient.pname" class="form-input" value="${userInfo.name}"></span>
  </div>
  <div >
    <span class="item">就诊者出生日期</span>
    <span class="input"><input type="text" name="patient.pbirthday" class="form-input" value="${userInfo.birthday}"></span>
  </div>
  <div >
    <span class="item">就诊者性别</span>
    <span class="input"><input type="text" name="patient.pgender" class="form-input" value="${userInfo.gender}"></span>
  </div>
  <div >
    <span class="item">就诊者联系电话</span>
    <span class="input"><input type="text" name="patient.pphone" class="form-input" value="${userInfo.phone}"></span>
  </div><div >
  <span class="item">就诊者疾病信息</span>
  <span class="input"><input type="text" name="patient.pinfo" class="form-input"></span>
</div>



  <div id="button-group">
    <input type="submit" class="btn" value="提交"/>
  </div>
  <div>
  </div>
  <!-- end of form -->
</form>

</body>
</html>
