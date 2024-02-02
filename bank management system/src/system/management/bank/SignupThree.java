package system.management.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submitBtn, cancelBtn;
	String formnum;

	// CONSTRUCTOR
	SignupThree(String formno) {
		this.formnum = formno;

		setLayout(null);

		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", getFont().BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);

		JLabel accType = new JLabel("Account Type:");
		accType.setFont(new Font("Raleway", getFont().BOLD, 22));
		accType.setBounds(100, 140, 200, 30);
		add(accType);

		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100, 180, 150, 20);
		add(r1);

		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 180, 250, 20);
		add(r2);

		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD, 16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100, 220, 250, 20);
		add(r3);

		r4 = new JRadioButton("Recurring Account");
		r4.setFont(new Font("Raleway", Font.BOLD, 16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350, 220, 250, 20);
		add(r4);

		ButtonGroup groupaccButtonGroup = new ButtonGroup();
		groupaccButtonGroup.add(r1);
		groupaccButtonGroup.add(r2);
		groupaccButtonGroup.add(r3);
		groupaccButtonGroup.add(r4);

		JLabel cardNum = new JLabel("Card Number:");
		cardNum.setFont(new Font("Raleway", getFont().BOLD, 22));
		cardNum.setBounds(100, 300, 200, 30);
		add(cardNum);

		JLabel number = new JLabel("xxxx-xxxx-xxxx-1234");
		number.setFont(new Font("Raleway", getFont().BOLD, 22));
		number.setBounds(330, 300, 300, 30);
		add(number);

		JLabel numberDetail = new JLabel("Your 16 Digit Card Number");
		numberDetail.setFont(new Font("Raleway", getFont().BOLD, 12));
		numberDetail.setBounds(100, 330, 300, 20);
		add(numberDetail);

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", getFont().BOLD, 22));
		pin.setBounds(100, 370, 200, 30);
		add(pin);

		JLabel pinNumber = new JLabel("xxxx");
		pinNumber.setFont(new Font("Raleway", getFont().BOLD, 22));
		pinNumber.setBounds(330, 370, 300, 30);
		add(pinNumber);

		JLabel pinDetail = new JLabel("Your 4 Digit Password");
		pinDetail.setFont(new Font("Raleway", getFont().BOLD, 12));
		pinDetail.setBounds(100, 400, 300, 20);
		add(pinDetail);

		JLabel service = new JLabel("Services Required:");
		service.setFont(new Font("Raleway", getFont().BOLD, 22));
		service.setBounds(100, 450, 400, 30);
		add(service);

		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBounds(100, 500, 200, 30);
		add(c1);

		c2 = new JCheckBox("INTERNET BANKING");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBounds(350, 500, 200, 30);
		add(c2);

		c3 = new JCheckBox("MOBILE NAKING");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBounds(100, 550, 200, 30);
		add(c3);

		c4 = new JCheckBox("EMAIL & SMS aLERTS");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBounds(350, 550, 200, 30);
		add(c4);

		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBounds(100, 600, 200, 30);
		add(c5);

		c6 = new JCheckBox("E statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBounds(350, 600, 200, 30);
		add(c6);

		c7 = new JCheckBox("Hereby declares that the above entered details are correct to the best of my knowledge ");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBounds(100, 680, 600, 30);
		add(c7);

		submitBtn = new JButton("Submit");
		submitBtn.setBackground(Color.BLACK);
		submitBtn.setForeground(Color.WHITE);
		submitBtn.setFont(new Font("Raleway", Font.BOLD, 14));
		submitBtn.setBounds(250, 720, 100, 30);
		add(submitBtn);
		submitBtn.addActionListener(this);

		cancelBtn = new JButton("Submit");
		cancelBtn.setBackground(Color.BLACK);
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("Raleway", Font.BOLD, 14));
		cancelBtn.setBounds(420, 720, 100, 30);
		add(cancelBtn);
		cancelBtn.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setSize(850, 820);
		setLocation(350, 0);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submitBtn) {
			String accountType = null;
			if (r1.isSelected()) {
				accountType = "Saving Account";
			} else if (r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			} else if (r3.isSelected()) {
				accountType = "Current Account";
			} else if (r4.isSelected()) {
				accountType = "Recurring Deposit Account";
			}

			Random random = new Random();
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

			String facility = "";
			if (c1.isSelected()) {
				facility = facility + "ATM Card";
			} else if (c2.isSelected()) {
				facility = facility + "Internet Banking";
			} else if (c3.isSelected()) {
				facility = facility + "Mobile Banking";
			} else if (c4.isSelected()) {
				facility = facility + "Email & SMS Alerts";
			} else if (c5.isSelected()) {
				facility = facility + "Cheque Book";
			} else if (c6.isSelected()) {
				facility = facility + "E Statement";
			}

			try {
				if (accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				} else {
					ConnectionProvide con = new ConnectionProvide();
					String queryOne = "insert into signupthree values('" + formnum + "','" + accountType + "','"
							+ cardnumber + "','" + pinnumber + "','" + facility + "')";
//					"Syntax of how variable is concate with query :-> string'+"variable_field"+'string"

					String queryTwo = "insert into login values('" + formnum + "','" + cardnumber + "','" + pinnumber
							+ "')";
					con.st.executeUpdate(queryOne);
					con.st.executeUpdate(queryTwo);

					JOptionPane.showMessageDialog(null, "Card Number " + cardnumber + "\n Pin Number " + pinnumber);
				}
				setVisible(false);
				new Deposit(pinnumber).setVisible(false);

			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Error occur in signupThree file");
			}

		} else if (e.getSource() == cancelBtn) {
			setVisible(false);
			new Login().setVisible(true);
		}

	}

	public static void main(String[] args) {
		new SignupThree("");
	}
}
