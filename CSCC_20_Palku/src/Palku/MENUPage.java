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
	private JLabel CASHL;
	private JLabel SPENTL;
	private JLabel LOANL;
	private JLabel lblNewLabel_3;
	private JButton addTB;
	private JList mHeight;
	private JList mGoal;
	
	static public String currAcc = "";

	private workoutTa parentFrame;
	
	public MENUPage(workoutTa parent) 
	{
		this.parentFrame = parent;
		
		setLayout(null);
		
		this.setBounds(10, 10, 439, 543);

		
		CASHL = new JLabel("Weight");
		CASHL.setBounds(43, 225, 45, 13);
		this.add(CASHL);
		
		SPENTL = new JLabel("Height");
		SPENTL.setBounds(189, 225, 45, 13);
		this.add(SPENTL);
		
		LOANL = new JLabel("Goal");
		LOANL.setBounds(340, 225, 45, 13);
		this.add(LOANL);
		
		JButton histB = new JButton("HISTORY");
		histB.setBounds(149, 363, 172, 21);
		this.add(histB);
		
		lblNewLabel_3 = new JLabel("WORKOUT APP");
		lblNewLabel_3.setBounds(149, 30, 125, 13);
		this.add(lblNewLabel_3);
		
		addTB = new JButton("ADD WORKOUT");
		addTB.setBounds(120, 309, 153, 23);
		this.add(addTB);
		
		JButton LOGOUT = new JButton("LOGOUT");
		LOGOUT.setBounds(294, 26, 124, 21);
		this.add(LOGOUT);
		
		JList mName = new JList();
		mName.setBounds(94, 54, 136, 34);
		this.add(mName);
		
		JLabel lblNewLabel_16 = new JLabel("Name:");
		lblNewLabel_16.setBounds(27, 74, 46, 14);
		this.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Email:");
		lblNewLabel_17.setBounds(27, 111, 46, 14);
		this.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Number:");
		lblNewLabel_18.setBounds(27, 136, 102, 30);
		this.add(lblNewLabel_18);
		
		JList mEmail = new JList();
		mEmail.setBounds(94, 99, 140, 26);
		this.add(mEmail);
		
		JList mNum = new JList();
		mNum.setBounds(98, 136, 136, 30);
		this.add(mNum);
		
		JLabel lblNewLabel_19 = new JLabel("Birthday:");
		lblNewLabel_19.setBounds(27, 178, 117, 14);
		this.add(lblNewLabel_19);
		
		JList mBday = new JList();
		mBday.setBounds(94, 177, 140, 21);
		this.add(mBday);
		
		JList mWeight = new JList();
		mWeight.setBounds(10, 249, 102, 16);
		this.add(mWeight);
		
		mHeight = new JList();
		mHeight.setBounds(131, 249, 143, 16);
		this.add(mHeight);
		
		mGoal = new JList();
		mGoal.setBounds(282, 249, 136, 16);
		this.add(mGoal);
	
		
		addTB.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				parentFrame.showPanel("ADD_PANEL");
			}
		});
		
		histB.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				lHistory.clear();
				
				parentFrame.showPanel("HISTORY_PANEL");
				
				parentFrame.createHistFormat(currAcc);
				
				histList.setModel(lHistory);
			}
		});
		
		LOGOUT.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				parentFrame.showPanel("LOGIN_PANEL");
				
				lHistory.clear();
				currAcc = "";
			}
		});
	}

}
