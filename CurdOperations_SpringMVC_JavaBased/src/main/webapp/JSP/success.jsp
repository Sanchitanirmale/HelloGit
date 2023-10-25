<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<script type="text/javascript">
function deleteEmployee() {
    alert("he");
    document.fn.action="delete";
    document.fn.submit();
}

function editEmployee() {
    document.fn.action="edit";
    document.fn.submit();
}

function OpenRegister() {
    document.fn.action="openreg";
    document.fn.submit();
}
</script>
</head>
<body>
<form name="fn">
<table border="2">
<tr>
<th>ID</th>
<th>NAME</th>
<th>USERNAME</th>
<th>PASSWORD</th>
<th>ACTION</th>
</tr>
<c:forEach items="${l}" var="e">
<tr>
<td><input type="radio" name="id" value="${e.id}"></td>
<td>${e.name}</td>
<td>${e.username}</td>
<td>${e.password}</td>
<td><a href="delete?id=${e.id}">DELETE</a> || <a href="edit?id=${e.id}">EDIT</a></td>
</tr>
</c:forEach>
</table>
<button onclick="deleteEmployee()">DELETE</button> || <button onclick="editEmployee()">EDIT</button>
|| <button onclick="OpenRegister()">Add Data</button>
</form>
</body>
</html>
