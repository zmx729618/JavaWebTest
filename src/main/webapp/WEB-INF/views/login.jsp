<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>用户登陆</title>

    <script type="text/javascript">
        //登陆加载
        function btnClick(){
            if(!/^[0-9a-zA-Z_]{2,20}$/.test($("#username").val())){
                alert("用户名不符合要求！");
                $("#username").focus();
                return;
            }else if(!/^[0-9a-zA-Z_]{2,20}$/.test($("#password").val())){
                alert("密码不符合要求！");
                $("#password").focus();
                return;
            } else{
                $.ajax({
                    url:"login_login.action",
                    type:"post",
                    data:{username:$("#username").val(),password:$("#password").val(),authcode:$("#authcode").val()},
                    success:function(data){
                        if(data == "0"){
                            $("#myForm").attr("action","/index");
                            $("#myForm").submit();
                        }else if(data == "2"){
                            $("#usernameMsg").html(alert("验证码不正确！"));
                        }else if(data == "3"){
                            $("#usernameMsg").html(alert("系统异常，请联系管理员！"));
                        }else if(data == "5"){
                            $("#usernameMsg").html(alert("未分配权限，请联系管理员！"));
                        }else{
                            $("#usernameMsg").html(alert("用户名或密码不正确！"));
                        }
                        changeAuthCode();
                    }
                });
            }
        }
        //cookie记住用户名
        function setCookie(){
            var username = $('#username').val();
            var date = new Date();
            date.setDate(date.getFullYear()+10);
            if(username!=""){
                document.cookie = "username="+username+";expires="+date.toGMTString();
                //var cookieVal = document.cookie;
                //var cookie_uname = cookieVal.substring(cookieVal.indexOf("=")+1, cookieVal.indexOf(";"));
                //var cname = cookieVal.indexOf("username");
                //alert(document.cookie);
                //if(username!=cookie_uname){
                //document.cookie = "username="+username+";expires="+date.toGMTString();
                //}
            }
        }
        //得到Cookie值
        function getCookie(){
            $("#username").focus();
            var cookieVal = document.cookie;
            var key = "username";
            var start = cookieVal.indexOf('username');
            var end = cookieVal.indexOf(";");
            var cookie_uname;
            if(start==-1){//没有存入用户
                return false;
            }
            if(start!=-1){
                start = start + key.length+1;
            }
            if(end==-1){//只有一个cookie值
                cookie_uname = cookieVal.substring(start);
            }else{
                cookie_uname = cookieVal.substring(start,end);
            }
            if(cookie_uname!=""){
                $('#username').val(cookie_uname);
            }

        }
        //enter键触发登录
        function onEnter(event) {
            e = event ? event : (window.event ? window.event : null);
            if (e.keyCode == 13) {
                btnClick();
            }
        }
        document.onkeypress = onEnter;
    </script>
</head>
<body class="login_body_bg" onload="getCookie();">
<div  class="login_bg">
    <div class="loginbox">
        <form action="" id="myForm" method="post">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="58%">账号：<input type="text" tabindex="1" id="username" name="username" class="text" /></td>
                </tr>
                <tr>
                    <td>密码：<input type="password" tabindex="2" id="password" name="password" class="text"/></td>
                </tr>
                <tr>

                    <td>
                        <input type="checkbox" name="checkbox" id="checkbox" onclick="setCookie()"/>
                        <span class="jlzh">记录账号</span>
                    </td>
                </tr>
                <tr>

                    <td width="42%" rowspan="2">
                        <input type="button" id="login" tabindex="4" name="button" onclick="btnClick();" value="登录" class="enter"/>
                    </td>
                </tr>
            </table>
        </form>

    </div>
</div>
</body>
</html>
