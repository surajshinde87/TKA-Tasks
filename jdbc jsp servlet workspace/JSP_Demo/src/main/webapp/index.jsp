<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example</title>
</head>
<body>

<h2>Conditional Example</h2>
<%
    int number = 7;
    if(number % 2 == 0){
        out.println("The number " + number + " is Even.");
    } else {
        out.println("The number " + number + " is Odd.");
    }
%>

<h2>Loop Example</h2>
<ul>
<%
    for(int i = 1; i <= 5; i++){
%>
        <li>Number: <%= i %></li>
<%
    }
%>
</ul>

</body>
</html>
