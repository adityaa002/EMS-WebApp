
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>








	<%
		UserBean bean = (UserBean) request.getAttribute("bean");

		String msg = (String) request.getAttribute("msg");
	%>
	

	<%@include file="Header.jsp"%>



	<form action="AddEmployeeCtl" method="post">

		<div align="center">





			<%
				if (bean != null && bean.getId() > 0) {
			%>
			<h2>Update Employee</h2>
			<%
				} else {
			%>
			<h2>Add Employee</h2>
			<%
				}
			%>
			
			
			<div align="center">
		 
	</div>



			<%
				if (msg != null) {
			%>
			<h3>
				<font color="Green"><%=msg%></font>
			</h3>
			<%
				}
			%>
		</div>

		<div align="center">
			<table>



				<tr>
					<th></th>
					<td><input type="text" name="id"
						value="<%=(bean != null) ? bean.getId() : ""%>"></td>

				</tr>
				<tr>
					<th>First Name :</th>
					<th><input type="text" name="firstName"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getFirstName() : ""%>"></th>
				</tr>

				<tr>
					<th>Last Name :</th>
					<th><input type="text" name="lastName"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getLastName() : ""%>"></th>
				</tr>


				<tr>
					<th>Login Id :</th>
					<th><input type="text" name="loginId"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getLoginId() : ""%>"></th>
				</tr>


				<tr>
					<th>Password :</th>
					<th><input type="password" name="password"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getPassword() : ""%>"></th>
				</tr>


				<tr>
					<th>Phone :</th>
					<th><input type="text" name="phone"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getPhone() : ""%>"></th>
				</tr>


				<tr>
					<th>Gender :</th>
					<th><input type="text" name="gender"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getGender() : ""%>"></th>
				</tr>


				<tr>
					<th>Date of birth :</th>
					<th><input type=date name="dob" style="width: 98%"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getDob() : ""%>"></th>
				</tr>


				<tr>
					<th>Address :</th>
					<th><input type="text" name="address"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getAddress() : ""%>"></th>
				</tr>


				<tr>
					<th>Department Name :</th>
					<th><input type="text" name="deptName"
						value="<%=(bean != null && bean.getId() > 0) ? bean.getDeptName() : ""%>"></th>
				</tr>
				<br>

				<tr>
					<td></td>
					<td><input type="Submit" name="operation"
						value="<%=(bean != null && bean.getId() > 0) ? "update" : "save"%>"></td>

				</tr>

			</table>
		</div>
	</form>


</body>
</html>