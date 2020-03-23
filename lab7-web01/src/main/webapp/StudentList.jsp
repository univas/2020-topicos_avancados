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
	<h3>A lista de alunos está vazia.</h3>
</c:if>

<c:if test="${not empty studentList}">

	<table border=true>
	
		<tr>
			<th>Registro</th>
			<th>Nome</th>
		</tr>
	
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td>${student.register}</td>
				<td>${student.name}</td>
			</tr>
		</c:forEach>
	
	</table>

</c:if>

</body>
</html>