package ca.mcgill.ecse439.pizzadeliverysystem.view;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ca.mcgill.ecse439.pizzadeliverysystem.application.PDSApplication;
import ca.mcgill.ecse439.pizzadeliverysystem.model.Pizza;

public class ViewMenuPage extends JFrame {

	private static final long serialVersionUID = -2153858275213066515L;
	
	private JLabel menuLabel;
	
	public ViewMenuPage() {
		initComponents();
	}
	
	private void initComponents() {
		
		menuLabel = new JLabel();
		String dispMenu = "<html>";
		for (Pizza pizza : PDSApplication.getDM().getMenu().getPizzas()) {
			String pizzaDisplay = pizza.getName() + "  |  " + pizza.getCalorieCount() + "cal  |  $" + pizza.getPrice();
			dispMenu += (pizzaDisplay + "<br>");
		}
		dispMenu += "</html>";
		menuLabel.setText(dispMenu);
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(menuLabel));
		layout.setVerticalGroup(layout.createParallelGroup().addComponent(menuLabel));
		
		pack();
	}
	
}
