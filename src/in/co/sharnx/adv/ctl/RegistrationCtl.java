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

@WebServlet("/RegistrationCtl")
public class RegistrationCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("RegistrationView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("lastName");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String deptName = req.getParameter("deptName");

		System.out.println(firstName);

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

		if (op.equals("Submit")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "Registration successfull...!!");
			} catch (Exception e) {
				req.setAttribute("msg", e.getMessage());

			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("RegistrationView.jsp");
		rd.forward(req, resp);
	}
}
