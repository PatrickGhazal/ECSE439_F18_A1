/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse439.pizzadeliverysystem.model;
import java.util.*;

// line 51 "../../../../../PDS.ump"
public class CustomPizza extends Pizza
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CustomPizza Attributes
  private int basePrice;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CustomPizza(String aName, int aCalorieCount, int aPrice, int aBasePrice)
  {
    super(aName, aCalorieCount, aPrice);
    basePrice = aBasePrice;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBasePrice(int aBasePrice)
  {
    boolean wasSet = false;
    basePrice = aBasePrice;
    wasSet = true;
    return wasSet;
  }

  public int getBasePrice()
  {
    return basePrice;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "basePrice" + ":" + getBasePrice()+ "]";
  }
}