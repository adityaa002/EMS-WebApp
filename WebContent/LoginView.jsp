<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="Header.jsp"%>
	<form action="LoginCtl" method="post">
		<div align="center">
			<table>
				<h2>Employee Login</h2>
				<tr>
					<th>Login Id :</th>
					<th><input type="text" name="loginId"></th>
				</tr>

				<tr>
					<th>Password :</th>
					<th><input type="password" name="password"></th>
				</tr>

				<tr><th></div>
					<th><input type="submit" name="operation" value="SignIn">
					<input type="submit" name="operation" value="SignUp"></th>
				</tr>

			</table>
	</form>
	</div>
</body>
</html>