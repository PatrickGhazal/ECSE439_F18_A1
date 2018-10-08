package ca.mcgill.ecse439.pizzadeliverysystem.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OwnerViewPage extends JFrame {

	private static final long serialVersionUID = -8310350604453967420L;
	
	private boolean hasLoggedIn = false;
	private String account = "admin", password = "admin";
	
	// for login page
	private JLabel loginLabel;
	private JTextField loginAccountField, loginPasswordField;
	private JButton loginButton;
	
	// for operating page
	private JButton viewMenuButton, updateMenuButton;
	
	public OwnerViewPage() {
		initComponentsLogIn();
	}
	
	private void initComponentsLogIn() {
		
		loginLabel = new JLabel();
		loginAccountField = new JTextField();
		loginPasswordField = new JTextField();
		loginButton = new JButton();
		
		loginLabel.setText("Enter your username and password.");
		loginAccountField.setText("                              ");
		loginPasswordField.setText("                              ");
		loginButton.setText("Log in !");
		
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (correctCredentials(loginAccountField, loginPasswordField)) {
					initComponentsOperations();
				}
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(loginLabel)
						.addComponent(loginAccountField))
				.addGroup(layout.createParallelGroup()
						.addComponent(loginPasswordField)
						.addComponent(loginButton))
				);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(loginLabel)
				.addGroup(layout.createParallelGroup()
						.addComponent(loginAccountField)
						.addComponent(loginPasswordField))
				.addComponent(loginButton)
				);
		
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {loginAccountField, loginPasswordField});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {loginAccountField, loginPasswordField});
		
		pack();
	}
	
	private void initComponentsOperations() {
		
		viewMenuButton = new JButton();
		updateMenuButton = new JButton();
		
		viewMenuButton.setText("View menu.");
		updateMenuButton.setText("Update menu.");
		
		viewMenuButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				ViewMenuPage vmp = new ViewMenuPage();
				vmp.setVisible(true);
			}
		});
		
		updateMenuButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				UpdateMenuPage ump = new UpdateMenuPage();
				ump.setVisible(true);
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(viewMenuButton).addComponent(updateMenuButton));
		layout.setVerticalGroup(layout.createParallelGroup().addComponent(viewMenuButton).addComponent(updateMenuButton));
		
		pack();
		
	}
	
	private boolean correctCredentials(JTextField acc, JTextField pass) {
		boolean validAcc = acc.getText().trim().equals(account);
		boolean validPass = pass.getText().trim().equals(password);
		return validAcc && validPass;
	}
	
}
