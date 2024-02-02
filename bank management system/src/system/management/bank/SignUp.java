package system.management.bank;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {

	long random;
	JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField,
			pinTextField;
	JDateChooser dateChooser;
	JButton nextBtn;

	JRadioButton maleBtn, femaleBtn, married, unmarried, other;

	SignUp() {
		setLayout(null); // for set form to center

		Random ran = new Random();
		random = (Math.abs(ran.nextLong() % 9000L + 1000L)); // now it'll generate 4 digit number

		JLabel formno = new JLabel("APPLICATION FROM NO. " + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		;
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);

		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);

		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		;
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);

		JLabel dob = new JLabel("Date Of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);

		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		maleBtn = new JRadioButton("Male");
		maleBtn.setBounds(300, 290, 60, 30);
		maleBtn.setBackground(Color.WHITE);
		add(maleBtn);

		femaleBtn = new JRadioButton("Female");
		femaleBtn.setBounds(450, 290, 120, 30);
		femaleBtn.setBackground(Color.WHITE);
		add(femaleBtn);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(maleBtn);
		genderGroup.add(femaleBtn);

		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		;
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);

		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);

		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);

		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);

		other = new JRadioButton("Other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);

		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);

		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		;
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);

		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		;
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);

		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		;
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);

		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);

		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);

		nextBtn = new JButton("Next");
		nextBtn.setBackground(Color.BLACK);
		nextBtn.setForeground(Color.WHITE);
		nextBtn.setFont(new Font("Raleway", Font.BOLD, 14));
		nextBtn.setBounds(620, 660, 80, 30);
		add(nextBtn);
		nextBtn.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String formnum = "" + random;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); // getText only work with
																							// textField so we've to
																							// cast it to JTextfield
		String gender = null;
		if (maleBtn.isSelected()) {
			gender = "Male";
		} else if (femaleBtn.isSelected()) {
			gender = "Female";
		}

		String email = emailTextField.getText();
		String marital = null;
		if (married.isSelected()) {
			marital = "Married";
		} else if (unmarried.isSelected()) {
			marital = "UnMarried";
		} else if (other.isSelected()) {
			marital = "Other";
		}

		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText();

		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is required");
			} else {
				ConnectionProvide c = new ConnectionProvide();
				String query = "insert into signup values('" + formnum + "', '" + name + "', '" + fname + "', '" + dob
						+ "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city
						+ "', '" + pin + "', '" + state + "' )";
				// "string'+"variable_field""+'string"
				c.st.executeUpdate(query);
				setVisible(false);
				
				//creating object of signupTwo class for pass form number to it form signup class
				new SignupTwo(formnum).setVisible(true);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Error occur in signup file in action method");
		}

	}

	public static void main(String[] args) {
		new SignUp();
	}
}
