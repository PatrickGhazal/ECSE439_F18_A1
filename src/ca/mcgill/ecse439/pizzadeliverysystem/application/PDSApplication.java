package ca.mcgill.ecse439.pizzadeliverysystem.application;

import ca.mcgill.ecse439.pizzadeliverysystem.model.DeliveryManager;
import ca.mcgill.ecse439.pizzadeliverysystem.persistence.PersistenceObjectStream;
import ca.mcgill.ecse439.pizzadeliverysystem.view.DeliveryManagerPage;

public class PDSApplication {
	
	private static DeliveryManager dm;
	private static String filename = "data.dm";
	
	public static void main(String[] args) {
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliveryManagerPage().setVisible(true);
            }
        });
        
	}

	public static DeliveryManager getDM() {
		if (dm == null) {
			// load model
			dm = load();
		}
 		return dm;
	}
	
	public static void save(DeliveryManager newDM) {
		PersistenceObjectStream.serialize(newDM);
	}
	
	public static DeliveryManager load() {
		PersistenceObjectStream.setFilename(filename);
		dm = (DeliveryManager) PersistenceObjectStream.deserialize();
		// model cannot be loaded - create empty DeliveryManager
		if (dm == null) {
			dm = DeliveryManager.getInstance();
		}
		return dm;
	}
	
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}
	
}
