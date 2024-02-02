package system.management.bank;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

	public MiniStatement(String pinnumber) {

		setTitle("Mini Statement");

		setLayout(null);

		JLabel ministatementJLabel = new JLabel();
		ministatementJLabel.setBounds(20, 140, 400, 200);
		add(ministatementJLabel);

		JLabel bankJLabel = new JLabel("RBI Bank");
		bankJLabel.setBounds(150, 20, 100, 20);
		add(bankJLabel);

		JLabel cardJLabel = new JLabel();
		cardJLabel.setBounds(20, 80, 300, 20);
		add(cardJLabel);

		JLabel balanceJLabel = new JLabel();
		balanceJLabel.setBounds(20, 400, 300, 20);
		add(balanceJLabel);

		try {
			ConnectionProvide con = new ConnectionProvide();
			ResultSet rSet = con.st.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
			while (rSet.next()) {
				cardJLabel.setText("Card Number: " + rSet.getString("cardno").substring(0, 4) + "xxxxxxxx"
						+ rSet.getString("cardno").substring(12));
				// cardno is name of column which is in login table.Note: card number 16 digit
				// no hoy che.
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in MiniStatemetn file in try-catch section");
		}

		// Below try..catch is for display how many transaction has been occur of user.
		try {
			ConnectionProvide conn = new ConnectionProvide();

			int userBalance = 0;

			ResultSet rs = conn.st.executeQuery("select * from bank where pin = '" + pinnumber + "'");

			while (rs.next()) {
				// NOTE: Here we'll display data of bank table (like this: date - transaction -
				// amount) for that we can do it by appending string as shown in setText().
				// NOTE: setText() override the text so for append text i'll first getText& then
				// append another text to it.
				ministatementJLabel.setText(ministatementJLabel.getText() + "<html>" + rs.getString("date")
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transactionType")
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

				if (rs.getString("transactionType").equals("depositType")) {
					userBalance += Integer.parseInt(rs.getString("amount"));
				} else {
					userBalance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balanceJLabel.setText("Your Current Account Balance is Rs " + userBalance);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occur in second try..catch code of MiniStatement file");
		}
		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new MiniStatement("");
	}
}
