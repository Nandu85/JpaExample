<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="<%=request.getContextPath()%>/app/addCom" method="post">
    <input name="company" type="text">Hello
    <button type="submit" name="submit"></button>
</form>
<a href="hello-servlet">Hello Servlet</a>


</body>
</html>