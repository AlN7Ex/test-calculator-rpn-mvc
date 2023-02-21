<%--
  Created by IntelliJ IDEA.
  User: aln7ex
  Date: 17.02.2023
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculate by RPN</h2>
<form name="calc" method="post" action="/calculate">
    <label>
        <input
                type="text"
                size="40"
                name="expression"
                placeholder="Enter expression with space between symbols">
    </label>
    <p>
        <input
                type="submit"
                name="submit"
                value="Enter">
    </p>

</form>
</body>
</html>
