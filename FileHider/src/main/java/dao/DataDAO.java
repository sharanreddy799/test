package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.MyConnection;
import model.Data;

//this dataDAO is for show,hide,unhide files
public class DataDAO {

	// METHOD 1: This method for show all files
	public static List<Data> getAllFiles(String email) throws SQLException {
		Connection conn = MyConnection.getConnection();
		PreparedStatement ptst = conn.prepareStatement("select * from data where email =?");
		ptst.setString(1, email);
		ResultSet rs = ptst.executeQuery();
		List<Data> files = new ArrayList<Data>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String path = rs.getString(3);
			files.add(new Data(id, name, path));

		}
		return files;
	}

	// METHOD 2: This method for save file in db
	public static int hideFile(Data myFile) throws SQLException, IOException, FileNotFoundException {
		Connection con = MyConnection.getConnection();
		PreparedStatement pt = con
				.prepareStatement("insert into data(fileName,path,email,binary_data) values (?,?,?,?)");
		pt.setString(1, myFile.getFileName());
		pt.setString(2, myFile.getPath());
		pt.setString(3, myFile.getEmail());
		File f = new File(myFile.getPath());
		FileReader fr = new FileReader(f);
		pt.setCharacterStream(4, fr, f.length());
		int ans = pt.executeUpdate();
		fr.close();
		f.delete();
		// here delete() method will first save character representation in database and
		// when we'll unhide file at that time we'll create new file and take data form
		// database and paste in this new file.

		return ans;

	}

	// METHOD 3: This method for unhide file
	public static void unhide(int id) throws SQLException, IOException {
		Connection con = MyConnection.getConnection();
		PreparedStatement pt = con.prepareStatement("select path,binary_data from data where id = ?");
		pt.setInt(1, id);
		ResultSet rs = pt.executeQuery();
		rs.next();
		// here in below we can either pass column index or column label.
//        String path = rs.getString(1);
//        Clob c = (Clob) rs.getClob(5);
		String path = rs.getString("path");
		Clob c = rs.getClob("binary_data"); // clob means character large object
		Reader r = c.getCharacterStream();
		FileWriter fw = new FileWriter(path);
		int i;
		// read character from databse till character is equal to -1.AND Here i have
		// stored in "i" variable because otherwise it will read 1 character then print
		// 1 character,again another character read&print it but for not let this happen
		// we are saving each character in database
		while ((i = r.read()) != -1) {
			// it will give use data in ASCII form so we've to cinvert them in character
			fw.write((char) i);
		}
		fw.close();
		// after taking that row data form db we've to delete that also so for that
		// we'll delete it and new file will save with that row data.
		pt = con.prepareStatement("delete from data where id = ?");
		pt.setInt(1, id);
		pt.executeUpdate();
		System.out.println("Successfully Unhidden");

	}

}
