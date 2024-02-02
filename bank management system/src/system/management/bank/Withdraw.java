package system.management.bank;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*; //util package is bcz we use Date().

public class Withdraw extends JFrame implements ActionListener {

	JTextField amounTextField;
	JButton withdrawButton, backButton;
	String pinno;

	public Withdraw(String pinnumber) {

		this.pinno = pinnumber;

		setLayout(null);

		ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

		Image atmImage = imgIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon imgIconTwo = new ImageIcon(atmImage);

		JLabel imgJLabel = new JLabel(imgIconTwo);
		imgJLabel.setBounds(0, 0, 900, 900);
		add(imgJLabel);

		JLabel textJLabel = new JLabel("Enter The Amount You Want To Withdraw:");
		textJLabel.setForeground(Color.WHITE);
		textJLabel.setFont(new Font("System", Font.BOLD, 16));
		textJLabel.setBounds(170, 300, 400, 20);
		imgJLabel.add(textJLabel);

		amounTextField = new JTextField();
		amounTextField.setFont(new Font("Raleway", Font.BOLD, 22));
		amounTextField.setBounds(170, 350, 320, 25);
		imgJLabel.add(amounTextField);

		withdrawButton = new JButton("Withdraw");
		backButton = new JButton("Back");

		withdrawButton.setBounds(355, 485, 150, 30);
		backButton.setBounds(355, 520, 150, 30);

		imgJLabel.add(withdrawButton);
		imgJLabel.add(backButton);

		withdrawButton.addActionListener(this);
		backButton.addActionListener(this);
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == withdrawButton) {
			String amountno = amounTextField.getText();
			Date date = new Date();
			if (amountno.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Amount you Want To Withdraw");
			} else {
				try {
					ConnectionProvide conn = new ConnectionProvide();

					String insQuery = "insert into bank values('" + pinno + "', '" + date + "','withdrawType', '"
							+ amountno + "')";
					conn.st.executeUpdate(insQuery);
					JOptionPane.showMessageDialog(null, "Rs" + amountno + " Withdraw Successfully");
					setVisible(false);
					new Transactions(pinno).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error Occur in Deposit file database section of bank table");
				}
			}

		} else if (ae.getSource() == backButton) {
			setVisible(false);
			new Transactions(pinno).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Withdraw("");
	}
}
