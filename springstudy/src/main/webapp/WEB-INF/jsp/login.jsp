<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-05-16
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/hello/login" method="post">
    <input type="text" name="name"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
