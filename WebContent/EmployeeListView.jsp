<%@ page import="in.co.sharnx.adv.bean.UserBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>

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
		String msg = (String) request.getAttribute("msg");
		List nextList = (List) request.getAttribute("nextList");
		int pageNo = (int) request.getAttribute("pageNo");
		int index = ((pageNo - 1) * 5) + 1;
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>

	<%@include file="Header.jsp"%>
	<form action="EmployeeListCtl" method="post">
		<div align="center">

			<h1>Employee list</h1>
		</div>

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
			<table>
				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName"
						placeholder="enter your first name">&nbsp; &nbsp;</td>
					<th>Date of Birth :</th>
					<td><input type="Date" name="dob">&nbsp; &nbsp;</td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
		</div>


		<br>
		<div>
			<table border="1" style="width: 98%">

				<tr>
					<th>Select</th>
					<th>S.No</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login Id</th>
					<th>Password</th>
					<th>Phone</th>
					<th>Gender</th>
					<th>Date of Birth</th>
					<th>Address</th>
					<th>Department</th>
					<th>Edit</th>
				</tr>

				<%
					while (it.hasNext()) {
						UserBean bean = (UserBean) it.next();
				%>
				<tr>
					<th><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></th>
					<td><%=index++%></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLoginId()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getPhone()%></td>
					<td><%=bean.getGender()%></td>
					<td><%=bean.getDob()%></td>
					<td><%=bean.getAddress()%></td>
					<td><%=bean.getDeptName()%></td>
					<td><a href="AddEmployeeCtl?id=<%=bean.getId()%>">edit</a></td>
					</th>

				</tr>
				<%
					}
				%>



			</table>

			<br>

			<table style="width: 100%">

				<tr>
					<td style="width: 30%"><input type="submit" name="operation"
						value="previous" <%=(pageNo == 1) ? "disabled" : ""%>></td>


					<td style="width: 30%"><input type="submit" name="operation"
						value="add"></td>


					<td style="width: 30%"><input type="submit" name="operation"
						value="delete"></td>


					<td style="text-align: right"><input type="submit"
						name="operation" value="next"
						<%=(nextList.size() == 0) ? "disabled" : ""%>></td>


				</tr>

			</table>
			<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
	</div>

</body>
</html>