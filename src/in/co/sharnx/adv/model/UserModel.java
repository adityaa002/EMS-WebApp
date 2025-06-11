package in.co.sharnx.adv.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.sharnx.adv.bean.UserBean;
import in.co.sharnx.adv.util.JDBCDataSource;

public class UserModel {

	public static Integer nextPk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from employee");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		JDBCDataSource.closeConnection(conn);

		System.out.println(pk + 1);
		return pk + 1;

	}

	public static void add(UserBean bean) {
		Connection conn = JDBCDataSource.getConnection();
		try {

			PreparedStatement pstmt = conn.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getPhone());
			pstmt.setString(7, bean.getGender());
			pstmt.setDate(8, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(9, bean.getAddress());
			pstmt.setString(10, bean.getDeptName());

			int i = pstmt.executeUpdate();
			System.out.println("data insertion success_______" + i);

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		JDBCDataSource.closeConnection(conn);

	}

	public static void update(UserBean bean) {

		Connection conn = JDBCDataSource.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"update employee set first_name = ?, last_name = ? , login_id = ? , password = ? ,"
							+ "phone= ?, gender = ? , dob = ? , address = ? , dept_name = ? where id = ? ");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLoginId());
			pstmt.setString(4, bean.getPassword());
			pstmt.setString(5, bean.getPhone());
			pstmt.setString(6, bean.getGender());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(8, bean.getAddress());
			pstmt.setString(9, bean.getDeptName());
			pstmt.setInt(10, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println("Data Update success...!!!_____" + i);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCDataSource.closeConnection(conn);

	}

	public static void delete(int id) {
		Connection conn = JDBCDataSource.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from employee where id=?");
			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();
			JDBCDataSource.closeConnection(conn);
			System.out.println("record deleted success_____" + i);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		JDBCDataSource.closeConnection(conn);
	}

	public static UserBean findByPk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from employee where id = ?");
		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhone(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setDob(rs.getDate(8));
			bean.setAddress(rs.getString(9));
			bean.setDeptName(rs.getString(10));

		}
		JDBCDataSource.closeConnection(conn);
		return bean;

	}

	public static UserBean findByLogin(String loginId) throws SQLException {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from employee where login_id = ?");
		pstmt.setString(1, loginId);
		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhone(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setDob(rs.getDate(8));
			bean.setAddress(rs.getString(9));
			bean.setDeptName(rs.getString(10));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public static List search(UserBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from employee where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and first_name like '" + bean.getFirstName() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		System.out.println("your query : " + sql);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();
		ArrayList list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhone(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setDob(rs.getDate(8));
			bean.setAddress(rs.getString(9));
			bean.setDeptName(rs.getString(10));
			list.add(bean);

		}
		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public static UserBean authenticate(String loginId, String password) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from employee where login_id = ? and password = ?");

		pstmt.setString(1, loginId);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhone(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setDob(rs.getDate(8));
			bean.setAddress(rs.getString(9));
			bean.setDeptName(rs.getString(10));

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.print("\t" + rs.getString(7));
			System.out.print("\t" + rs.getString(8));
			System.out.print("\t" + rs.getString(9));
			System.out.println("\t" + rs.getString(10));

		}
		System.out.println("Authenticating user: " + loginId);

		JDBCDataSource.closeConnection(conn);
		return bean;

	}
}
