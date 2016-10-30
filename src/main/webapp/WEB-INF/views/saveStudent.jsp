<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Add Page Welcome</title>
</head>
<body>
<form:form commandName="student" action="/addStudent" method="POST">

		<table>

			<tr>
				<td>ADI</td>
				<td><input type="text" name="name"></td>

			</tr>
			<tr>
				<td>SOYADI</td>
				<td><input type="text" name="surname"></td>

			</tr>
			
			<tr>
			<td>Phone:</td>
			<td><input type="text" name="phone"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="KAYDET">
				<td>
			</tr>

		</table>

	</form:form>
	<h2>Student Lists</h2>
	
</body>
</html>