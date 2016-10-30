<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	
	
	<h2>Student Lists</h2>
	<table border="1">
	
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SURNAME</th>
		</tr>

		<c:forEach items="${listStudent}" var="s">
			<tr>
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.surname }</td>
			</tr>

		</c:forEach>


	</table>


	
	<form:form commandName="student" action="/addStudent" method="POST">

	<input type="submit" value="StudentAddPage Go">

	</form:form>
	
	
	
</body>
</html>
