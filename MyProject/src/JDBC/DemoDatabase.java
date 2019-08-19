package JDBC;
import java.sql.*;
import java.util.*;
public class DemoDatabase {
	private static Properties properties = null;
	private static Scanner scanner=new Scanner(System.in);
	static {
		properties = new Properties();
		properties.put("JDBC_URL", "jdbc:mysql://localhost:3306/sampledb");
		properties.put("USER", "root");
		properties.put("PASSWORD", "root");
	}
	public static void getDatabase(PreparedStatement pst)throws ClassNotFoundException, SQLException  {
		ResultSet resultset = pst.executeQuery("select * from example");
		System.out.println("id name org");
		while(resultset.next()) {
			System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3));
		}}	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	ConnectionFactory factory=ConnectionFactory.createConnection();
	Connection connection=factory.getConnection();
	System.out.print("CHOICE: ");
	int choiceid=scanner.nextInt();
	switch(choiceid){
	case 1:PreparedStatement pst=connection.prepareStatement("insert into example values(?,?,?)");
	System.out.print("ID: ");
	int id=scanner.nextInt();
	System.out.print("NAME: ");
	String name=scanner.next();
	System.out.print("ORG: ");
	String org=scanner.next();
	pst.setInt(1, id);
	pst.setString(2, name);
	pst.setString(3, org);
    int count=pst.executeUpdate();
	System.out.println(count+" row(s) updated");
	getDatabase(pst);
	case 2:pst = connection.prepareStatement("DELETE from example where id=?");
	System.out.print("ID: ");
	int deleteid=scanner.nextInt();
	pst.setInt(1, deleteid);
	pst.executeUpdate();
	System.out.println("1 row(s) deleted");
	getDatabase(pst);
}}
}

