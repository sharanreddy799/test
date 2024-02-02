package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/filehiderdb", "root","dev@1234");

			if (con.isClosed()) {
				System.out.println("Connection is closed");
			} else {
				System.out.println("Connection successfull...");
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			System.out.println("Error occur in Myconnection database file");
		}
		return con;
	}

	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
