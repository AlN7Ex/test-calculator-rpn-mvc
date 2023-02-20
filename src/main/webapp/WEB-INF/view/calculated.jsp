<%--
  Created by IntelliJ IDEA.
  User: aln7ex
  Date: 17.02.2023
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<%String result = (String) request.getAttribute("result");%>
<h3>Result: <%=result%></h3>
<p>
    <a href="calculate">Let's calculate another one expression</a>
</p>
</body>
</html>
