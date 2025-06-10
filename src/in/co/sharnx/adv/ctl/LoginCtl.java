package in.co.sharnx.adv.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import in.co.sharnx.adv.bean.UserBean;
import in.co.sharnx.adv.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		if (op != null && op.equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();

		}
		resp.sendRedirect("LoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		if (op.equals("SignIn")) {
			System.out.println("In signIn");

			String loginId = req.getParameter("loginId");
			String password = req.getParameter("password");

			System.out.println(loginId);
			System.out.println(password);

			UserModel model = new UserModel();
			HttpSession session = req.getSession();
			try {
				UserBean bean = model.authenticate(loginId, password);
				if (bean != null) {
					session.setAttribute("bean", bean);
					resp.sendRedirect("WelcomeCtl");
				} else {
					resp.sendRedirect("LoginView.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (op.equals("SignUp")) {
			System.out.println("In signUp");
			resp.sendRedirect("RegistrationView.jsp");
		}

	}
}
