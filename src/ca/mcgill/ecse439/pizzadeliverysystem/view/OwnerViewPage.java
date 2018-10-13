package ca.mcgill.ecse439.pizzadeliverysystem.view;

import java.awt.Color;

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
	private JLabel loginLabel, errorLabel;
	private JTextField loginAccountField, loginPasswordField;
	private JButton loginButton;
	
	private String errorMessage;

	// for operating page
	private JButton viewMenuButton, updateMenuButton;

	public OwnerViewPage() {
		if (!hasLoggedIn) {
			initComponentsLogIn();
		} else {
			initComponentsOperations();
		}
	}

	private void initComponentsLogIn() {

		loginLabel = new JLabel();
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		loginAccountField = new JTextField();
		loginPasswordField = new JTextField();
		loginButton = new JButton();
		
		errorMessage = "";

		loginLabel.setText("Enter your username and password.");
		errorLabel.setText(errorMessage);
		loginButton.setText("Log in");

		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (correctCredentials(loginAccountField, loginPasswordField)) {
					hasLoggedIn = true;
					remove(loginLabel);
					remove(errorLabel);
					remove(loginAccountField);
					remove(loginPasswordField);
					remove(loginButton);
					initComponentsOperations();
				} else {
					errorMessage = "Incorrect credentials !";
					refreshData();
				}
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup().addComponent(errorLabel).addComponent(loginLabel).addComponent(loginAccountField))
				.addComponent(loginPasswordField)
				.addComponent(loginButton));
		
		layout.setVerticalGroup(layout.createSequentialGroup().addComponent(errorLabel).addComponent(loginLabel)
				.addGroup(layout.createParallelGroup().addComponent(loginAccountField).addComponent(loginPasswordField).addComponent(loginButton))
				);
		
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {loginAccountField, loginPasswordField, loginButton});
		
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

		layout.setHorizontalGroup(
				layout.createSequentialGroup().addComponent(viewMenuButton).addComponent(updateMenuButton));
		layout.setVerticalGroup(
				layout.createParallelGroup().addComponent(viewMenuButton).addComponent(updateMenuButton));

		pack();

	}

	private boolean correctCredentials(JTextField acc, JTextField pass) {
		boolean validAcc = acc.getText().trim().equals(account);
		boolean validPass = pass.getText().trim().equals(password);
		return validAcc && validPass;
	}
	
	private void refreshData() {
		loginAccountField.setText("");
		loginPasswordField.setText("");
		errorLabel.setText(errorMessage);
		pack();
	}

}
