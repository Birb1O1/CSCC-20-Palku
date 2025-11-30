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
	
	private JLabel lblNewLabel_20;

	private workoutTa parentFrame;
	
	public HISTORYPage(workoutTa parent) 
	{
		this.parentFrame = parent;
		
		setLayout(null);

		this.setBounds(10, 10, 440, 543);

		
		lblNewLabel_20 = new JLabel("Workout History");
		lblNewLabel_20.setBounds(167, 22, 202, 14);
		this.add(lblNewLabel_20);
		
		JScrollPane hHistory = new JScrollPane();
		hHistory.setBounds(10, 47, 420, 485);
		this.add(hHistory);
		
		JList histList = new JList();
		hHistory.setViewportView(histList);
		
		JButton hBack = new JButton("Back");
		hBack.setBounds(341, 11, 89, 23);
		this.add(hBack);
		
		
		// HISTORY EVENTS ===========================================================================================
		hBack.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				parentFrame.showPanel("MENU_PANEL");
			}
		});
	}

}
