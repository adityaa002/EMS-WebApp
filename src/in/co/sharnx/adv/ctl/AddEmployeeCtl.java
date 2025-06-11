package in.co.sharnx.adv.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.sharnx.adv.bean.UserBean;
import in.co.sharnx.adv.model.UserModel;

@WebServlet("/AddEmployeeCtl")
public class AddEmployeeCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = (String) req.getParameter("id");
		System.out.println("data to update " + id);
		UserModel model = new UserModel();

		if (id != null) {

			try {
				UserBean bean = model.findByPk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
				System.out.println("bean from DB " + bean);

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		RequestDispatcher rd = req.getRequestDispatcher("AddEmployeeView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String deptName = req.getParameter("deptName");

		String op = req.getParameter("operation");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLoginId(loginId);
		bean.setPassword(password);
		bean.setPhone(phone);
		bean.setGender(gender);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setAddress(address);
		bean.setDeptName(deptName);

		UserModel model = new UserModel();

		if (op.equals("update")) {

			try {
				bean.setId(Integer.parseInt(req.getParameter("id")));
				model.update(bean);
				model.findByPk(bean.getId());
				req.setAttribute("bean", bean);
				req.setAttribute("msg", "Employee updated successfully...!!");

			} catch (Exception e) {
				req.setAttribute("msg", e.getMessage());
			}

		}

		if (op.equals("save")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "User Added Successfully..!!");
			} catch (Exception e) {
				req.setAttribute("msg", e.getMessage());
			}
		}
 		RequestDispatcher rd = req.getRequestDispatcher("AddEmployeeView.jsp");
		rd.forward(req, resp);
	}

}
