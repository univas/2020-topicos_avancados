<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
</head>
<body>
	<table border=true>
		<tr>
			<th>Registration</th>
			<th>Name</th>
		</tr>

		<c:forEach items="${studentList}" var="aluno">
			<tr>
				<td>${aluno.registration}</td>
				<td>${aluno.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>