/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse439.pizzadeliverysystem.model;
import java.io.Serializable;
import java.util.*;

// line 96 "../../../../../PDS.ump"
public class Order implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int totalAmount;
  private boolean delivered;

  //Autounique Attributes
  private int id;

  //Order Associations
  private List<Pizza> orderedPizzas;
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(int aTotalAmount, boolean aDelivered, Customer aCustomer)
  {
    totalAmount = aTotalAmount;
    delivered = aDelivered;
    id = nextId++;
    orderedPizzas = new ArrayList<Pizza>();
    if (!setCustomer(aCustomer))
    {
      throw new RuntimeException("Unable to create Order due to aCustomer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTotalAmount(int aTotalAmount)
  {
    boolean wasSet = false;
    totalAmount = aTotalAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setDelivered(boolean aDelivered)
  {
    boolean wasSet = false;
    delivered = aDelivered;
    wasSet = true;
    return wasSet;
  }

  public int getTotalAmount()
  {
    return totalAmount;
  }

  public boolean getDelivered()
  {
    return delivered;
  }

  public int getId()
  {
    return id;
  }

  public Pizza getOrderedPizza(int index)
  {
    Pizza aOrderedPizza = orderedPizzas.get(index);
    return aOrderedPizza;
  }

  public List<Pizza> getOrderedPizzas()
  {
    List<Pizza> newOrderedPizzas = Collections.unmodifiableList(orderedPizzas);
    return newOrderedPizzas;
  }

  public int numberOfOrderedPizzas()
  {
    int number = orderedPizzas.size();
    return number;
  }

  public boolean hasOrderedPizzas()
  {
    boolean has = orderedPizzas.size() > 0;
    return has;
  }

  public int indexOfOrderedPizza(Pizza aOrderedPizza)
  {
    int index = orderedPizzas.indexOf(aOrderedPizza);
    return index;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public static int minimumNumberOfOrderedPizzas()
  {
    return 0;
  }

  public boolean addOrderedPizza(Pizza aOrderedPizza)
  {
    boolean wasAdded = false;
    if (orderedPizzas.contains(aOrderedPizza)) { return false; }
    orderedPizzas.add(aOrderedPizza);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrderedPizza(Pizza aOrderedPizza)
  {
    boolean wasRemoved = false;
    if (orderedPizzas.contains(aOrderedPizza))
    {
      orderedPizzas.remove(aOrderedPizza);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderedPizzaAt(Pizza aOrderedPizza, int index)
  {  
    boolean wasAdded = false;
    if(addOrderedPizza(aOrderedPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderedPizzas()) { index = numberOfOrderedPizzas() - 1; }
      orderedPizzas.remove(aOrderedPizza);
      orderedPizzas.add(index, aOrderedPizza);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderedPizzaAt(Pizza aOrderedPizza, int index)
  {
    boolean wasAdded = false;
    if(orderedPizzas.contains(aOrderedPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderedPizzas()) { index = numberOfOrderedPizzas() - 1; }
      orderedPizzas.remove(aOrderedPizza);
      orderedPizzas.add(index, aOrderedPizza);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderedPizzaAt(aOrderedPizza, index);
    }
    return wasAdded;
  }

  public boolean setCustomer(Customer aNewCustomer)
  {
    boolean wasSet = false;
    if (aNewCustomer != null)
    {
      customer = aNewCustomer;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    orderedPizzas.clear();
    customer = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "totalAmount" + ":" + getTotalAmount()+ "," +
            "delivered" + ":" + getDelivered()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}