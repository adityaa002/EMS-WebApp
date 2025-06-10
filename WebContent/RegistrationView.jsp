<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<%
		String msg = (String) request.getAttribute("msg");
	%>


	<div align="center">
		<%
			if (msg != null) {
		%>

		<h3>
			<font color="green"><%=msg%></font>
		</h3>

		<%
			}
		%>
	</div>


	<div align="center">
		<form action="RegistrationCtl" method="post">
			<h2>Employee Registration</h2>
			<table>


				<tr>
					<th>First Name:</th>
					<th><input type="text" name="firstName"></th>
				</tr>


				<tr>
					<th>Last Name :</th>
					<th><input type="text" name="lastName"></th>
				</tr>


				<tr>
					<th>Login Id :</th>
					<th><input type="text" name="loginId"></th>
				</tr>


				<tr>
					<th>Password :</th>
					<th><input type="password" name="password"></th>
				</tr>


				<tr>
					<th>Phone :</th>
					<th><input type="text" name="phone"></th>
				</tr>


				<tr>
					<th>Gender :</th>
					<th><input type="text" name="gender"></th>
				</tr>


				<tr>
					<th>Date of birth :</th>
					<th><input type=date name="dob" style="width: 98%"></th>
				</tr>


				<tr>
					<th>Address :</th>
					<th><input type="text" name="address"></th>
				</tr>


				<tr>
					<th>Department Name :</th>
					<th><input type="text" name="deptName"></th>
				</tr>
				<br>

				<tr>
					<th></th>
					<th><input type="Submit" name="operation" value="Submit"></th>
				</tr>




			</table>
		</form>
	</div>

</body>
</html>