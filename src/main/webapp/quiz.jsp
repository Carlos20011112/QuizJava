<%@ page import="mx.com.gm.quizjava.MultipleChoiceQuestion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Quiz</title>
</head>
<body>
<% MultipleChoiceQuestion multipleChoiceQuestion = (MultipleChoiceQuestion) request.getAttribute("question"); %>
<% if (multipleChoiceQuestion != null) { %>
<h2><%= multipleChoiceQuestion.getQuestion() %></h2>
<form action="quiz" method="post">
    <%
        String[] options = multipleChoiceQuestion.getOptions();
        for (int i = 0; i < options.length; i++) {
    %>
    <input type="radio" name="answer" value="<%= i %>" required> <%= options[i] %><br>
    <%
        }
    %>
    <button type="submit">Submit</button>
</form>
<% } else { %>
<h2>No question available. Please try again later.</h2>
<% } %>
</body>
</html>
