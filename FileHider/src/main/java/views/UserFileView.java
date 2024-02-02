package views;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Data;
import dao.DataDAO;

public class UserFileView {

	private String email;

	// constructor created which take email as arguments form Welcome.java file
	UserFileView(String email) {
		this.email = email; // right side valu email e parameter value email hee
	}

	public void home() {
		do {
			System.out.println("Welcome" + this.email);
			System.out.println("Press 1 to show already hidden files");
			System.out.println("Press 2 for hide a new file");
			System.out.println("press 3 for unhide a file");
			System.out.println("Press 0 for exit");

			Scanner sc = new Scanner(System.in);
			int ch = Integer.parseInt(sc.nextLine());
			switch (ch) {
			case 1:
				// case 1 for show files
				try {

					List<Data> files = DataDAO.getAllFiles(this.email);
					System.out.println("ID - File Name");
					for (Data dfile : files) {
						System.out.println(dfile.getId() + " - " + dfile.getFileName());
					}
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error occur in case 1 of UserFileVIew class file");
				}
				break;

			case 2:
				// case 2 for hide a new file
				try {

					System.out.println("Enter the file path:");
					String path = sc.nextLine();
					File f = new File(path);
					Data fileData = new Data(0, f.getName(), path, this.email);
					DataDAO.hideFile(fileData);
					System.out.println("Your file added successfully in db");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error occur in case 2 of UserFileVIew class file -sql exception");

				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Error occur in case 2 of UserFileVIew class file- IO exception");

				}
				break;

			case 3:
				List<Data> files = null;
				try {
					files = DataDAO.getAllFiles(this.email);

					System.out.println("ID - File Name");
					for (Data file : files) {
						System.out.println(file.getId() + " - " + file.getFileName());
					}
					System.out.println("Enter the id of file to unhide");
					int id = Integer.parseInt(sc.nextLine());
					boolean isValidID = false;
					for (Data file : files) {
						if (file.getId() == id) {
							isValidID = true;
							break;
						}
					}
					if (isValidID) {
						DataDAO.unhide(id);
					} else {
						System.out.println("You have enter Wrong ID for unhide file");
					}
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error occur in case 3 of UserFileVIew class file -sql exception");

				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Error occur in case 3 of UserFileVIew class file- IO exception");
				}
				break;

			case 4:
				System.exit(0);
				break;
			}
		} while (true);
	}
}
