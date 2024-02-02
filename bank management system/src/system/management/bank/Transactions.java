package system.management.bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

	JButton depositButton, withdrawButton, fastcashButton, ministatementButton, pinchangeButton, balanceinquiryButton,
			exitButton;

	String pinnum;

	// Constructor created
	public Transactions(String pinnumber) {
		this.pinnum = pinnumber;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel imageJLabel = new JLabel(i3);
		imageJLabel.setBounds(0, 0, 900, 900); // from x position,from y position,width,height.
		add(imageJLabel);

		JLabel textJLabel = new JLabel("Please Select Your Transaction");
		textJLabel.setBounds(210, 300, 700, 35);
		textJLabel.setForeground(Color.WHITE);
		textJLabel.setFont(new Font("system", Font.BOLD, 16));
		imageJLabel.add(textJLabel);
		// add() will set this label on Jframe but due to image alredy there it'll get
		// hide behind image so for show text on image we've to call add()function with
		// that image.

		depositButton = new JButton("Deposit");
		withdrawButton = new JButton("Cash Withdrawl");
		fastcashButton = new JButton("Fast Cash");
		ministatementButton = new JButton("Mini Statement");
		pinchangeButton = new JButton("Pin Change");
		balanceinquiryButton = new JButton("Balance Inquiry");
		exitButton = new JButton("Exit");

		depositButton.setBounds(170, 415, 150, 30);
		withdrawButton.setBounds(355, 415, 150, 30);
		fastcashButton.setBounds(170, 450, 150, 30);
		ministatementButton.setBounds(355, 450, 150, 30);
		pinchangeButton.setBounds(170, 485, 150, 30);
		balanceinquiryButton.setBounds(355, 485, 150, 30);
		exitButton.setBounds(355, 520, 150, 30);

		imageJLabel.add(depositButton);
		imageJLabel.add(withdrawButton);
		imageJLabel.add(fastcashButton);
		imageJLabel.add(ministatementButton);
		imageJLabel.add(pinchangeButton);
		imageJLabel.add(balanceinquiryButton);
		imageJLabel.add(exitButton);

		depositButton.addActionListener(this);
		withdrawButton.addActionListener(this);
		fastcashButton.addActionListener(this);
		ministatementButton.addActionListener(this);
		pinchangeButton.addActionListener(this);
		balanceinquiryButton.addActionListener(this);
		exitButton.addActionListener(this);

		setSize(900, 900);
		setLocation(300, 0);
		// for hide the border of jframe we can use setUndecorated(true) so now only
		// image will be there.
		setUndecorated(true);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			System.exit(0);
		} else if (e.getSource() == depositButton) {
			setVisible(false); // Transaction frame will be close
			new Deposit(pinnum).setVisible(true); // Deposit frame will open
		} else if (e.getSource() == withdrawButton) {
			setVisible(false);
			new Withdraw(pinnum).setVisible(true);
		} else if (e.getSource() == fastcashButton) {
			setVisible(false);
			new FastCash(pinnum).setVisible(true);
		} else if (e.getSource() == pinchangeButton) {
			setVisible(false);
			new PinChange(pinnum).setVisible(true);
		} else if (e.getSource() == balanceinquiryButton) {
			setVisible(false);
			new BalanceInquiry(pinnum).setVisible(true);
		} else if (e.getSource() == ministatementButton) {
			new MiniStatement(pinnum).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Transactions("");
	}

}
