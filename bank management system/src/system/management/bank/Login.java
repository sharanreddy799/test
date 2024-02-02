package system.management.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
	JTextField cardTextField;
	JButton loginBtn, clearBtn, signupBtn;
	JPasswordField cardPinField;

	public Login() {
		setTitle("AUTOMATED TELLER MACHINE");

		setLayout(null);
		// for set logo as per our custom layout because bydefault swing provide border
		// layout which will set image in center but i want my logo on top left of frame
		// so for apply our custom layout you;ve to set layout ot 0.

		ImageIcon iOneIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		// Imageicon for for get the image, then for set image(means for change scaleof
		// image) as per our requirement we have to use Image then again we'll convert
		// this image into imageicon because for show image we've to compulsoury pass
		// into JLabel and in JLabel we cannot pass Image we can oly pass ImageIcon so
		// due to this we've to convert Image into ImageIcon
		Image img = iOneIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		// (width,height,scale of image);
		ImageIcon iTwoIcon = new ImageIcon(img);
		JLabel label = new JLabel(iTwoIcon);
		label.setBounds(70, 10, 100, 100); // (position from left,position from top,width,height)
		add(label);

		JLabel text = new JLabel("Welcome to ATM");
		JLabel cardno = new JLabel("Card No. :");
		
		text.setFont(new Font("Osward", Font.BOLD, 38));
		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
		
		text.setBounds(200, 40, 400, 40);
		cardno.setBounds(120, 150, 150, 30);

		add(text);
		add(cardno);


		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(120, 220, 250, 30);
		add(pin);

		cardPinField = new JPasswordField();
		cardPinField.setBounds(300, 220, 230, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardPinField);

		loginBtn = new JButton("SIGN IN");
		clearBtn = new JButton("CLEAR");
		signupBtn = new JButton("SIGN UP");
		loginBtn.setBounds(300, 300, 100, 30);
		clearBtn.setBounds(430, 300, 100, 30);
		signupBtn.setBounds(300, 350, 230, 30);

		loginBtn.setBackground(Color.BLACK);
		clearBtn.setBackground(Color.BLACK);
		signupBtn.setBackground(Color.BLACK);

		loginBtn.setForeground(Color.WHITE);
		clearBtn.setForeground(Color.WHITE);
		signupBtn.setForeground(Color.WHITE);

		loginBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		signupBtn.addActionListener(this);

		add(loginBtn);
		add(clearBtn);
		add(signupBtn);

		getContentPane().setBackground(Color.WHITE);

		setSize(800, 480); // set (width,height) of frame
		setVisible(true);
		setLocation(350, 200);
		// (from left,from top):default origiin is form topleft so to make it center
		// apply value from left & top

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearBtn) {
			cardTextField.setText("");
			cardPinField.setText("");
		} else if (e.getSource() == loginBtn) {
			ConnectionProvide con = new ConnectionProvide();
			String cardnumber = cardTextField.getText();
			String pinnumber = cardPinField.getText();
			// above variable field we've to match with the login table's field
			String query = "select * from login where cardno = '" + cardnumber + "' and pin='" + pinnumber + "'";

			try {
				ResultSet rset = con.st.executeQuery(query);
				if (rset.next()) {
					setVisible(false);
					// by set to false the login frame will get close and then transaction frame
					// will be display by creating object of transaction class.
					new Transactions(pinnumber).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Error in your login file in database part");
			}
		} else if (e.getSource() == signupBtn) {
			setVisible(false);
			new SignUp().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Login();
	}

}
