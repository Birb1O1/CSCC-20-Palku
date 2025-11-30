package Palku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//Gwapo

public class REGISTERPage extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField name;
	private JTextField gmail;
	private JTextField pNum;
	private JTextField bday;
	private JTextField gmailL;
	private JTextField heightCM;
	private JTextField weightKG;
	
	private JButton logPage;
	
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel dIncor;
	
    public boolean realNum = true;
    public boolean realNum1 = true;
    public boolean gender = true;
	private JPasswordField pass;
	
	private workoutTa parentFrame;
	
	
	static String accountInfo = "infoStorage.txt";
	static String tempGrado = "tempInfoStore.txt";
	
	static public String tName = "";
	static public String tGmail = "";
	static public long tNumber = 0;
	static public Character tGender = null;
	static public String tBirthday = "";
	static public String tPassword = "";
	static public long tWeightKG = 0;
	static public long tHeightCM = 0;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public REGISTERPage(workoutTa parent) 
	{
		this.parentFrame = parent;
		
		setLayout(null);
		this.setBounds(10, 10, 440, 543);
		
		lblNewLabel_4 = new JLabel("NAME");
		lblNewLabel_4.setBounds(52, 43, 85, 13);
		this.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("EMAIL");
		lblNewLabel_5.setBounds(52, 82, 85, 13);
		this.add(lblNewLabel_5);
		
		lblNewLabel_7 = new JLabel("PASSWORD");
		lblNewLabel_7.setBounds(37, 363, 75, 13);
		this.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("NUMBER");
		lblNewLabel_8.setBounds(52, 125, 85, 13);
		this.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("BIRTHDAY");
		lblNewLabel_9.setBounds(37, 171, 85, 13);
		this.add(lblNewLabel_9);
		
		JRadioButton male = new JRadioButton("MALE");
		male.setBounds(37, 309, 103, 21);
		buttonGroup.add(male);
		this.setLayout(null);
		this.add(male);
		
		JRadioButton female = new JRadioButton("FEMALE");
		female.setBounds(161, 309, 103, 21);
		buttonGroup.add(female);
		this.add(female);
		
		JLabel lblNewLabel_10 = new JLabel("GENDER");
		lblNewLabel_10.setBounds(27, 289, 113, 13);
		this.add(lblNewLabel_10);
		
		JButton registB1 = new JButton("REGISTER");
		registB1.setBounds(147, 461, 117, 21);
		this.add(registB1);
		
		JLabel lblNewLabel_11 = new JLabel("REGISTER PAGE");
		lblNewLabel_11.setBounds(194, 10, 96, 13);
		this.add(lblNewLabel_11);
		
		name = new JTextField();
		name.setBounds(147, 40, 224, 19);
		this.add(name);
		name.setColumns(10);
		
		gmail = new JTextField();
		gmail.setBounds(143, 79, 228, 19);
		this.add(gmail);
		gmail.setColumns(10);
		
		pNum = new JTextField();
		pNum.setBounds(147, 121, 252, 19);
		this.add(pNum);
		pNum.setColumns(10);
		
		bday = new JTextField();
		bday.setBounds(147, 167, 241, 19);
		this.add(bday);
		bday.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(133, 359, 215, 20);
		this.add(pass);
		
		JLabel errorNum = new JLabel("Please enter your input correctly.");
		errorNum.setBounds(94, 443, 228, 14);
		this.add(errorNum);
		
		logPage = new JButton("LOGIN PAGE");
		logPage.setBounds(147, 493, 149, 23);
		this.add(logPage);
		
		JLabel emailExists = new JLabel("EMAIL ALREADY EXISTS");
		emailExists.setBounds(119, 429, 156, 14);
		this.add(emailExists);
		
		JLabel lblNewLabel_9_1 = new JLabel("HEIGHT (Cm)");
		lblNewLabel_9_1.setBounds(27, 209, 85, 13);
		this.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("WEIGHT (Kg)");
		lblNewLabel_9_1_1.setBounds(27, 245, 85, 13);
		this.add(lblNewLabel_9_1_1);
		
		heightCM = new JTextField();
		heightCM.setColumns(10);
		heightCM.setBounds(143, 205, 241, 19);
		this.add(heightCM);
		
		weightKG = new JTextField();
		weightKG.setColumns(10);
		weightKG.setBounds(123, 241, 241, 19);
		this.add(weightKG);
		errorNum.setVisible(false);
		emailExists.setVisible(false);
		
		// REGISTRATION EVENTS====================================================================
		
		male.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tGender = 'M';
				System.out.println("Male");
			}
		});

		female.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tGender = 'F';
				System.out.println("Female");
			}
		});
		
	    name.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        private void updateLabel()  
	        {
	        	tName = name.getText();
	            // Do something with the text here
	            System.out.println("Name: " + tName);
	        }
	    });
		
	    gmail.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        private void updateLabel()  
	        {
	        	tGmail = gmail.getText();
	            // Do something with the text here
	            System.out.println("Gmail: " + tGmail);
	        }
	    });
	    
	   	pNum.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) 
	        {
	            updateLong();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateLong();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            updateLong();
	        }

	        private long updateLong() {
	            String text = pNum.getText();
	            try {
	                // Extract the first 11 digits from the input
	                String first11Digits = text.substring(0, Math.min(text.length(), 11));

	                Long number = Long.parseLong(first11Digits);

	                // Store the parsed integer in studentPhoneNum
	                tNumber = number;

	                // Do something with the integer
	                System.out.println("Integer: " + tNumber);
	                realNum = true;
	                System.out.println(realNum);

	                return number; // Return the parsed integer
	            } catch (NumberFormatException ex) {
	                // Handle the exception if the input is not a valid integer
	                System.out.println("Invalid integer input: " + text);
	                realNum = false;
	                System.out.println(realNum);
	                return 0; // Return a default value or handle the error appropriately
	            }
	        }
	    });
	   	
	   	weightKG.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) 
	        {
	            updateLong();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateLong();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            updateLong();
	        }

	        private long updateLong() {
	            String text = weightKG.getText();
	            try {
	                // Extract the first 11 digits from the input
	                String first11Digits = text.substring(0, Math.min(text.length(), 11));

	                Long number = Long.parseLong(first11Digits);

	                // Store the parsed integer in studentPhoneNum
	                tWeightKG = number;

	                // Do something with the integer
	                System.out.println("Integer: " + tWeightKG);
	                realNum = true;
	                System.out.println(realNum);

	                return number; // Return the parsed integer
	            } catch (NumberFormatException ex) {
	                // Handle the exception if the input is not a valid integer
	                System.out.println("Invalid integer input: " + text);
	                realNum = false;
	                System.out.println(realNum);
	                return 0; // Return a default value or handle the error appropriately
	            }
	        }
	    });
	   	
	   	heightCM.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) 
	        {
	            updateLong();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateLong();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            updateLong();
	        }

	        private long updateLong() {
	            String text = heightCM.getText();
	            try {
	                // Extract the first 11 digits from the input
	                String first11Digits = text.substring(0, Math.min(text.length(), 11));

	                Long number = Long.parseLong(first11Digits);

	                // Store the parsed integer in studentPhoneNum
	                tHeightCM = number;

	                // Do something with the integer
	                System.out.println("Integer: " + tHeightCM);
	                realNum = true;
	                System.out.println(realNum);

	                return number; // Return the parsed integer
	            } catch (NumberFormatException ex) {
	                // Handle the exception if the input is not a valid integer
	                System.out.println("Invalid integer input: " + text);
	                realNum = false;
	                System.out.println(realNum);
	                return 0; // Return a default value or handle the error appropriately
	            }
	        }
	    });
	   	
	    bday.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        private void updateLabel()  
	        {
	        	tBirthday = bday.getText();
	            // Do something with the text here
	            System.out.println("Bday: " + tBirthday);
	        }
	    });
	    
	    pass.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            updateLabel();
	        }

	        private void updateLabel()  
	        {
	            char[] passwordChar = pass.getPassword();
	            tPassword = String.valueOf(passwordChar);

	            // Do something with the password here
	            System.out.println("Password: " + tPassword);
	        }
	    });
	    
		logPage.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				parentFrame.showPanel("LOGIN_PAGE");
				
				name.setText("");
				gmail.setText("");
				pNum.setText("");
				bday.setText("");
				pass.setText("");
				weightKG.setText("");
				heightCM.setText("");
			}
		});
	    
		registB1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				File accStore = new File(accountInfo);
				if (tName.trim().isEmpty() || tGmail.trim().isEmpty() || tNumber == 0 || tGender == null || tBirthday.trim().isEmpty() || tHeightCM == 0 || tWeightKG == 0 || tPassword.trim().isEmpty())

				{
					errorNum.setVisible(true);
				}
				else
				{
					if (parentFrame.checkAccExists(tGmail))
					{
						emailExists.setVisible(true);
						System.out.println("HAHAHAHAHAHAHA");
					}
					else
					{
						emailExists.setVisible(false);
						if (realNum == true)
						{
							System.out.println("Hello");
							parentFrame.showPanel("LOGIN_PANEL");
							
							parentFrame.createAcc(tGmail);
							parentFrame.createAccHist(tGmail);
							
							String cNum = Long.toString(tNumber);
							String cWeight = Long.toString(tWeightKG);
							String cHeight = Long.toString(tHeightCM);
							String cGen = Character.toString(tGender);
							
							// Parameter (Name, gmail, number, gender, bday, pass, weight, height)
							parentFrame.addUser(tName, tGmail, cNum, cGen, tBirthday, tPassword, cWeight, cHeight);
							
							name.setText("");
							gmail.setText("");
							pNum.setText("");
							bday.setText("");
							pass.setText("");
							weightKG.setText("");
							heightCM.setText("");
							
							tName = "";
							tGmail = "";
							tNumber = 0;
							tBirthday = "";
							tPassword = "";
							tWeightKG = 0;
							tHeightCM = 0;
							

							errorNum.setVisible(false);
						}
						else
						{
							errorNum.setVisible(true);
						}
					}
				}
			}
		});

	}

}
