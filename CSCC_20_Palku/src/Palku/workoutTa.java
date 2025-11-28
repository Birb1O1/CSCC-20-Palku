package Palku;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel CASHL;
	private JLabel SPENTL;
	private JLabel LOANL;
	private JLabel lblNewLabel_3;
	private JPanel HISTORY;
	private JPanel REGISTER;
	private JPanel LOGIN;
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
	static public long tAmount = 0;
	static public String tDate = "";
	static public String tTitle = "";
	static public String tCategory = "";
	static public String tMessage = "";
	static public String currAcc = "";
	static public long qAmount = 0;

	
    public boolean realNum = true;
    public boolean realNum1 = true;
    public boolean gender = true;
    private JPasswordField pass;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    
	static String accountInfo = "infoStorage.txt";
	static String tempGrado = "tempInfoStore.txt";
	static Scanner input = new Scanner(System.in);
	private JPasswordField passL;
	private JButton logPage;
	private JLabel dIncor;
	private JLabel lblNewLabel_6;
	private JButton addTB;
	private JTextField aAmount;
	private JTextField aDate;
	private JTextField aTitle;
	private JTextField aMessage;
	private JButton backB;
	private JList mSpent;
	private JList mLoan;
	private JLabel lblNewLabel_20;
	
	static DefaultListModel<String> lHistory = new DefaultListModel<>();
	
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
	
	static void addUser(String name, String gmail, String num, String gen, String bday, String pass)
	{
		String uName = name;
		String uGmail = gmail;
		String uNum = num;
		String uGender = gen;
		String uBday = bday;
		String uPass = pass;
		
		String type = uGmail + ", " + uName  + ", " + uNum + ", " + uGender + ", " + uBday + ", " + uPass;
		
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
		
		// GMAIL - CASH - SPENT - LOAN
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

                if (parts.length >= 6) 
                {
                    String email = parts[0].trim();
                    String pass = parts[5].trim();
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
	
	static long addToCash(String Email, String amount)
	{
		System.out.println("Cash running");
		
		File z = new File(Email + ".txt");
		Long total = (long) 0.00;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;
            System.out.println("Cash running2");

            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");

                if (parts.length >= 4) {
                    String email = parts[0].trim(); // Now checking first column
                    if (email.equalsIgnoreCase(Email.trim())) 
                    {
                    	System.out.println("Cash running3");
                    	
                        Long firstVal = Long.parseLong(parts[1].trim());
                        Long secVal = Long.parseLong(amount);
                        
                        System.out.println("cash running4");
                        
                        total = firstVal + secVal; // adds the amount of cash stored to the amount placed
                        
                        fixCash(Email, total);
                        
                        System.out.println("Total Cash:" + total);
                        return total; // returns total cash
                    }
                }
            }
		}
		
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return 0;
	}
	
	static long addToSpent(String Email, String amount)
	{
		File z = new File(Email + ".txt");
		long total =  0;
		long total2 = 0;
		
		System.out.println("Spent running");
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");

                if (parts.length >= 4) 
                {
                    String email = parts[0].trim(); // Now checking first column
                    if (email.equalsIgnoreCase(Email.trim())) 
                    {
                        long firstVal = Long.parseLong(amount);
                        long secVal = Long.parseLong(parts[2].trim());
                        
                        total = firstVal * (-1); //returns a negative number to add to cash
                        total2 = secVal + firstVal;
                        
                		System.out.println(total);
                        String convert = Long.toString(total);
                        addToCash(Email, convert);
                        
                        System.out.println("Total Spent:" + amount);
                        
                        fixSpent(currAcc, total2);
                        return total2;
                    }
                }
            }
		}
		
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return 0;
	}
	
	static long addToLoan(String Email, String amount)
	{
		File z = new File(Email + ".txt");
		long total = 0;
		
		System.out.println("Loan running");
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 4) {
                    String email = parts[0].trim(); // Now checking first column
                    if (email.equalsIgnoreCase(Email.trim())) 
                    {
                        Long firstVal = Long.parseLong(parts[3].trim());
                        Long secVal = Long.parseLong(amount);
                        
                        total = firstVal + secVal; //Adds up the current stored loan with the input one
                        
                        addToCash(Email, amount); //Adds the amount of loan to current cash
                        return total; //Returns the value of the total loan
                    }
                }
            }
		}
		
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return 0;
	}
	
	static long payLoan(String Email, String amount)
	{
		File z = new File(Email + ".txt");
		long total = 0;
		long total2 = 0;
		long total3 = 0;
		
		System.out.println("Pay loan running");
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 4) {
                    String email = parts[0].trim(); // Now checking first column
                    if (email.equalsIgnoreCase(Email.trim())) 
                    {
                        Long firstVal = Long.parseLong(parts[3].trim());
                        Long secVal = Long.parseLong(amount);
                        Long thiVal = Long.parseLong(parts[2].trim());
                        
                        total = firstVal - secVal;
                        
                        total2 = secVal * (-1);
                        String convert = Long.toString(total2);
                        addToCash(Email, convert);
                        
                        total3 = thiVal + secVal;
                        String convert2 = Long.toString(total3);
                        
                        
                        return total; // Returns the minused value of the Loan, basically paying a loan.
                    }
                }
            }
		}
		
		catch(IOException e)
		{
			System.out.println("Error reading the file: " + e.getMessage());
		}
		
		return 0;
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

                if (parts.length >= 4) {
                    String email = parts[0].trim(); // Now checking first column
                    if (email.equalsIgnoreCase(Email.trim())) 
                    {
                    	found = true;
                    	if (car.equalsIgnoreCase("Cash"))
                    	{
                    		parts[1] = amount;
                    		System.out.println("Hi hello Cash");
                    	}
                    	else if (car.equalsIgnoreCase("Spent"))
                    	{
                    		parts[2] = amount;
                    		System.out.println("Hi hello Spent");
                    	}
                    	else if (car.equalsIgnoreCase("Loan"))
                    	{
                    		parts[3] = amount;
                    		System.out.println("Hi hello Loan");
                    	}
                    	else if (car.equalsIgnoreCase("Pay Loan"))
                    	{
                    		parts[3] = amount;
                    		System.out.println("Hi hello Pay Loan");
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
	
	static Long retrieveCash(String Email)
	{
		File z = new File(Email + ".txt");
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 4) 
                {
                	String email = parts[0].trim();
                    String cash = parts[1].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	Long rNum = Long.parseLong(cash);
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
	
	static Long retrieveSpent(String Email)
	{
		File z = new File(Email + ".txt");
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 4) 
                {
                	String email = parts[0].trim();
                    String spent = parts[2].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	Long rNum = Long.parseLong(spent);
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
	
	static Long retrieveLoan(String Email)
	{
		File z = new File(Email + ".txt");
		
		try(BufferedReader reader = new BufferedReader(new FileReader(z)))
		{
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 3) 
                {
                	String email = parts[0].trim();
                    String loan = parts[3].trim(); // Now checking first column
                    if(email.equalsIgnoreCase(Email.trim()))
                    {
                    	Long rNum = Long.parseLong(loan);
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
	
	// END OF METHODS ================================================================================	====================
	
	public workoutTa() 
	{
		DefaultListModel<String> lName = new DefaultListModel<>();
		DefaultListModel<String> lEmail = new DefaultListModel<>();
		DefaultListModel<Long> lNum = new DefaultListModel<>();
		DefaultListModel<String> lBday = new DefaultListModel<>();
		DefaultListModel<Long> lCash = new DefaultListModel<>();
		lCash.clear();
		DefaultListModel<Long> lSpent = new DefaultListModel<>();
		lSpent.clear();
		DefaultListModel<Long> lLoan = new DefaultListModel<>();
		lLoan.clear();
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		REGISTER = new JPanel();
		REGISTER.setBounds(10, 10, 440, 543);
		contentPane.add(REGISTER);
		REGISTER.setLayout(null);
		
		lblNewLabel_4 = new JLabel("NAME");
		lblNewLabel_4.setBounds(52, 43, 85, 13);
		REGISTER.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("EMAIL");
		lblNewLabel_5.setBounds(52, 82, 85, 13);
		REGISTER.add(lblNewLabel_5);
		
		lblNewLabel_7 = new JLabel("PASSWORD");
		lblNewLabel_7.setBounds(76, 312, 113, 13);
		REGISTER.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("NUMBER");
		lblNewLabel_8.setBounds(52, 140, 85, 13);
		REGISTER.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("BIRTHDAY");
		lblNewLabel_9.setBounds(62, 196, 85, 13);
		REGISTER.add(lblNewLabel_9);
		
		JRadioButton male = new JRadioButton("MALE");
		buttonGroup.add(male);
		male.setBounds(62, 268, 103, 21);
		REGISTER.add(male);
		
		JRadioButton female = new JRadioButton("FEMALE");
		buttonGroup.add(female);
		female.setBounds(172, 268, 103, 21);
		REGISTER.add(female);
		
		JLabel lblNewLabel_10 = new JLabel("GENDER");
		lblNewLabel_10.setBounds(92, 236, 113, 13);
		REGISTER.add(lblNewLabel_10);
		
		JButton registB1 = new JButton("REGISTER");
		registB1.setBounds(173, 418, 117, 21);
		REGISTER.add(registB1);
		
		JLabel lblNewLabel_11 = new JLabel("REGISTER");
		lblNewLabel_11.setBounds(194, 10, 96, 13);
		REGISTER.add(lblNewLabel_11);
		
		name = new JTextField();
		name.setBounds(147, 40, 224, 19);
		REGISTER.add(name);
		name.setColumns(10);
		
		gmail = new JTextField();
		gmail.setBounds(143, 79, 228, 19);
		REGISTER.add(gmail);
		gmail.setColumns(10);
		
		pNum = new JTextField();
		pNum.setBounds(147, 136, 252, 19);
		REGISTER.add(pNum);
		pNum.setColumns(10);
		
		bday = new JTextField();
		bday.setBounds(147, 192, 241, 19);
		REGISTER.add(bday);
		bday.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(107, 336, 215, 20);
		REGISTER.add(pass);
		
		JLabel errorNum = new JLabel("Please enter your input correctly.");
		errorNum.setBounds(107, 393, 228, 14);
		REGISTER.add(errorNum);
		
		logPage = new JButton("LOGIN PAGE");
		logPage.setBounds(173, 456, 149, 23);
		REGISTER.add(logPage);
		
		JLabel emailExists = new JLabel("EMAIL ALREADY EXISTS");
		emailExists.setBounds(119, 367, 156, 14);
		REGISTER.add(emailExists);
		errorNum.setVisible(false);
		emailExists.setVisible(false);
		
		LOGIN = new JPanel();
		LOGIN.setBounds(10, 10, 440, 543);
		contentPane.add(LOGIN);
		LOGIN.setLayout(null);
		
		gmailL = new JTextField();
		gmailL.setBounds(92, 137, 191, 20);
		LOGIN.add(gmailL);
		gmailL.setColumns(10);
		
		JButton loginFrameB = new JButton("LOGIN");
		loginFrameB.setBounds(170, 270, 89, 23);
		LOGIN.add(loginFrameB);
		
		JLabel lblNewLabel_12 = new JLabel("Email");
		lblNewLabel_12.setBounds(86, 112, 46, 14);
		LOGIN.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Password");
		lblNewLabel_13.setBounds(86, 165, 197, 24);
		LOGIN.add(lblNewLabel_13);
		
		JButton registB2 = new JButton("REGISTER PAGE");
		registB2.setBounds(170, 304, 138, 23);
		LOGIN.add(registB2);
		
		passL = new JPasswordField();
		passL.setBounds(92, 200, 191, 20);
		LOGIN.add(passL);
		
		dIncor = new JLabel("DETAILS INCORRECT");
		dIncor.setBounds(105, 245, 221, 14);
		LOGIN.add(dIncor);
		
		lblNewLabel_6 = new JLabel("LOGIN PAGE");
		lblNewLabel_6.setBounds(183, 51, 113, 14);
		LOGIN.add(lblNewLabel_6);
		dIncor.setVisible(false);
		
		JPanel MENU = new JPanel();
		MENU.setBounds(10, 10, 440, 543);
		contentPane.add(MENU);
		MENU.setLayout(null);
		
		CASHL = new JLabel("CASH");
		CASHL.setBounds(43, 225, 45, 13);
		MENU.add(CASHL);
		
		SPENTL = new JLabel("SPENT");
		SPENTL.setBounds(189, 225, 45, 13);
		MENU.add(SPENTL);
		
		LOANL = new JLabel("LOAN");
		LOANL.setBounds(340, 225, 45, 13);
		MENU.add(LOANL);
		
		JButton histB = new JButton("HISTORY");
		histB.setBounds(149, 363, 172, 21);
		MENU.add(histB);
		
		lblNewLabel_3 = new JLabel("CASH SAVING APP");
		lblNewLabel_3.setBounds(149, 30, 125, 13);
		MENU.add(lblNewLabel_3);
		
		addTB = new JButton("ADD TRANSACTION");
		addTB.setBounds(120, 309, 153, 23);
		MENU.add(addTB);
		
		JButton LOGOUT = new JButton("LOGOUT");
		LOGOUT.setBounds(294, 26, 124, 21);
		MENU.add(LOGOUT);
		
		JList mName = new JList();
		mName.setBounds(94, 54, 136, 34);
		MENU.add(mName);
		
		JLabel lblNewLabel_16 = new JLabel("Name:");
		lblNewLabel_16.setBounds(27, 74, 46, 14);
		MENU.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Email:");
		lblNewLabel_17.setBounds(27, 111, 46, 14);
		MENU.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Number:");
		lblNewLabel_18.setBounds(27, 136, 102, 30);
		MENU.add(lblNewLabel_18);
		
		JList mEmail = new JList();
		mEmail.setBounds(94, 99, 140, 26);
		MENU.add(mEmail);
		
		JList mNum = new JList();
		mNum.setBounds(98, 136, 136, 30);
		MENU.add(mNum);
		
		JLabel lblNewLabel_19 = new JLabel("Birthday:");
		lblNewLabel_19.setBounds(27, 178, 117, 14);
		MENU.add(lblNewLabel_19);
		
		JList mBday = new JList();
		mBday.setBounds(94, 177, 140, 21);
		MENU.add(mBday);
		
		JList mCash = new JList();
		mCash.setBounds(10, 249, 102, 16);
		MENU.add(mCash);
		
		mSpent = new JList();
		mSpent.setBounds(131, 249, 143, 16);
		MENU.add(mSpent);
		
		mLoan = new JList();
		mLoan.setBounds(282, 249, 136, 16);
		MENU.add(mLoan);
		
		HISTORY = new JPanel();
		HISTORY.setBounds(10, 10, 440, 543);
		contentPane.add(HISTORY);
		HISTORY.setLayout(null);
		
		lblNewLabel_20 = new JLabel("Transaction History");
		lblNewLabel_20.setBounds(167, 22, 202, 14);
		HISTORY.add(lblNewLabel_20);
		
		JScrollPane hHistory = new JScrollPane();
		hHistory.setBounds(10, 47, 420, 485);
		HISTORY.add(hHistory);
		
		JList histList = new JList();
		hHistory.setViewportView(histList);
		
		JButton hBack = new JButton("Back");
		hBack.setBounds(341, 11, 89, 23);
		HISTORY.add(hBack);
		
		JPanel ADD = new JPanel();
		ADD.setBounds(10, 10, 440, 543);
		contentPane.add(ADD);
		ADD.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter amount");
		lblNewLabel.setBounds(44, 167, 188, 13);
		ADD.add(lblNewLabel);
		
		aAmount = new JTextField();
		aAmount.setBounds(148, 161, 96, 19);
		ADD.add(aAmount);
		aAmount.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(33, 103, 73, 13);
		ADD.add(lblNewLabel_1);
		
		aDate = new JTextField();
		aDate.setBounds(148, 47, 96, 19);
		ADD.add(aDate);
		aDate.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setBounds(44, 50, 45, 13);
		ADD.add(lblNewLabel_2);
		
		aTitle = new JTextField();
		aTitle.setBounds(148, 220, 96, 19);
		ADD.add(aTitle);
		aTitle.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Expense title");
		lblNewLabel_14.setBounds(33, 223, 180, 16);
		ADD.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Add message");
		lblNewLabel_15.setBounds(33, 282, 211, 19);
		ADD.add(lblNewLabel_15);
		
		aMessage = new JTextField();
		aMessage.setBounds(148, 279, 221, 94);
		ADD.add(aMessage);
		aMessage.setColumns(10);
		
		JButton addTransaction = new JButton("Add transaction");
		addTransaction.setBounds(115, 431, 148, 21);
		ADD.add(addTransaction);
		
		backB = new JButton("BACK");
		backB.setBounds(330, 10, 85, 21);
		ADD.add(backB);
		
		JComboBox aCategory = new JComboBox();
		aCategory.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Spent", "Loan", "Pay Loan"}));
		aCategory.setBounds(148, 98, 96, 22);
		ADD.add(aCategory);
		aCategory.setSelectedIndex(-1);
		
		JLabel errorInput = new JLabel("Please enter a proper input.");
		errorInput.setBounds(133, 391, 266, 29);
		ADD.add(errorInput);
		errorInput.setVisible(false);
		
		
		
		// STARTING EVENTS
		LOGIN.setVisible(false);
		MENU.setVisible(false);
		HISTORY.setVisible(false);
		ADD.setVisible(false);
		REGISTER.setVisible(true);
		
		
		
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
      
		registB1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				File accStore = new File(accountInfo);
				if (tName.trim().isEmpty() || tGmail.trim().isEmpty() || tNumber == 0 || tGender == null || tBirthday.trim().isEmpty() || tPassword.trim().isEmpty())

				{
					errorNum.setVisible(true);
				}
				else
				{
					if (checkAccExists(tGmail))
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
							REGISTER.setVisible(false);
							LOGIN.setVisible(true);
							
							createAcc(tGmail);
							createAccHist(tGmail);
							
							String cNum = Long.toString(tNumber);
							String cGen = Character.toString(tGender);
							
							addUser(tName, tGmail, cNum, cGen, tBirthday, tPassword);
							
							name.setText("");
							gmail.setText("");
							pNum.setText("");
							bday.setText("");
							pass.setText("");
							
							tName = "";
							tGmail = "";
							tNumber = 0;
							tBirthday = "";
							tPassword = "";
	
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
		
		// REGISTER PAGE EVENTS FINISH ==================================================================================
		
		
		
		// LOGIN PAGE EVENTS START ================================================================
		
		logPage.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				REGISTER.setVisible(false);
				LOGIN.setVisible(true);
				
				name.setText("");
				gmail.setText("");
				pNum.setText("");
				bday.setText("");
				pass.setText("");
			}
		});
		
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
    	
		loginFrameB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(checkLogin(tGmail, tPassword))
				{
    				LOGIN.setVisible(false);
    				MENU.setVisible(true);
    				dIncor.setVisible(false);
    				
					lName.clear();
					String qName = retrieveName(tGmail);
					lName.addElement(qName);
					mName.setModel(lName);
					
					lEmail.clear();
					lEmail.addElement(tGmail);
					mEmail.setModel(lEmail);
					
					lNum.clear();
					Long qNum = retrieveNum(tGmail);
					lNum.addElement(qNum);
					mNum.setModel(lNum);

					lBday.clear();
					String qBday = retrieveBday(tGmail);
					lBday.addElement(qBday);
					mBday.setModel(lBday);
					
					lCash.clear();
					Long qCash = retrieveCash(tGmail);
					lCash.addElement(qCash);
					mCash.setModel(lCash);
					
					lSpent.clear();
					Long qSpent = retrieveSpent(tGmail);
					lSpent.addElement(qSpent);
					mSpent.setModel(lSpent);
					
					lLoan.clear();
					Long qLoan = retrieveLoan(tGmail);
					lLoan.addElement(qLoan);
					mLoan.setModel(lLoan);
    				
					currAcc = tGmail;
					
    				gmailL.setText("");
    				passL.setText("");
    				
					tName = "";
					tGmail = "";
					tNumber = 0;
					tBirthday = "";
					tPassword = "";
				}
				else
				{
					dIncor.setVisible(true);
				}
			}
		});
		
		//LOGIN EVENTS FINISH =================================================================================
		
		
		
		//MAIN MENU EVENTS =============================================================== 
		
		addTB.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				REGISTER.setVisible(false);
				LOGIN.setVisible(false);
				MENU.setVisible(false);
				HISTORY.setVisible(false);
				ADD.setVisible(true);
			}
		});
		
		histB.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				lHistory.clear();
				
				REGISTER.setVisible(false);
				LOGIN.setVisible(false);
				MENU.setVisible(false);
				HISTORY.setVisible(true);
				ADD.setVisible(false);
				
				createHistFormat(currAcc);
				
				histList.setModel(lHistory);
			}
		});
		
		LOGOUT.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				REGISTER.setVisible(false);
				LOGIN.setVisible(true);
				MENU.setVisible(false);
				HISTORY.setVisible(false);
				ADD.setVisible(false);
				
				lHistory.clear();
				currAcc = "";
			}
		});
		
		//END OF MAIN MENU EVENTS ============================================
		
		
		
		//TRANSACTION EVENTS =================================================
		backB.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				 MENU.setVisible(true);
				 ADD.setVisible(false);
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
		
       	aAmount.getDocument().addDocumentListener(new DocumentListener() {
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
                String text = aAmount.getText();
                try {
                    // Extract the first 11 digits from the input
                    String first11Digits = text.substring(0, Math.min(text.length(), 11));

                    Long number = Long.parseLong(first11Digits);

                    // Store the parsed integer in studentPhoneNum
                    tAmount = number;

                    // Do something with the amount
                    System.out.println("Amount: " + tAmount);
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
       	
        aTitle.getDocument().addDocumentListener(new DocumentListener() {
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
            	tTitle = aTitle.getText();
                // Do something with the text here
                System.out.println("Title: " + tTitle);
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
						System.out.println("Cash");
						tCategory = "Cash";
						
					}
					
					else if(selectedIndex == 1)
					{
						System.out.println("Spent");
						tCategory = "Spent";
						
					}
					
					else if(selectedIndex == 2)
					{
						System.out.println("Loan");
						tCategory = "Loan";
						
					}
					else if(selectedIndex == 3)
					{
						System.out.println("Pay Loan");
						tCategory = "Pay Loan";
					}
				}
			}
		});
        
		addTransaction.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				 if(tCategory.trim().isEmpty() || tDate.trim().isEmpty() || tAmount == 0 || tTitle.trim().isEmpty() || tMessage.trim().isEmpty())
				 {
					 errorInput.setVisible(true);
				 }
				 else
				 {
					 MENU.setVisible(true);
					 ADD.setVisible(false);
					 
					 String convert = Long.toString(tAmount);
					 long qCash = 0;
					 long qSpent = 0;
					 long qLoan = 0;
					 long qPayLoan = 0;
					 
					 if(tCategory.equalsIgnoreCase("Cash"))
					 {
						 lCash.clear();
						 System.out.println("tCash");
						 
						 qCash = addToCash(currAcc, convert);
						 
						 qAmount = qCash;
					 }
					 else if(tCategory.equalsIgnoreCase("Spent"))
					 {
						 lSpent.clear();
						 System.out.println("tCat");
						 
						 qSpent = addToSpent(currAcc, convert);
						 
						 qAmount = qSpent;
					 }
					 else if(tCategory.equalsIgnoreCase("Loan"))
					 {
						 lLoan.clear();
						 System.out.println("tLoan");
						 
						 qLoan = addToLoan(currAcc, convert);
						 
						 qAmount = qLoan;
					 }
					 else if(tCategory.equalsIgnoreCase("Pay Loan"))
					 {
						 lLoan.clear();
						 System.out.println("tPayloan");
	
						 qPayLoan = payLoan(currAcc, convert);
						 
						 qAmount = qPayLoan;
					 }
					 
					 String distribute = Long.toString(qAmount);
					 // Date - Category - Title - Message - Amount
					 String combine = tDate + "/ " + tCategory + "/ " + tTitle + "/ " + tMessage + "/ " + distribute;
					 
					 
					 addToHistory(currAcc, combine);
					 updateCheckCategory(currAcc, tCategory, distribute);
					 
					 
					 lCash.clear();
					 qCash = retrieveCash(currAcc);
					 lCash.addElement(qCash);
					 mCash.setModel(lCash);
					 System.out.println(lCash);
					 
					 lSpent.clear();
					 qSpent = retrieveSpent(currAcc);
					 lSpent.addElement(qSpent);
					 mSpent.setModel(lSpent);
					 System.out.println(lSpent);
					 
					 lLoan.clear();
					 qLoan = retrieveLoan(currAcc);
					 lLoan.addElement(qLoan);
					 mLoan.setModel(lLoan);
					 System.out.println(lLoan);
					 
					 lLoan.clear();
					 qPayLoan = retrieveLoan(currAcc);
					 lLoan.addElement(qPayLoan);
					 mLoan.setModel(lLoan);
					 System.out.println(lLoan);
					 
					 tDate = "";
					 tCategory = "";
					 tTitle = "";
					 tMessage = "";
					 tAmount = 0;
					 
					 aDate.setText("");
					 aCategory.setSelectedIndex(-1);
					 aTitle.setText("");
					 aMessage.setText("");
					 aAmount.setText("");
				}
			}
		});
        
		//END OF TRANSACTION EVENTS
		
		
		
		// HISTORY EVENTS
		hBack.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				HISTORY.setVisible(false);
				MENU.setVisible(true);
			}
		});
	}
}

//RDB Relational database
//NRDB Non relational database
