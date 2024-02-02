package system.management.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionProvide {

	Connection con;
	Statement st;

	public ConnectionProvide() {
		try {
			// Step 1 : Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Create COnnection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "dev@1234");
			
			//create statement
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occur in database file");
		}

	}

}
