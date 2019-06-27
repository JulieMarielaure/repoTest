package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public abstract class MyConnexion {

	static String url = "jdbc:mysql://localhost:3306/test_db?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	static String user = "root";
	static String password = "root";
	

	public static DefaultTableModel getData() {

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("id_login");
		dm.addColumn("user_name");
		dm.addColumn("password");

		try {

			String sql = "select * from tb_login";

			Connection connect= DriverManager.getConnection(url, user, password);
			Statement myStmt = connect.prepareStatement(sql);
			ResultSet rst = myStmt.executeQuery(sql);
			dm.setRowCount(0);

			while (rst.next()) {
				String id_login = rst.getString(1);
				String user_name = rst.getString(2);
				String password = rst.getString(3);

				Object[] rowData = { id_login, user_name, password };
				dm.addRow(rowData);
			}

			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dm;
	}

	public static DefaultTableModel getDataSelect() {

		System.out.println("methode1");
		int id_login = 1;
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("id_login");
		dm.addColumn("user_name");
		dm.addColumn("password");

		String sql = "Select * from tb_login where id_login='"+id_login+"'";
		String url = "jdbc:mysql://localhost:3306/test_db?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		String user = "root";
		String passwordAll = "root";

		try {

			Connection con = DriverManager.getConnection(url, user, passwordAll);
			Statement myStmt = con.prepareStatement(sql);
			ResultSet rst = myStmt.executeQuery(sql);
			System.out.println(rst);
			dm.setRowCount(0);
			while (rst.next()) {
				String id_login1 = rst.getString(1);
				String user_name = rst.getString(2);
				String password = rst.getString(3);

				Object[] rowData = { id_login1, user_name, password };
				dm.addRow(rowData);
			}

			return dm;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
