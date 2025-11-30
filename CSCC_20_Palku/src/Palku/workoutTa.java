package Palku;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

import java.io.*;
import java.nio.*;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

import java.util.Date;

public class workoutTa extends JFrame 
{
	private CardLayout cardlayout;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel CASHL;
	private JLabel SPENTL;
	private JLabel LOANL;
	private JLabel lblNewLabel_3;
	private JPanel HISTORY;
	private JPanel REGISTER;
	private JPanel LOGIN;
	private JPanel MENU;
	private JPanel ADD;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField name;
	private JTextField gmail;
	private JTextField pNum;
	private JTextField bday;
	private JTextField gmailL;

	/**
	 * Launch the application.
	 */
	
	// USER TEMPORARY STORAGE FOR INFO
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
	
	
	static public String currAcc = "";
	
	static public String[] chestWorkout = {"Pushups", "Bench Press", "Chest Flies"};
	static public String[] shoulderWorkout = {"Dumbbell Shrugs", "Lateral raises", "Overhead press"};
	static public String[] backWorkout = {"Lat pulldown", "Rear delts fly", "Rows"};
	static public String[] legWorkout = {"Leg press", "Squats", "Quad Extension"};
	static public String[] coreWorkout = {"Crunches", "Plank", "Leg Raises"};
	
    public boolean realNum = true;
    public boolean realNum1 = true;
    public boolean gender = true;
    private JPasswordField pass;
    
	static String accountInfo = "infoStorage.txt";
	static String tempGrado = "tempInfoStore.txt";
	static Scanner input = new Scanner(System.in);
	private JPasswordField passL;
	private JButton logPage;
	private JLabel dIncor;
	private JLabel lblNewLabel_6;
	private JButton addTB;
	private JTextField aWeight;
	private JTextField aDate;
	private JTextField aWorkout;
	private JTextField aMessage;
	private JButton backB;
	private JList mHeight;
	private JList mGoal;
	private JLabel lblNewLabel_20;
	
	static DefaultListModel<String> lHistory = new DefaultListModel<>();
	private JTextField aSets;
	private JTextField aReps;
	private JTextField heightCM;
	private JTextField weightKG;
	
