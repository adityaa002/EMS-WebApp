package in.co.sharnx.adv.model;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.sharnx.adv.bean.UserBean;

public class TestModel {
	public static void main(String[] args) throws Exception {
		// user.nextPk();
		// testAdd();
		// testUpdate();
		// testDelete();
		testFindByPk();
		// testFindByLogin();
		// testSearch();
		// testAuth();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserBean bean = new UserBean();
		bean.setFirstName("admin");
		bean.setLastName("admin");
		bean.setLoginId("admin");
		bean.setPassword("admin");
		bean.setPhone("admin");
		bean.setGender("admin");
		bean.setDob(sdf.parse("12/12/12"));
		bean.setAddress("admin");
		bean.setDeptName("admin");

		UserModel model = new UserModel();
		model.add(bean);
	}

	public static void testUpdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserBean bean = new UserBean();

		bean.setFirstName("aditya");
		bean.setLastName("sharma");
		bean.setLoginId("aditya002@gmail.com");
		bean.setPassword("furi@x");
		bean.setPhone("1234567");
		bean.setGender("male");
		try {
			bean.setDob(sdf.parse("12/12/12"));
		} catch (ParseException e) {
			e.getMessage();
		}
		bean.setAddress("indore");
		bean.setDeptName("dev");
		bean.setId(1);

		UserModel model = new UserModel();
		model.update(bean);

	}

	public static void testDelete() {
		UserModel model = new UserModel();
		model.delete(1);

	}

	public static void testFindByPk() throws Exception {

		UserModel.findByPk(10);
	}

	public static void testFindByLogin() throws SQLException {
		UserModel.findByLogin("saanvi.khan@gmail.com");
	}

	public static void testSearch() throws Exception {
		UserBean bean = new UserBean();
		List list = UserModel.search(bean, 4, 1);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.println("\t" + bean.getFirstName());
		}

	}

	public static void testAuth() throws Exception {
		UserModel.authenticate("aditya.rai@gmail.com", "Adi@0001");
	}
}
