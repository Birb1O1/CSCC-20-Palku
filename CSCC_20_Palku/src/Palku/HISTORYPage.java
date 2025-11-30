package Palku;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//Gwapo

public class HISTORYPage extends JPanel {

	private static final long serialVersionUID = 1L;

	private workoutTa parentFrame;
	
	public HISTORYPage(workoutTa parent) 
	{
		this.parentFrame = parent;
		
		setLayout(null);
		
		HISTORY = new JPanel();
		HISTORY.setBounds(10, 10, 440, 543);
		contentPane.add(HISTORY);
		HISTORY.setLayout(null);
		
		lblNewLabel_20 = new JLabel("Workout History");
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
		
		
		// HISTORY EVENTS ===========================================================================================
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
