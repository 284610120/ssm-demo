<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-05-15
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${empty user}">
        <a href="${pageContext.request.contextPath}/hello/login">去登录</a><br/>
    </c:when>
    <c:otherwise>
        ${user}，你好 Index JSP , [<a href="${pageContext.request.contextPath}/hello/logout">退出</a>]<br/>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/hello/test">触发事务异常</a><br/>
<a href="${pageContext.request.contextPath}/hello/json">打印Json</a><br/>

</body>
</html>
