package JDBC;

import java.sql.*;
import java.util.*;

public class DemoDatabase {
	private static Properties properties = null;
	private static Scanner scanner = new Scanner(System.in);
	static {
		properties = new Properties();
		properties.put("JDBC_URL", "jdbc:mysql://localhost:3306/sampledb");
		properties.put("USER", "root");
		properties.put("PASSWORD", "root");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionFactory factory = ConnectionFactory.createConnection();
		Connection connection = factory.getConnection();
		PreparedStatement pst = null;
		int choiceid;
		do {
			System.out.println(
					"PRESS 1 FOR ADD\r\n" + "PRESS 2 FOR DELETE\r\n" + "PRESS 3 FOR UPDATE\r\n" + "PRESS 4 TO VIEW");
			System.out.print("ENTER YOUR CHOICE: ");
			choiceid = scanner.nextInt();
			switch (choiceid) {
			case 1:
				pst = connection.prepareStatement("insert into example values(?,?,?)");
				System.out.print("ID: ");
				int id = scanner.nextInt();
				System.out.print("NAME: ");
				String name = scanner.next();
				System.out.print("ORG: ");
				String org = scanner.next();
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setString(3, org);
				int count = pst.executeUpdate();
				System.out.println(count + " row(s) added");
				break;
			case 2:
				pst = connection.prepareStatement("DELETE from example where id=?");
				System.out.print("ID: ");
				int deleteid = scanner.nextInt();
				pst.setInt(1, deleteid);
				pst.executeUpdate();
				System.out.println("1 row(s) deleted");
				break;
			case 3:
				pst = connection.prepareStatement("UPDATE example SET name=?,org=? where id=?");
				System.out.print("ID: ");
				int updateid = scanner.nextInt();
				System.out.print("NAME: ");
				String updatename = scanner.next();
				System.out.print("ORG: ");
				String updateorg = scanner.next();
				pst.setString(1, updatename);
				pst.setString(2, updateorg);
				pst.setInt(3, updateid);
				pst.executeUpdate();
				System.out.println("1 row(s) updated");
				break;
			case 4:
				pst = connection.prepareStatement("select * from example");
				ResultSet resultset = pst.executeQuery("select * from example");
				System.out.println("id name org");
				while (resultset.next()) {
					System.out
							.println(resultset.getInt(1) + " " + resultset.getString(2) + " " + resultset.getString(3));
				}
			}
		} while (true);
	}

}
