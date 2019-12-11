<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/4 0004
  Time: 上午 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="/upload">
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
</body>
</html>
