<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students</title>
</head>
<body>

<c:if test="${empty studentList}">
	<h3>The student list is empty.</h3>
</c:if>

<c:if test="${not empty studentList}">

	<a href="/lab7-web01/NewStudent.jsp">Create new Student</a>

	<table border=true>
	
		<tr>
			<th>Register</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
	
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td>${student.register}</td>
				<td>${student.name}</td>
				<td><a href="???">Edit student</a></td> <!-- Exercício: implementar uma edição de Student. -->
			</tr>
		</c:forEach>
	
	</table>

</c:if>

</body>
</html>