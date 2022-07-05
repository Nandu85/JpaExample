<%--
  Created by IntelliJ IDEA.
  User: knandani
  Date: 10-06-2022
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/response/comform" method="post">
    <input type="text" name="comName">
    <input type="submit" name="Submit">

</form>
<h1>==>${msg}</h1>
<h1>==>${company.comName}</h1>
<h1>==>${company.comOwner}</h1>
<h1>==>${company.comValue}</h1>
<h1>==>${company.comId}</h1>
</body>
</html>
