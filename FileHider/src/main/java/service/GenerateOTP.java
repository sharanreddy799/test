package service;

import java.util.Random;

public class GenerateOTP {
	public static String getOTP() {
		// for generate 4 digit format()method is used
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));

	}
}
