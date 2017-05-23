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


<form action="${pageContext.request.contextPath}/hello/doUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/><br/><br/>
    <input type="submit" value="上传文件"/>
</form>
</body>
</html>
