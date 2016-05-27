<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script src="../js/login.js" type="text/javascript"></script>
</head>
<body>
<div class="title">
    <div class="tit">
        挂号系统后台管理|
        <span class="tit_span">医院管理员登录</span>
    </div>
</div><!--title结束-->
<div class="wrap">
    <div class="banner">
        <h2 class="banner_title  blue" onclick="change2(this)">系统管理员登录</h2>
        <h2 class="banner_title2" onclick="change2(this)">医院管理员登录</h2>
    </div>
    <div class="content" id="sAdminLogin">
        <form autocomplete="on" action="<%=path%>/sAdmin/login" method="post">
            <ul>
                <li>
                    <span class="shouji">账号:</span>
                    <div class="tips_div">
                        <input type="tel" class="input_shouji" name="account" placeholder="请输入你的账号" required maxlength="11"/>
                    </div>
                </li>
                <li>
                    <span class="shouji">密码:</span>
                    <div class="tips_div">
                        <input type="password" class="input_shouji" name="password" placeholder="请输入密码" required=""/>
                    </div>
                </li>
                <li class="register_button">
                    <input type="submit" class="register_btn" value="登录"/>
                </li>
            </ul>
        </form>
        <div><span>${errorMsg.message}</span></div>
    </div>
    <div class="content" style="display: none;" id="hAdminLogin">
        <form autocomplete="on" action="<%=path%>/hAdmin/login" method="post">
            <ul>
                <li>
                    <span class="shouji">账号:</span>
                    <div class="tips_div">
                        <input type="tel" class="input_shouji" name="account" placeholder="请输入你的账号" required maxlength="11"/>
                    </div>
                </li>
                <li>
                    <span class="shouji">密码:</span>
                    <div class="tips_div">
                        <input type="password" class="input_shouji" name="password" placeholder="请输入密码" required=""/>
                    </div>
                </li>
                <li class="register_button">
                    <input type="submit" class="register_btn" value="登录"/>
                </li>
            </ul>
        </form>
        <div><span>${errorMsg.message}</span></div>
    </div>
</div>
</body>
</html>