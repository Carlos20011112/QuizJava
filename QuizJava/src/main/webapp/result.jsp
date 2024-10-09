<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    String status = request.getParameter("status");
    if ("fail".equals(status)) {
%>
<h2>Game Over! You answered incorrectly.</h2>
<%
} else {
%>
<h2>Congratulations! You completed the quiz.</h2>
<%
    }
%>
<a href="quiz">Try Again</a>
</body>
</html>
