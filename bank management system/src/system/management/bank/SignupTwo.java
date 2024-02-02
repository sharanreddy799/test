package system.management.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale.Category;

public class SignupTwo extends JFrame implements ActionListener {

	JTextField panTextField, adharTextField;
	JComboBox religionBox, categoriesBox, incomeBox, educationBox, occupationBox;
	JRadioButton syesBtn, snoBtn, eyesBtn, enoBtn;
	JButton nextBtn;
	String formNumber;

	SignupTwo(String formnum) {
		this.formNumber = formnum;
		setLayout(null); // for set form to center

		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);

		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);

		String valReligion[] = { "Hindu", "Sikh", "Christan", "Other" };
		religionBox = new JComboBox(valReligion);
		religionBox.setBounds(300, 140, 400, 30);
		religionBox.setBackground(Color.WHITE);
		add(religionBox);

		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);

		String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
		categoriesBox = new JComboBox(valCategory);
		categoriesBox.setBounds(300, 190, 400, 30);
		categoriesBox.setBackground(Color.WHITE);
		add(categoriesBox);

		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);

		String incomeCategory[] = { "Null", "< 1,50,000", "< 2,50,00", "<5,00,000", "Upto 10,00,000" };
		incomeBox = new JComboBox(incomeCategory);
		incomeBox.setBounds(300, 240, 400, 30);
		incomeBox.setBackground(Color.WHITE);
		add(incomeBox);

		JLabel educational = new JLabel("Educational:");
		educational.setFont(new Font("Raleway", Font.BOLD, 20));
		educational.setBounds(100, 290, 200, 30);
		add(educational);

		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);

		String educationValues[] = { "Non Graduate", "Graduate", "Post Graduate", "Doctor", "Others" };
		educationBox = new JComboBox(educationValues);
		educationBox.setBounds(300, 315, 400, 30);
		educationBox.setBackground(Color.WHITE);
		add(educationBox);

		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);

		String occupationValues[] = { "salaried", "Self EMployeed", "Buisnessman", "Student", "Retired", "Others" };
		occupationBox = new JComboBox(occupationValues);
		occupationBox.setBounds(300, 390, 400, 30);
		occupationBox.setBackground(Color.WHITE);
		add(occupationBox);

		JLabel pannum = new JLabel("PAN Number:");
		pannum.setFont(new Font("Raleway", Font.BOLD, 20));
		pannum.setBounds(100, 440, 200, 30);
		add(pannum);

		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		;
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);

		JLabel adharnum = new JLabel("Addhar Number:");
		adharnum.setFont(new Font("Raleway", Font.BOLD, 20));
		adharnum.setBounds(100, 490, 200, 30);
		add(adharnum);

		adharTextField = new JTextField();
		adharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		;
		adharTextField.setBounds(300, 490, 400, 30);
		add(adharTextField);

		JLabel seniorCitizen = new JLabel("Senior Citizen:");
		seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorCitizen.setBounds(100, 540, 200, 30);
		add(seniorCitizen);

		syesBtn = new JRadioButton("Yes");
		syesBtn.setBounds(300, 540, 60, 30);
		syesBtn.setBackground(Color.WHITE);
		add(syesBtn);

		snoBtn = new JRadioButton("No");
		snoBtn.setBounds(450, 540, 120, 30);
		snoBtn.setBackground(Color.WHITE);
		add(snoBtn);

		ButtonGroup seniorCitizenButtonGroup = new ButtonGroup();
		seniorCitizenButtonGroup.add(syesBtn);
		seniorCitizenButtonGroup.add(snoBtn);

		JLabel existingAccount = new JLabel("Existing Account:");
		existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
		existingAccount.setBounds(100, 590, 200, 30);
		add(existingAccount);

		eyesBtn = new JRadioButton("Yes");
		eyesBtn.setBounds(300, 590, 60, 30);
		eyesBtn.setBackground(Color.WHITE);
		add(eyesBtn);

		enoBtn = new JRadioButton("No");
		enoBtn.setBounds(450, 590, 120, 30);
		enoBtn.setBackground(Color.WHITE);
		add(enoBtn);

		ButtonGroup accountButtonGroup = new ButtonGroup();
		accountButtonGroup.add(eyesBtn);
		accountButtonGroup.add(enoBtn);

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
		// this below variables name you have to pass inside query whenever you will
		// create.
		String religionString = (String) religionBox.getSelectedItem();
		String categoryString = (String) categoriesBox.getSelectedItem();
		String incomeString = (String) incomeBox.getSelectedItem();
		String educationString = (String) educationBox.getSelectedItem();
		String occupationString = (String) occupationBox.getSelectedItem();

		String panString = panTextField.getText();
		String adharString = adharTextField.getText();

		String seniorCitizen = null;
		if (syesBtn.isSelected()) {
			seniorCitizen = "Yes";
		} else if (snoBtn.isSelected()) {
			seniorCitizen = "No";
		}

		String existingAccount = null;
		if (eyesBtn.isSelected()) {
			existingAccount = "Yes";
		} else if (enoBtn.isSelected()) {
			existingAccount = "No";
		}

		try {

			ConnectionProvide c = new ConnectionProvide();
			String query = "insert into signuptwo values( '" + formNumber + "', '" + religionString + "', '"
					+ categoryString + "', '" + incomeString + "', '" + educationString + "', '" + occupationString
					+ "', '" + panString + "', '" + adharString + "','" + seniorCitizen + "','" + existingAccount
					+ "' )";
			// "string'+"variable_field""+'string"
			c.st.executeUpdate(query);

			// signup 3 object will be created
			setVisible(false);
			new SignupThree(formNumber).setVisible(true);;

		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Error occur in signupTwo file in action method");
		}

	}

	public static void main(String[] args) {
		new SignupTwo("");
	}
}
