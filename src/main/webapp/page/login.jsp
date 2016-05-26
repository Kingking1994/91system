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
        挂号系统|
        <span class="tit_span">用户注册</span>
    </div>
</div><!--title结束-->
<div class="wrap">
    <div class="banner">
        <h2 class="banner_title  blue" onclick="change(this)">注册账号</h2>
        <h2 class="banner_title2" onclick="change(this)">用户登录</h2>
    </div>
    <div class="content" id="register">
        <form autocomplete="on" action="<%=path%>/users/register" method="post">
            <h3>请填写以下账号信息</h3>
            <ul>
                <li>
                    <span class="shouji">手机号码:</span>
                    <div class="tips_div">
                        <input type="tel" class="input_shouji" name="phone" placeholder="请输入你的手机号码" required maxlength="11" autofocus/>
                    </div>
                </li>
                <li>
                    <span class="shouji">设置密码:</span>
                    <div class="tips_div">
                        <input type="password" class="input_shouji" name="password" placeholder="请输入密码" required/>
                    </div>
                </li>
                <li class="register_button">
                    <input type="submit" class="register_btn" value="注册" />
                </li>
            </ul>
        </form>
        <div><span>${errorMsg.message}</span></div>
    </div>
    <div class="content" style="display: none;" id="login">
        <form autocomplete="on" action="<%=path%>/users/login" method="post">
            <ul>
                <li>
                    <span class="shouji">手机号码:</span>
                    <div class="tips_div">
                        <input type="tel" class="input_shouji" name="phone" placeholder="请输入你的手机号码" required maxlength="11"/>
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