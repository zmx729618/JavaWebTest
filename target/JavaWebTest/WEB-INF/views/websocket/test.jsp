<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title></title>
    <!--
	<link rel="stylesheet" href="/css/style.css"/>
    -->
    <script type="text/javascript" src="${ctx}/js/jquery/jquery.js"></script>
</head>
<body>

    <script type="text/javascript">
        var ws;
        $(function() {
            console.log("abc");
            $.ajax({
                url:"http://localhost:8080/JavaWebTest/webSocket/1",
                success:function(result){
                    console.log(result);
                    ws = new WebSocket("ws://localhost:8080/JavaWebTest/websocket")
                    ws.onopen = function () {
                        console.log("onpen");
                        ws.send("{}");
                    }
                    ws.onclose = function () {
                        console.log("onclose");
                    }

                    ws.onmessage = function (msg) {
                        console.log(msg);
                        console.log(msg.data);
                    }
                }
            });
        })
    </script>


</body>
</html>