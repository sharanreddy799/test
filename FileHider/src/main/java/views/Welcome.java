package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import javax.security.auth.login.LoginContext;

import dao.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;

public class Welcome {
	public void welcomeScreen() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to the app");
		System.out.println("Press 1 for login");
		System.out.println("Press 2 for signup");
		System.out.println("press 0 for exit");

		int choice = 0;
		try {
			choice = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("error occur in Welcome file");
			e.printStackTrace();
		}

		switch (choice) {
		case 1:
			login();
			break;
		case 2:
			signup();
			break;
		case 0:
			System.exit(0);
			break;
		}
	}

	private void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email:");
		String email = sc.nextLine();
		try {
			if (UserDAO.isUserExists(email)) {
				String genOTP = GenerateOTP.getOTP(); // GenerateOTP is class & getOTP() method of it will generate otp.
				SendOTPService.sendOTP(email, genOTP); // otp will be send to user using sendOTP() method of
														// sendOTPSerivce class
				System.out.println("Enter the OTP:");
				String otp = sc.nextLine(); // it will take otp from user
				if (otp.equals(genOTP)) {
					// it will compare the otp of user has enter with the generated otp.
					System.out.println("welcome..");
					// object of UserFIleView is created because form here we pass value and in
					// constructor of userFileVIew Class we will save it.
					new UserFileView(email).home();

				} else {
					System.out.println("you have enterd incorrect otp");
				}

			}
//			else {
//				System.out.println("user does not exist...");
//			}
			else if (!UserDAO.isUserExists(email)) {
				System.out.println("user does not exist...");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void signup() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Name:");
		String name = scn.nextLine();
		System.out.println("Enter Email:");
		String email = scn.nextLine();
		// this is for check that user enter correct email or not
		String genOTP = GenerateOTP.getOTP();
		SendOTPService.sendOTP(email, genOTP);
		System.out.println("Enter the OTP:");
		String otp = scn.nextLine();
		if (otp.equals(genOTP)) {
			// it will create user
			User user = new User(name, email);
			int response = UserService.saveUser(user);
			switch (response) {
			case 0:
				System.out.println("User successfully registerd");
				break;

			case 1:
				System.out.println("User already exist");
				break;
			}
		} else {
			System.out.println("you have entered incorrect otp");
		}

	}

}
