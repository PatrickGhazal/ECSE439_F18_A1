package ca.mcgill.ecse439.pizzadeliverysystem.controller;

public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = -3642017336080702373L;

	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}

}
