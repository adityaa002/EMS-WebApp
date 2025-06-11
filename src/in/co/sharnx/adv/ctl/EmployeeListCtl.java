package in.co.sharnx.adv.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.sharnx.adv.bean.UserBean;
import in.co.sharnx.adv.model.UserModel;

@WebServlet("/EmployeeListCtl")
public class EmployeeListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo = 1;
		int pageSize = 10;

		UserModel model = new UserModel();
		UserBean bean = null;

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("EmployeeListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo = 1;
		int pageSize = 10;

		UserModel model = new UserModel();
		UserBean bean = null;

		String op = req.getParameter("operation");
		pageNo = Integer.parseInt(req.getParameter("pageNo"));
		if (op.equals("previous")) {
			pageNo--;
		}
		if (op.equals("add")) {
			resp.sendRedirect("AddEmployeeCtl");
		}
		if (op.equals("next")) {
			pageNo++;
		}
		if (op.equals("delete")) {
			pageNo = 1;

			String[] ids = req.getParameterValues("ids");

			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					try {
						model.delete(Integer.parseInt(id));

					} catch (Exception e) {
					}
				}
				req.setAttribute("msg", "Record deleted successfully...!!");

			} else {
				req.setAttribute("msg", "Please select atleast 1 record..!!");
			}

		}

		if (op.equals("search")) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			pageNo = 1;
			bean = new UserBean();
			bean.setFirstName(req.getParameter("firstName"));
			try {
				bean.setDob(sdf.parse(req.getParameter("dob")));
				
 			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (op.equals("edit")) {

			resp.sendRedirect("LoginView.jsp");
		}

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("EmployeeListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}