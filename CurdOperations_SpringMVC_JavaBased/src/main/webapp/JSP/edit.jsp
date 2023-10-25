<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT INFO</title>
</head>
<body>
<form action="update">
<pre>
<input type="hidden" name="id" value="${e.id}">
name     :<input type="text" name="name" value="${e.name}">
Username :<input type="text" name="username" value="${e.username}">
Password :<input type="text" name="password" value="${e.password}">
<input type="Submit" value="update">
</pre>
</form>
</body>
</html>
