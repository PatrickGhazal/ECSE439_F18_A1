package ca.mcgill.ecse439.pizzadeliverysystem.view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ca.mcgill.ecse439.pizzadeliverysystem.controller.InvalidInputException;
import ca.mcgill.ecse439.pizzadeliverysystem.controller.PDSController;

public class UpdateMenuPage extends JFrame {

	private static final long serialVersionUID = -4445693225959720661L;
	
	private String errorMessage;
	
	private JLabel explanationLabel, errorLabel;
	private JTextField nameField, calField, priceField, newNameField, newCalField, newPriceField;
	private JButton createButton, updateButton, deleteButton;

	public UpdateMenuPage() {
		initComponents();
	}

	private void initComponents() {

		explanationLabel = new JLabel();
		errorLabel = new JLabel();
		nameField = new JTextField();
		calField = new JTextField();
		priceField = new JTextField();
		newNameField = new JTextField();
		newCalField = new JTextField();
		newPriceField = new JTextField();
		createButton = new JButton();
		updateButton = new JButton();
		deleteButton = new JButton();

		String explanation = "";
		explanation += "<html>To create a pizza, fill the three first text fields with the name, calorie count, and price, respectively.<br>";
		explanation += "To update a pizza, fill the first field with the old name, and the three bottom fields for the new information.<br>";
		explanation += "To delete a pizza, use the first field for its name.<br></html>";
		explanationLabel.setText(explanation);
		
		errorMessage = "";
		errorLabel.setForeground(Color.RED);
		errorLabel.setText(errorMessage);

		createButton.setText("Create a pizza");
		updateButton.setText("Update a pizza");
		deleteButton.setText("Delete a pizza");
		
		setSize(850, 600);

		createButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createButtonActionPerformed();
			}
		});

		updateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateButtonActionPerformed();
			}
		});

		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed();
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup().addComponent(errorLabel).addComponent(explanationLabel).addComponent(nameField)
						.addComponent(newNameField))
				.addGroup(layout.createParallelGroup().addComponent(errorLabel).addComponent(explanationLabel).addComponent(calField)
						.addComponent(newCalField))
				.addGroup(layout.createParallelGroup().addComponent(errorLabel).addComponent(explanationLabel).addComponent(priceField)
						.addComponent(newPriceField))
				.addGroup(layout.createParallelGroup().addComponent(errorLabel).addComponent(explanationLabel).addComponent(createButton)
						.addComponent(updateButton).addComponent(deleteButton)));

		layout.setVerticalGroup(layout.createSequentialGroup().addComponent(errorLabel).addComponent(explanationLabel)
				.addGroup(layout.createParallelGroup().addComponent(nameField).addComponent(calField)
						.addComponent(priceField).addComponent(createButton))
				.addGroup(layout.createParallelGroup().addComponent(newNameField).addComponent(newCalField)
						.addComponent(newPriceField).addComponent(updateButton))
				.addComponent(deleteButton));
		
	}

	private void createButtonActionPerformed() {
		try {
			PDSController.createMenuPizza(nameField.getText(), Integer.parseInt(calField.getText()),
					Integer.parseInt(priceField.getText()));
			errorMessage = "";
		} catch (InvalidInputException e) {
			errorMessage = "Could not create pizza : " + e.getMessage();
		} catch (NumberFormatException e) {
			errorMessage = "Could not create pizza : missing data";
		}
		refreshData();
	}

	private void updateButtonActionPerformed() {
		try {
			PDSController.updateMenuPizza(nameField.getText(), newNameField.getText(),
					Integer.parseInt(newCalField.getText()), Integer.parseInt(newPriceField.getText()));
			errorMessage = "";
		} catch (InvalidInputException e) {
			errorMessage = "Could not update pizza : " + e.getMessage();
		} catch (NumberFormatException e) {
			errorMessage = "Could not update pizza : missing data";
		}
		refreshData();
	}

	private void deleteButtonActionPerformed() {
		try {
			PDSController.deleteMenuPizza(nameField.getText());
			errorMessage = "";
		} catch (InvalidInputException e) {
			errorMessage = "Could not delete pizza : " + e.getMessage();
		}
		refreshData();
	}
	
	private void refreshData() {
		errorLabel.setText(errorMessage);
		nameField.setText("");
		calField.setText("");
		priceField.setText("");
		newNameField.setText("");
		newCalField.setText("");
		newPriceField.setText("");
		setSize(850, 600);
	}

}
