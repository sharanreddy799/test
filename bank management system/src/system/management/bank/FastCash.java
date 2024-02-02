package system.management.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date; //for Date()
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

public class FastCash extends JFrame implements ActionListener {

	JButton rs100Button, rs500Button, rs1000Button, rs2000Button, rs5000Button, rs10000Button, backButton;

	String pinnum;

	// Constructor created
	public FastCash(String pinnumber) {
		this.pinnum = pinnumber;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel imageJLabel = new JLabel(i3);
		imageJLabel.setBounds(0, 0, 900, 900); // from x position,from y position,width,height.
		add(imageJLabel);

		JLabel textJLabel = new JLabel("SELECT WITHDRAWL AMOUNT");
		textJLabel.setBounds(210, 300, 700, 35);
		textJLabel.setForeground(Color.WHITE);
		textJLabel.setFont(new Font("system", Font.BOLD, 16));
		imageJLabel.add(textJLabel);
		// add() will set this label on Jframe but due to image alredy there it'll get
		// hide behind image so for show text on image we've to call add()function with
		// that image.

		rs100Button = new JButton("Rs 100");
		rs500Button = new JButton("Rs500");
		rs1000Button = new JButton("Rs 1000");
		rs2000Button = new JButton("Rs 2000");
		rs5000Button = new JButton("Rs 5000");
		rs10000Button = new JButton("Rs 10000");
		backButton = new JButton("BACK");

		rs100Button.setBounds(170, 415, 150, 30);
		rs500Button.setBounds(355, 415, 150, 30);
		rs1000Button.setBounds(170, 450, 150, 30);
		rs2000Button.setBounds(355, 450, 150, 30);
		rs5000Button.setBounds(170, 485, 150, 30);
		rs10000Button.setBounds(355, 485, 150, 30);
		backButton.setBounds(355, 520, 150, 30);

		imageJLabel.add(rs100Button);
		imageJLabel.add(rs500Button);
		imageJLabel.add(rs1000Button);
		imageJLabel.add(rs2000Button);
		imageJLabel.add(rs5000Button);
		imageJLabel.add(rs10000Button);
		imageJLabel.add(backButton);

		rs100Button.addActionListener(this);
		rs500Button.addActionListener(this);
		rs1000Button.addActionListener(this);
		rs2000Button.addActionListener(this);
		rs5000Button.addActionListener(this);
		rs10000Button.addActionListener(this);
		backButton.addActionListener(this);

		setSize(900, 900);
		setLocation(300, 0);
		// for hide the border of jframe we can use setUndecorated(true) so now only
		// image will be there.
		setUndecorated(true);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			setVisible(false);
			new Transactions(pinnum).setVisible(true);
		} else {
			String amountString = ((JButton) e.getSource()).getText().substring(3);
			// getsource() return objectButton so we've to typecast in JButton and
			// subString() is used because getText() will give like this:Rs 500 ,so we have
			// to remove character & only take digits from it.

			ConnectionProvide connect = new ConnectionProvide();
			try {
				ResultSet rsResultset = connect.st.executeQuery("select * from bank where pin = '" + pinnum + "'");
				int balance = 0;
				while (rsResultset.next()) {
					if (rsResultset.getString("transactionType").equals("depositType")) {
						balance += Integer.parseInt(rsResultset.getString("amount"));
					} else {
						balance -= Integer.parseInt(rsResultset.getString("amount"));
					}
					//Note: Here inside bracket of geString name of column which is in that table will be written here.Here our table is : bank
				}

				if (e.getSource() != backButton && balance < Integer.parseInt(amountString)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}

				Date date = new Date();
				String query = "insert into bank values('" + pinnum + "', '" + date + "' , 'withdrawl', '"
						+ amountString + "')";
				connect.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "RS" + amountString + "Debited Successfully");

				setVisible(false);
				new Transactions(pinnum).setVisible(true);

			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Error occur in FastCash file in databse part");
			}
		}
	}

	public static void main(String[] args) {
		new FastCash("");
	}

}
