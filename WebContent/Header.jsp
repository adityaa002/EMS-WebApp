<%@page import="in.co.sharnx.adv.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		UserBean user = (UserBean) session.getAttribute("bean");
	%>

	<%
		if (user != null) {
	%>
	<h3>
		Hey ,
		<%=user.getFirstName()%>
	</h3>

	<a href="AddEmployeeCtl"><b>Add Employee</b></a>
	<th>|</th>
	<a href="EmployeeListCtl"><b>Employee List</b></a>
	<th>|</th>
	<a href="LoginCtl?operation=logout"><b>LogOut</b></a>


	<%
		} else {
	%>



	<h3>Hey, Guest..!</h3>
	<a href="WelcomeCtl"><b>Welcome</b></a>
	<th>|</th>
	<a href="LoginCtl"><b>Login</b></a>
	<%
		}
	%>

</body>
</html>