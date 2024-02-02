package service;

import java.sql.SQLException;

import dao.UserDAO;
import model.User;

public class UserService {
	public static Integer saveUser(User user) {
		try {
			if (UserDAO.isUserExists(user.getEmail())) {
				// if user exists then return 0
				return 0;
			} else {
				UserDAO.insertUser(user);
				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}
}
