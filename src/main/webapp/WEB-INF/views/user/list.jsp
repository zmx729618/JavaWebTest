<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>用户列表</title>
    <!--
	<link rel="stylesheet" href="/css/style.css"/>
	<script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript">  
    </script>
    -->
</head>
<body>


<!--  列表  -->
<table class="flex" cellpadding="0" cellspacing="0" width="100%">

    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名</th>
        <th>邮箱</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="obj" varStatus="i">

            <tr>

                <td>
                        ${obj.id}
                </td>
                <td >
                        ${obj.username}
                </td>
                <td>
                        ${obj.email}
                </td>

            </tr>
        </c:forEach>
    </tbody>
</table>
</table>

</body>
</html>