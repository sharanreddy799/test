package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MyConnection;
import model.User;

public class UserDAO {
	// If user exist then it will check email with db using below isUserExist()
	// method and if user does not exist then insertUser() method will run which will insert data of user in database.

	public static boolean isUserExists(String email) throws SQLException {
		Connection connection = MyConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("select email from users");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String e = rs.getString(1);
			if (e.equals(email)) {
				return true;
			}

		}
		return false;
	}

	public static int insertUser(User user) throws SQLException {
		Connection connection = MyConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("insert into users values(default,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		return ps.executeUpdate();
	}
}
