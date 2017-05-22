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
${user}，你好 Home JSP , [<a href="${pageContext.request.contextPath}/hello/logout">退出</a>]<br/>
<a href="${pageContext.request.contextPath}/hello/test">触发事务异常</a><br/>
<a href="${pageContext.request.contextPath}/hello/json">打印Json</a><br/>
<a href="${pageContext.request.contextPath}/hello/upload">上传文件</a><br/>

</body>
</html>
