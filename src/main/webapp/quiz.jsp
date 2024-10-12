<%@ page import="mx.com.gm.quizjava.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Quiz</title>
</head>
<body>
<% Question question = (Question) request.getAttribute("question"); %>
<h2><%= question.getQuestion() %></h2>
<form action="quiz" method="post">
    <%
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
    %>
    <input type="radio" name="answer" value="<%= i %>" required> <%= options[i] %><br>
    <%
        }
    %>
    <button type="submit">Submit</button>
</form>
</body>
</html>
