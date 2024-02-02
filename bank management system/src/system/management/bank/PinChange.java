package system.management.bank;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class PinChange extends JFrame implements ActionListener {

	JLabel imgJLabel, textJLabel, pintextJLabel, repintextJLabel;
	JPasswordField pinTextField, repinTextField;
	JButton changeButton, backButton;
	String pinnumString;

	public PinChange(String pinnumber) {
		this.pinnumString = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);

		imgJLabel = new JLabel(i3);
		imgJLabel.setBounds(0, 0, 900, 900);
		add(imgJLabel);

		textJLabel = new JLabel("CHANGE YOUR PIN");
		textJLabel.setForeground(Color.WHITE);
		textJLabel.setFont(new Font("System", Font.BOLD, 16));
		textJLabel.setBounds(250, 280, 500, 35);
		imgJLabel.add(textJLabel);

		pintextJLabel = new JLabel("New PIN: ");
		pintextJLabel.setForeground(Color.WHITE);
		pintextJLabel.setFont(new Font("System", Font.BOLD, 16));
		pintextJLabel.setBounds(165, 320, 180, 25);
		imgJLabel.add(pintextJLabel);

		pinTextField = new JPasswordField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
		pinTextField.setBounds(330, 320, 180, 25);
		imgJLabel.add(pinTextField);

		repintextJLabel = new JLabel("Re-Enter PIN: ");
		repintextJLabel.setForeground(Color.WHITE);
		repintextJLabel.setFont(new Font("System", Font.BOLD, 16));
		repintextJLabel.setBounds(165, 360, 180, 25);
		imgJLabel.add(repintextJLabel);

		repinTextField = new JPasswordField();
		repinTextField.setFont(new Font("System", Font.BOLD, 25));
		repinTextField.setBounds(330, 360, 180, 25);
		imgJLabel.add(repinTextField);

		changeButton = new JButton("CHANGE");
		changeButton.setBounds(355, 485, 150, 30);
		changeButton.addActionListener(this);
		imgJLabel.add(changeButton);

		backButton = new JButton("BACK");
		backButton.setBounds(355, 520, 150, 30);
		backButton.addActionListener(this);
		imgJLabel.add(backButton);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true); //For hide border of JFrame.
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == changeButton) {
			try {
				String newpinString = pinTextField.getText();
				String repinString = repinTextField.getText();

				if (!newpinString.equals(repinString)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}

				if (newpinString.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter New Pin");
					return;
				}

				if (repinString.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin");
					return;
				}

				ConnectionProvide con = new ConnectionProvide();
				// NOTE: pin filed is in 3 tables: login.signupthree,bank table. So we've to
				// chnage pin all those tables that's why we've to write 3 queries also.

				String queryOne = "UPDATE bank SET 	pin = '" + repinString + "' WHERE pin = '" + pinnumString + "'";
				String queryTwo = "UPDATE login SET pin = '" + repinString + "' WHERE pin = '" + pinnumString + "'";
				String queryThree = "UPDATE signupthree SET pinnumber = '" + repinString + "' WHERE pinnumber = '"
						+ pinnumString + "'";
				// In query after SET & before equals to sign you've to write name of column
				// which is in table.
				con.st.executeUpdate(queryOne);
				con.st.executeUpdate(queryTwo);
				con.st.executeUpdate(queryThree);

				JOptionPane.showMessageDialog(null, "PIN Chanes Successfully");
				setVisible(false);
				new Transactions(repinString).setVisible(true);
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error occur in PinChnage file in try-catch section");
			}
		}

		else {
			setVisible(false);
			new Transactions(pinnumString).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