	public static void main(String[] args) 
	{
		File accStore = new File(accountInfo);
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					workoutTa frame = new workoutTa();
					frame.setVisible(true);
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	// METHODS ============================================================================================
	
	// Parameter (Name, gmail, number, gender, bday, pass, weight, height)
	static void addUser(String name, String gmail, String num, String gen, String bday, String pass, String weight, String height)
	{
		String uName = name;
		String uGmail = gmail;
		String uNum = num;
		String uGender = gen;
		String uBday = bday;
		String uPass = pass;
		String uWeight = weight;
		String uHeight = height;
		
		String type = uGmail + ", " + uName  + ", " + uNum + ", " + uGender + ", " + uBday + ", " + uWeight + ", " + uHeight + ", " + uPass;
		
		try(FileWriter writes = new FileWriter(accountInfo, true))
		{	
			writes.write(type + "\n");
			
			System.out.println("User record has been uploaded");
		}
		catch(IOException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
	
	static void createAcc(String fileName)
	{
		String newUser = fileName + ".txt";
		
		File uDataBase = new File(newUser);
		
		// GMAIL - Weight - Height - Goal
		String type = tGmail + ", 0, 0, 0"; 
		
		try(FileWriter writes = new FileWriter(newUser, true))
		{
			writes.write("hahaha\n");
			writes.write(type + "\n");
			
			System.out.println("New user has been created");
		}
		catch(IOException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
	
	static void createAccHist(String fileName)
	{
		String newUser = fileName + "History.txt";
		
		File uDataBase = new File(newUser);
		
		// Date - Category -  Amount - Title - Message
		
		try(FileWriter writes = new FileWriter(newUser, true))
		{
			writes.write("HISTORY OF TRANSACTIONS\n");
			writes.write(fileName + "\n");
			
			System.out.println("New user history has been created");
		}
		catch(IOException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
	
	static void addToHistory(String Email, String toAdd)
	{
		String addHist = Email + "History.txt";
		
		File uDataBase = new File(addHist);
		
		// Date - Category -  Amount - Title - Message
		
		try(FileWriter writes = new FileWriter(addHist, true))
		{
			writes.write(toAdd + "\n");
			
			System.out.println("New transaction has been created");
		}
		catch(IOException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
	
	static Boolean checkLogin(String mGmail, String mPass)
	{
		File z = new File(accountInfo);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");

                if (parts.length >= 8) 
                {
                    String email = parts[0].trim();
                    String pass = parts[7].trim();
                    if (email.equalsIgnoreCase(mGmail.trim()) && pass.equals(mPass)) 
                    {
                        return true; // Both valid
                    }
                }
                else
                {
                	System.out.println("Error less lines.");
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return false;
	}
	
	static Boolean checkAccExists(String mGmail)
	{
		File z = new File(accountInfo);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 1) {
                    String email = parts[0].trim(); // Now checking first column
                    if (email.equalsIgnoreCase(mGmail.trim())) {
                        return true; // Gmail already exists
                    }
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return false;
	}
	
	static void fixCash(String Email, Long cash)
	{
		File z = new File(Email + ".txt");
	    String store = null;
	    File temp = new File(Email + "temp.txt");
	    boolean found = false;
	    List<String> updatedRecords = new ArrayList<>();
	    
	    try (Scanner myReader = new Scanner(z)) 
	    {
	        while (myReader.hasNextLine()) 
	        {
	            String data = myReader.nextLine();
	            if (data.startsWith(Email + ",")) 
	            {
	                String[] splitter = data.split(", ");
	                found = true;

	                String cashS = Long.toString(cash);
	                
	                splitter[1] = cashS;

	                String joiner = String.join(", ", splitter);
	                System.out.println("Updated record to be written: " + joiner);
	                updatedRecords.add(joiner);
	            } 
	            else 
	            {
	                updatedRecords.add(data);
	            }
	        }

	        if (found) 
	        {
	            try (FileWriter writesTemp = new FileWriter(temp, false)) 
	            {
	                for (String record : updatedRecords) 
	                {
	                    writesTemp.write(record + "\n");
	                }
	                System.out.println("Updated data written to temporary file: " + temp.getName());
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error writing to the temporary file.");
	                e.printStackTrace();
	                return; 
	            }

	            try (Scanner reworkoutTar = new Scanner(temp); FileWriter writesGrado = new FileWriter(z, false)) 
	            {
	                while (reworkoutTar.hasNextLine()) 
	                {
	                    writesGrado.write(reworkoutTar.nextLine() + "\n");
	                }
	                System.out.println("Record updated successfully in " + z);
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error writing to the original file.");
	                e.printStackTrace();
	                return; 
	            }

	            try (FileWriter clearTemp = new FileWriter(temp, false)) 
	            {
	                System.out.println("Temporary file " + temp.getName() + " cleared.");
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error clearing the temporary file.");
	                e.printStackTrace();
	            }

	        } 
	        else 
	        {	            
	            try (FileWriter clearTemp = new FileWriter(temp, false)) 
	            {
	                System.out.println("Temporary file " + temp.getName() + " cleared (no update).");
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error clearing the temporary file.");
	                e.printStackTrace();
	            }
	        }

	    } 
	    catch (FileNotFoundException e) 
	    {
	        System.out.println("Error reading the workoutTabook file.");
	        e.printStackTrace();
	    }
	}

	static void fixSpent(String Email, Long cash)
	{
		File z = new File(Email + ".txt");
	    String store = null;
	    File temp = new File(Email + "temp.txt");
	    boolean found = false;
	    List<String> updatedRecords = new ArrayList<>();
	    
	    try (Scanner myReader = new Scanner(z)) 
	    {
	        while (myReader.hasNextLine()) 
	        {
	            String data = myReader.nextLine();
	            if (data.startsWith(Email + ",")) 
	            {
	                String[] splitter = data.split(", ");
	                found = true;

	                String cashS = Long.toString(cash);
	                
	                splitter[2] = cashS;

	                String joiner = String.join(", ", splitter);
	                System.out.println("Updated record to be written: " + joiner);
	                updatedRecords.add(joiner);
	            } 
	            else 
	            {
	                updatedRecords.add(data);
	            }
	        }

	        if (found) 
	        {
	            try (FileWriter writesTemp = new FileWriter(temp, false)) 
	            {
	                for (String record : updatedRecords) 
	                {
	                    writesTemp.write(record + "\n");
	                }
	                System.out.println("Updated data written to temporary file: " + temp.getName());
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error writing to the temporary file.");
	                e.printStackTrace();
	                return; 
	            }

	            try (Scanner reworkoutTar = new Scanner(temp); FileWriter writesGrado = new FileWriter(z, false)) 
	            {
	                while (reworkoutTar.hasNextLine()) 
	                {
	                    writesGrado.write(reworkoutTar.nextLine() + "\n");
	                }
	                System.out.println("Record updated successfully in " + z);
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error writing to the original file.");
	                e.printStackTrace();
	                return; 
	            }

	            try (FileWriter clearTemp = new FileWriter(temp, false)) 
	            {
	                System.out.println("Temporary file " + temp.getName() + " cleared.");
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error clearing the temporary file.");
	                e.printStackTrace();
	            }

	        } 
	        else 
	        {	            
	            try (FileWriter clearTemp = new FileWriter(temp, false)) 
	            {
	                System.out.println("Temporary file " + temp.getName() + " cleared (no update).");
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error clearing the temporary file.");
	                e.printStackTrace();
	            }
	        }

	    } 
	    catch (FileNotFoundException e) 
	    {
	        System.out.println("Error reading the workoutTabook file.");
	        e.printStackTrace();
	    }
	}
	
	
	static void updateCheckCategory (String Email, String car, String amount)
	{
		String cashFile = Email + ".txt";
		String tempFileUpd = Email + "temp.txt";
		
		boolean found = false;
		
		List<String> updatedRecords = new ArrayList<>();
		
		File z = new File(cashFile);
		File temp = new File(tempFileUpd);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");

                if (parts.length >= 6) {
                    String email = parts[0].trim(); // Now checking first column
                    if (email.equalsIgnoreCase(Email.trim())) 
                    {
                    	found = true;
                    	if (car.equalsIgnoreCase("Chest"))
                    	{
                    		parts[1] = amount;
                    		System.out.println("Hi hello Chest");
                    	}
                    	else if (car.equalsIgnoreCase("Shoulder"))
                    	{
                    		parts[2] = amount;
                    		System.out.println("Hi hello Shoulder");
                    	}
                    	else if (car.equalsIgnoreCase("Back"))
                    	{
                    		parts[3] = amount;
                    		System.out.println("Hi hello Back");
                    	}
                    	else if (car.equalsIgnoreCase("Legs"))
                    	{
                    		parts[4] = amount;
                    		System.out.println("Hi hello Legs");
                    	}
                    	else if (car.equalsIgnoreCase("Core"))
                    	{
                    		parts[5] = amount;
                    		System.out.println("Hi hello Core");
                    	}
                    	
    	                String joiner = String.join(", ", parts);
    	                System.out.println("Updated record to be written: " + joiner);
    	                updatedRecords.add(joiner);
                    }
                    else
                    {
                    	updatedRecords.add(line);
                    }
                }
            }
	        if (found) 
	        {
	            try (FileWriter writesTemp = new FileWriter(tempFileUpd, false)) 
	            {
	                for (String record : updatedRecords) 
	                {
	                    writesTemp.write(record + "\n");
	                }
	                System.out.println("Updated data written to temporary file: " + temp.getName());
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error writing to the temporary file.");
	                e.printStackTrace();
	                return; 
	            }

	            try (Scanner reworkoutTar = new Scanner(temp); FileWriter writesGrado = new FileWriter(z, false)) 
	            {
	                while (reworkoutTar.hasNextLine()) 
	                {
	                    writesGrado.write(reworkoutTar.nextLine() + "\n");
	                }
	                System.out.println("Record updated successfully in " + z);
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error writing to the original file.");
	                e.printStackTrace();
	                return; 
	            }

	            try (FileWriter clearTemp = new FileWriter(temp, false)) 
	            {
	                System.out.println("Temporary file " + temp.getName() + " cleared.");
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error clearing the temporary file.");
	                e.printStackTrace();
	            }

	        } 
	        else 
	        {   
	            try (FileWriter clearTemp = new FileWriter(temp, false)) 
	            {
	                System.out.println("Temporary file " + temp.getName() + " cleared (no update).");
	            } 
	            catch (IOException e) 
	            {
	                System.out.println("Error clearing the temporary file.");
	                e.printStackTrace();
	            }
	        }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
	}
	
	static String retrieveName(String Email)
	{
		File z = new File(accountInfo);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 2) 
                {
                	String email = parts[0].trim();
                    String name = parts[1].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	return name;
                    }
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return null;
	}
	
	static Long retrieveNum(String Email)
	{
		File z = new File(accountInfo);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 3) 
                {
                	String email = parts[0].trim();
                    String num = parts[2].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	Long rNum = Long.parseLong(num);
                    	return rNum;
                    }
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return null;
	}
	
	static String retrieveBday(String Email)
	{
		File z = new File(accountInfo);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 6) 
                {
                	String email = parts[0].trim();
                    String bday = parts[4].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	return bday;
                    }
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return null;
	}
	
	static Long retrieveWeight(String Email)
	{
		File z = new File(Email + ".txt");
		
		// GMAIL - Weight - Height - Goal
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 4) 
                {
                	String email = parts[0].trim();
                    String weight = parts[1].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	Long rNum = Long.parseLong(weight);
                    	return rNum;
                    }
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return null;
	}
	
	static Long retrieveHeight(String Email)
	{
		File z = new File(Email + ".txt");
		
		// GMAIL - Weight - Height - Goal
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 4) 
                {
                	String email = parts[0].trim();
                    String height = parts[2].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	Long rNum = Long.parseLong(height);
                    	return rNum;
                    }
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return null;
	}
	
	static Long retrieveGoal(String Email)
	{
		File z = new File(Email + ".txt");
		
		// GMAIL - Weight - Height - Goal
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 3) 
                {
                	String email = parts[0].trim();
                    String goal = parts[3].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	Long rNum = Long.parseLong(goal);
                    	return rNum;
                    }
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return null;
	}
	
	static String retrieveCurrAcc()
	{
		return currAcc;
	}
	
	static void setCurrAcc(String acc)
	{
		currAcc = acc;
	}
	
	static void createHistFormat(String Email)
	{
		File z = new File(Email + "History.txt");
		lHistory.clear();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/ ");

                if (parts.length >= 5) 
                {
               
                	// Date - Category - Title - Message - Amount
                    String date = parts[0].trim(); // Now checking first column
                    String category = parts[1].trim();
                    String title = parts[2].trim();
                    String message = parts[3].trim();
                    String amount = parts[4].trim();
                    
                    String combined = "Date: " + date + "\nCategory:" + category + "\nTitle:" + title + "\nMessage:" + message + "\nAmount:" + amount + "\n"; 
                    
    				lHistory.addElement(combined);
                }
            }
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
	}
	
	public void showPanel (String panelName)
	{
		cardlayout.show(contentPane, panelName);
	}
	
	// END OF METHODS ================================================================================	====================
	
	public workoutTa() 
	{	
		cardlayout = new CardLayout();
		
		DefaultListModel<String> lName = new DefaultListModel<>();
		DefaultListModel<String> lEmail = new DefaultListModel<>();
		DefaultListModel<Long> lNum = new DefaultListModel<>();
		DefaultListModel<String> lBday = new DefaultListModel<>();
		DefaultListModel<Long> lWeight = new DefaultListModel<>();
		lWeight.clear();
		DefaultListModel<Long> lHeight = new DefaultListModel<>();
		lHeight.clear();
		DefaultListModel<Long> lGoal = new DefaultListModel<>();
		lGoal.clear();
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 600);
		contentPane = new JPanel(cardlayout);
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//REGISTER CLASSES
		REGISTER = new REGISTERPage(this); // Initialize the member variable REGISTER
		REGISTER.setBounds(10, 10, 440, 543); // Set bounds to match other main panels
		contentPane.add(REGISTER, "REGISTER_PANEL");
		
		//Login classes
		LOGIN = new LOGINPage(this);
		LOGIN.setBounds(10, 10, 440, 543);
		contentPane.add(LOGIN, "LOGIN_PANEL");
		
		//Menu classes
		MENU = new MENUPage(this);
		MENU.setBounds(10, 10, 440, 543);
		contentPane.add(MENU, "MENU_PANEL");
		
		//History classes
		HISTORY = new HISTORYPage(this);
		HISTORY.setBounds(10, 10, 440, 543);
		contentPane.add(HISTORY, "HISTORY_PANEL");
		
		//ADD CLASSES
		ADD = new ADDPage(this);
		ADD.setBounds(10, 10, 440, 543);
		contentPane.add(ADD, "ADD_PANEL");
		
		

		
		// STARTING EVENTS
		LOGIN.setVisible(false);
		MENU.setVisible(false);
		HISTORY.setVisible(false);
		ADD.setVisible(false);
		REGISTER.setVisible(true);
		

	}
}

//RDB Relational database
//NRDB Non relational database
