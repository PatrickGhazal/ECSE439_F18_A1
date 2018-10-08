package ca.mcgill.ecse439.pizzadeliverysystem.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DeliveryManagerPage extends JFrame {
	
	private static final long serialVersionUID = -7263158278644858433L;
	
	private JButton ownerViewButton, clientViewButton;
	
	public DeliveryManagerPage() {
		initComponents();
	}
	
	private void initComponents() {
		
		ownerViewButton = new JButton();
		clientViewButton = new JButton();
		
		ownerViewButton.setText("Use as owner.");
		clientViewButton.setText("Use as client.");
		
		ownerViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				OwnerViewPage ovp = new OwnerViewPage();
				ovp.setVisible(true);
			}
		});
		
		clientViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				ClientViewPage cvp = new ClientViewPage();
				cvp.setVisible(true);
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(ownerViewButton).addComponent(clientViewButton));
		layout.setVerticalGroup(layout.createParallelGroup().addComponent(ownerViewButton).addComponent(clientViewButton));
		
		pack();
		
	}
	
}
