package Palku;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

//Gwapo

public class MENUPage extends JPanel {

	private static final long serialVersionUID = 1L;

	private workoutTa parentFrame;
	
	public MENUPage(workoutTa parent) 
	{
		this.parentFrame = parent;
		
		setLayout(null);
		
		JPanel MENU = new JPanel();
		MENU.setBounds(10, 10, 439, 543);
		contentPane.add(MENU);
		MENU.setLayout(null);
		
		CASHL = new JLabel("Weight");
		CASHL.setBounds(43, 225, 45, 13);
		MENU.add(CASHL);
		
		SPENTL = new JLabel("Height");
		SPENTL.setBounds(189, 225, 45, 13);
		MENU.add(SPENTL);
		
		LOANL = new JLabel("Goal");
		LOANL.setBounds(340, 225, 45, 13);
		MENU.add(LOANL);
		
		JButton histB = new JButton("HISTORY");
		histB.setBounds(149, 363, 172, 21);
		MENU.add(histB);
		
		lblNewLabel_3 = new JLabel("WORKOUT APP");
		lblNewLabel_3.setBounds(149, 30, 125, 13);
		MENU.add(lblNewLabel_3);
		
		addTB = new JButton("ADD WORKOUT");
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
		
		JList mWeight = new JList();
		mWeight.setBounds(10, 249, 102, 16);
		MENU.add(mWeight);
		
		mHeight = new JList();
		mHeight.setBounds(131, 249, 143, 16);
		MENU.add(mHeight);
		
		mGoal = new JList();
		mGoal.setBounds(282, 249, 136, 16);
		MENU.add(mGoal);
		
	}
	
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

}
