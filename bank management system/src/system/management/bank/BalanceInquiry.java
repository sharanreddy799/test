package system.management.bank;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class BalanceInquiry extends JFrame implements ActionListener {
	JButton backButton;
	String pinchange;

	public BalanceInquiry(String pinchange) {
		this.pinchange = pinchange;
		// right side is which pass in constructor & left side is variable declare above
		// constructor.

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel imgJLabel = new JLabel(i3);
		imgJLabel.setBounds(0, 0, 900, 900);
		add(imgJLabel);

		backButton = new JButton("BACK");
		backButton.setBounds(355, 520, 150, 30);
		backButton.addActionListener(this);
		imgJLabel.add(backButton);

		// NOTE: Here in constructor I've created connection because I donot want to
		// show balance on button click ,I want to show balance when frame get open.
		ConnectionProvide connect = new ConnectionProvide();
		int balance = 0;
		try {
			ResultSet rsResultset = connect.st.executeQuery("select * from bank where pin = '" + pinchange + "'");
			while (rsResultset.next()) {
				if (rsResultset.getString("transactionType").equals("depositType")) {
					balance += Integer.parseInt(rsResultset.getString("amount"));
				} else {
					balance -= Integer.parseInt(rsResultset.getString("amount"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occur in FastCash file in databse part");
		}

		JLabel textJLabel = new JLabel("Your Current Account Balance is Rs " + balance);
		textJLabel.setForeground(Color.WHITE);
		textJLabel.setBounds(170, 300, 400, 30);
		imgJLabel.add(textJLabel);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transactions(pinchange).setVisible(true);

	}

	public static void main(String[] args) {
		new BalanceInquiry("").setVisible(true);
	}

}
