package Palku;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//Gwapo

public class ADDPage extends JPanel {

	private static final long serialVersionUID = 1L;
	
	static String accountInfo = "infoStorage.txt";
	static String tempGrado = "tempInfoStore.txt";
	
	private JButton addTB;
	private JTextField aWeight;
	private JTextField aDate;
	private JTextField aWorkout;
	private JTextField aMessage;
	private JButton backB;
	private JTextField aSets;
	private JTextField aReps;
	
	static public String tName = "";
	static public String tGmail = "";
	static public long tNumber = 0;
	static public Character tGender = null;
	static public String tBirthday = "";
	static public String tPassword = "";
	static public long tWeightKG = 0;
	static public long tHeightCM = 0;

	static public long tWeight = 0;
	static public String tDate = "";
	static public String tWorkout = "";
	static public String tSets = "";
	static public String tReps = "";
	static public String tCategory = "";
	static public String tMessage = "";
	static public long qAmount = 0;
	
    public boolean realNum = true;
    public boolean realNum1 = true;
    
    static public String currAcc = "";
	
	private workoutTa parentFrame;
	
	public ADDPage(workoutTa parent) 
	{
		this.parentFrame = parent;
		
		setLayout(null);
		this.setBounds(10, 10, 439, 543);
		
		JLabel weight = new JLabel("Enter weight");
		weight.setBounds(33, 238, 73, 13);
		this.add(weight);
		
		aWeight = new JTextField();
		aWeight.setBounds(148, 234, 96, 19);
		this.add(aWeight);
		aWeight.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(33, 103, 73, 13);
		this.add(lblNewLabel_1);
		
		aDate = new JTextField();
		aDate.setBounds(148, 47, 96, 19);
		this.add(aDate);
		aDate.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setBounds(44, 50, 45, 13);
		this.add(lblNewLabel_2);
		
		aWorkout = new JTextField();
		aWorkout.setBounds(148, 160, 96, 19);
		this.add(aWorkout);
		aWorkout.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Workout");
		lblNewLabel_14.setBounds(33, 162, 51, 16);
		this.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Add message");
		lblNewLabel_15.setBounds(33, 383, 211, 19);
		this.add(lblNewLabel_15);
		
		aMessage = new JTextField();
		aMessage.setBounds(148, 377, 221, 94);
		this.add(aMessage);
		aMessage.setColumns(10);
		
		JButton finishWorkout = new JButton("Finish Workout");
		finishWorkout.setBounds(267, 499, 148, 21);
		this.add(finishWorkout);
		
		backB = new JButton("BACK");
		backB.setBounds(330, 10, 85, 21);
		this.add(backB);
		
		JComboBox aCategory = new JComboBox();
		aCategory.setModel(new DefaultComboBoxModel(new String[] {"Chest", "Shoulder", "Back", "Legs", "Core"}));
		aCategory.setBounds(148, 98, 96, 22);
		this.add(aCategory);
		aCategory.setSelectedIndex(-1);
		
		JLabel errorInput = new JLabel("Please enter a proper input.");
		errorInput.setBounds(163, 470, 135, 29);
		this.add(errorInput);
		
		JLabel EnterSets = new JLabel("Enter sets");
		EnterSets.setBounds(44, 338, 61, 15);
		this.add(EnterSets);
		
		aSets = new JTextField();
		aSets.setColumns(10);
		aSets.setBounds(116, 335, 96, 19);
		this.add(aSets);
		
		JLabel lblEnterReps_2 = new JLabel("Enter reps");
		lblEnterReps_2.setBounds(240, 339, 61, 13);
		this.add(lblEnterReps_2);
		
		aReps = new JTextField();
		aReps.setColumns(10);
		aReps.setBounds(311, 335, 96, 19);
		this.add(aReps);
		
		JButton addWorkout = new JButton("Add Workout");
		addWorkout.setBounds(44, 498, 148, 21);
		this.add(addWorkout);
		errorInput.setVisible(false);
		
		// Add page end =====================================
		
		backB.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				 parentFrame.showPanel("MENU_PANEL");
				 aCategory.setSelectedIndex(-1);
			}
		});
		
		aDate.getDocument().addDocumentListener(new DocumentListener() {
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
            	tDate = aDate.getText();
                // Do something with the text here
                System.out.println("Date: " + tDate);
            }
        });
		
       	aWeight.getDocument().addDocumentListener(new DocumentListener() {
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
                String text = aWeight.getText();
                try {
                    // Extract the first 11 digits from the input
                    String first11Digits = text.substring(0, Math.min(text.length(), 11));

                    Long number = Long.parseLong(first11Digits);

                    // Store the parsed integer in studentPhoneNum
                    tWeight = number;

                    // Do something with the amount
                    System.out.println("Amount: " + tWeight);
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
       	
        aWorkout.getDocument().addDocumentListener(new DocumentListener() {
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
            	tWorkout = aWorkout.getText();
                // Do something with the text here
                System.out.println("Title: " + tWorkout);
            }
        });
        
        
        aSets.getDocument().addDocumentListener(new DocumentListener() {
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
            	tSets = aSets.getText();
                // Do something with the text here
                System.out.println("Title: " + tSets);
            }
        });
        
        aReps.getDocument().addDocumentListener(new DocumentListener() {
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
            	tReps = aReps.getText();
                // Do something with the text here
                System.out.println("Title: " + tReps);
            }
        });
        
        aMessage.getDocument().addDocumentListener(new DocumentListener() {
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
            	tMessage = aMessage.getText();
                // Do something with the text here
                System.out.println("Message: " + tMessage);
            }
        });
		
		aCategory.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					int selectedIndex = aCategory.getSelectedIndex();
					if(selectedIndex == 0)
					{
						System.out.println("Chest");
						tCategory = "Chest";
					}
					
					else if(selectedIndex == 1)
					{
						System.out.println("Shoulder");
						tCategory = "Shoulder";
					}
					
					else if(selectedIndex == 2)
					{
						System.out.println("Back");
						tCategory = "Back";
						
					}
					else if(selectedIndex == 3)
					{
						System.out.println("Legs");
						tCategory = "Legs";
					}
					else if(selectedIndex == 4)
					{
						System.out.println("Core");
						tCategory = "Legs";
					}
				}
			}
		});
		
		addWorkout.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
        
		finishWorkout.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				 if(tCategory.trim().isEmpty() || tDate.trim().isEmpty() || tWeight == 0 || tWorkout.trim().isEmpty() || tSets.trim().isEmpty() || tReps.trim().isEmpty() || tMessage.trim().isEmpty())
				 {
					 errorInput.setVisible(true);
				 }
				 else
				 {
					 parentFrame.showPanel("MENU_PANEL");
					 
					 String convert = Long.toString(tWeight);
					 long qCash = 0;
					 long qSpent = 0;
					 long qLoan = 0;
					 long qPayLoan = 0;


					 
					 String distribute = Long.toString(qAmount);
					 // Date - Category - Workout - Sets - Reps - Message - Weight
					 String combine = tDate + "/ " + tCategory + "/ " + tWorkout + "/ " + tSets + "/ " + tReps + "/ " + tMessage + "/ " + distribute;
					 
					 
					 parentFrame.addToHistory(parentFrame.retrieveCurrAcc(), combine);
					 parentFrame.updateCheckCategory(parentFrame.retrieveCurrAcc(), tCategory, distribute);
					 
					 
					 tDate = "";
					 tCategory = "";
					 tWorkout = "";
					 tSets = "";
					 tReps = "";
					 tMessage = "";
					 tWeight = 0;
					 
					 aDate.setText("");
					 aCategory.setSelectedIndex(-1);
					 aWorkout.setText("");
					 aSets.setText("");
					 aReps.setText("");
					 aMessage.setText("");
					 aWeight.setText("");
				}
			}
		});
        
		//END OF TRANSACTION EVENTS gwapo kaayo ko.
	}

}
