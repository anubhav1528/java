package parentPackage.testPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class OracleCon {
	public static void main(String args[]) {
		try {
//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object  
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:xe", "system", "root");

//step3 create the statement object  
			PreparedStatement pStmt = null;
//step4 execute query 
			pStmt = con.prepareStatement("create table sampleTable (id int,data varchar(255))");
			pStmt.execute();
			pStmt = con.prepareStatement("insert into sampleTable values(?,?)");
			pStmt.setInt(1, 1);
			pStmt.setString(2, "Testing Successful");
			pStmt.executeUpdate();
			ResultSet rs = pStmt.executeQuery("select * from sampleTable");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			pStmt = con.prepareStatement("drop table sampleTable");
            pStmt.execute();
//step5 close the connection object  
            rs.close();
            pStmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}