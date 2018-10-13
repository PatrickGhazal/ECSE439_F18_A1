package ca.mcgill.ecse439.pizzadeliverysystem.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ClientViewPage extends JFrame {
	
	private static final long serialVersionUID = 9126638650941721801L;
	
	private JButton viewMenuButton;
	
	public ClientViewPage() {
		initComponents();
	}
	
	private void initComponents() {
		
		viewMenuButton = new JButton();
		
		viewMenuButton.setText("View menu");
		
		viewMenuButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				ViewMenuPage vmp = new ViewMenuPage();
				vmp.setVisible(true);
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(viewMenuButton));
		layout.setVerticalGroup(layout.createParallelGroup().addComponent(viewMenuButton));
		
		pack();
		
	}
	
}
