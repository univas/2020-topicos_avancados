<html>
<head>
<meta charset="UTF-8">
<title>New Student Form</title>
</head>
<body>

	<a href="/lab7-web01/StudentService">Back to Student list</a>
	<form action="/lab7-web01/StudentService" method="post">

		<!-- usado para controlar o fluxo no doGet e doPost devido ao edit/novo -->
		<input type="hidden" name="type" value="${actionType}" />
		
		<label>Register:</label>
		<input type="text" name="register" value="${studentToEdit.register}"/>
		
		<label>Name:</label>
		<input type="text" name="name" value="${studentToEdit.name}"/>

		<input type="submit" value="Save student" />

	</form>

</body>
</html>