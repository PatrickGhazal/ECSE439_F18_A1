package ca.mcgill.ecse439.pizzadeliverysystem.controller;

import ca.mcgill.ecse439.pizzadeliverysystem.application.PDSApplication;
import ca.mcgill.ecse439.pizzadeliverysystem.model.DeliveryManager;
import ca.mcgill.ecse439.pizzadeliverysystem.model.MenuPizza;
import ca.mcgill.ecse439.pizzadeliverysystem.model.Pizza;

public class PDSController {

	private static DeliveryManager dm;

	public PDSController() {
		dm = PDSApplication.getDM();
	}

	public static void createMenuPizza(String name, int calCount, int price) throws InvalidInputException {
		dm = PDSApplication.getDM();
		try {
			MenuPizza pizza = new MenuPizza(name, calCount, price);
			dm.getMenu().addPizza(pizza);
			PDSApplication.save(dm);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	public static void updateMenuPizza(String oldName, String newName, int newCalCount, int newPrice)
			throws InvalidInputException {
		dm = PDSApplication.getDM();
		try {
			for (Pizza p : dm.getMenu().getPizzas()) {
				if (p.getName().equals(oldName)) {
					p.setName(newName);
					p.setCalorieCount(newCalCount);
					p.setPrice(newPrice);
					break;
				}
			}
			PDSApplication.save(dm);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	public static void deleteMenuPizza(String name) throws InvalidInputException {
		dm = PDSApplication.getDM();
		Pizza toDelete = null;
		for (Pizza p : dm.getMenu().getPizzas()) {
			if (p.getName().equals(name)) {
				toDelete = p;
				break;
			}
		}
		if (toDelete != null) {
			try {
				dm.getMenu().removePizza(toDelete);
				toDelete.delete();
				PDSApplication.save(dm);
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}

		} else {
			throw new InvalidInputException("No such pizza !");
		}
	}
}