<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
<h2>this is success.jsp</h2>

<!-- 遍历开始-->
<%--<s:iterator value="#session.hospitals" var="hospital">--%>
    <%--<tr class="list">--%>
        <%--<td><s:property value="#hospital.hid"/></td>--%>
        <%--<td><s:property value="#hospital.name"/></td>--%>
        <%--<td><s:property value="#hospital.address"/></td>--%>
        <%--<td><s:property value="#hospital.telephone"/></td>--%>
        <%--<td><s:property value="#hospital.intro"/></td>--%>
        <%--<td><s:property value="#hospital.quality"/></td>--%>
        <%--<td><s:property value="#hospital.region"/></td>--%>
        <%--<td><s:property value="#hospital.level"/></td>--%>
        <%--<td><s:property value="#hospital.type"/></td>--%>
    <%--</tr>--%>
    <%--<br>--%>
<%--</s:iterator>--%>
<!-- 遍历结束 -->



<c:forEach items="${userInfo.orderItemSet}" var="order">
    <div>  名字：${order.patient.pname }   id：${order.oiid }  </div>

</c:forEach>

<%--<c:out value="${schedule.sid}"></c:out>--%>
<%--<c:out value="${doctor.did}"></c:out>--%>
<%--<c:out value="${office.oid}"></c:out>--%>
<%--<c:out value="${hospital.hid}"></c:out>--%>
<%--<c:out value="${userInfo.uiid}"></c:out>--%>

</body>
</html>
