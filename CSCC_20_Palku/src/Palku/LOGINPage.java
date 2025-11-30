package Palku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//Gwapo

public class LOGINPage extends JPanel {

	private static final long serialVersionUID = 1L;

	private workoutTa parentFrame;
	
	private JPasswordField passL;
	private JButton logPage;
	private JLabel dIncor;
	private JTextField gmailL;
	private JLabel lblNewLabel_6;
	
	static public String tName = "";
	static public String tGmail = "";
	static public long tNumber = 0;
	static public Character tGender = null;
	static public String tBirthday = "";
	static public String tPassword = "";
	static public long tWeightKG = 0;
	static public long tHeightCM = 0;
	
	public LOGINPage(workoutTa parent) 
	{
		this.parentFrame = parent;
		
		setLayout(null);
		
		this.setBounds(10, 10, 439, 543);
		
		gmailL = new JTextField();
		gmailL.setBounds(92, 137, 191, 20);
		this.add(gmailL);
		gmailL.setColumns(10);
		
		JButton loginFrameB = new JButton("LOGIN");
		loginFrameB.setBounds(170, 270, 89, 23);
		this.add(loginFrameB);
		
		JLabel lblNewLabel_12 = new JLabel("Email");
		lblNewLabel_12.setBounds(86, 112, 46, 14);
		this.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Password");
		lblNewLabel_13.setBounds(86, 165, 197, 24);
		this.add(lblNewLabel_13);
		
		JButton registB2 = new JButton("REGISTER PAGE");
		registB2.setBounds(170, 304, 138, 23);
		this.add(registB2);
		
		passL = new JPasswordField();
		passL.setBounds(92, 200, 191, 20);
		this.add(passL);
		
		dIncor = new JLabel("DETAILS INCORRECT");
		dIncor.setBounds(105, 245, 221, 14);
		this.add(dIncor);
		
		lblNewLabel_6 = new JLabel("LOGIN PAGE");
		lblNewLabel_6.setBounds(183, 51, 113, 14);
		this.add(lblNewLabel_6);
		dIncor.setVisible(false);
		
		//Login page end ======================================================
		
		
		// LOGIN PAGE EVENTS START ================================================================
		
    	gmailL.getDocument().addDocumentListener(new DocumentListener() {
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
            	tGmail = gmailL.getText();
                // Do something with the text here
                System.out.println("Gmail: " + tGmail);
            }
            
            
        });
		
    	//Gwapo
    	
        passL.getDocument().addDocumentListener(new DocumentListener() {
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
                char[] passwordChar1 = passL.getPassword();
                tPassword = String.valueOf(passwordChar1);

                // Do something with the password here
                System.out.println("Pass: " + tPassword);
            }
        });
        
		registB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				REGISTER.setVisible(true);
				LOGIN.setVisible(false);
				
				gmailL.setText("");
				passL.setText("");
			}
		});
    	
		loginFrameB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(parentFrame.checkLogin(tGmail, tPassword))
				{
    				LOGIN.setVisible(false);
    				MENU.setVisible(true);
    				dIncor.setVisible(false);
    				
					lName.clear();
					String qName = parentFrame.retrieveName(tGmail);
					lName.addElement(qName);
					mName.setModel(lName);
					
					lEmail.clear();
					lEmail.addElement(tGmail);
					mEmail.setModel(lEmail);
					
					lNum.clear();
					Long qNum = parentFrame.retrieveNum(tGmail);
					lNum.addElement(qNum);
					mNum.setModel(lNum);

					lBday.clear();
					String qBday = parentFrame.retrieveBday(tGmail);
					lBday.addElement(qBday);
					mBday.setModel(lBday);
					
					lWeight.clear();
					Long qWeight = parentFrame.retrieveWeight(tGmail);
					lWeight.addElement(qWeight);
					mWeight.setModel(lWeight);
					
					lHeight.clear();
					Long qHeight = parentFrame.retrieveHeight(tGmail);
					lHeight.addElement(qHeight);
					mHeight.setModel(lHeight);
					
					lGoal.clear();
					Long qGoal = parentFrame.retrieveGoal(tGmail);
					lGoal.addElement(qGoal);
					mGoal.setModel(lGoal);
    				
					currAcc = tGmail;
					
    				gmailL.setText("");
    				passL.setText("");
    				
					tName = "";
					tGmail = "";
					tNumber = 0;
					tBirthday = "";
					tPassword = "";
					tWeightKG = 0;
					tHeightCM = 0;
				}
				else
				{
					dIncor.setVisible(true);
				}
			}
		});
		
		//LOGIN EVENTS FINISH =================================================================================
	}

}
