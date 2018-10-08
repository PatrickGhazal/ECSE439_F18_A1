/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse439.pizzadeliverysystem.model;
import java.util.*;

// line 87 "../../../../../PDS.ump"
public class Menu
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Menu Associations
  private List<Pizza> pizzas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Menu()
  {
    pizzas = new ArrayList<Pizza>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Pizza getPizza(int index)
  {
    Pizza aPizza = pizzas.get(index);
    return aPizza;
  }

  public List<Pizza> getPizzas()
  {
    List<Pizza> newPizzas = Collections.unmodifiableList(pizzas);
    return newPizzas;
  }

  public int numberOfPizzas()
  {
    int number = pizzas.size();
    return number;
  }

  public boolean hasPizzas()
  {
    boolean has = pizzas.size() > 0;
    return has;
  }

  public int indexOfPizza(Pizza aPizza)
  {
    int index = pizzas.indexOf(aPizza);
    return index;
  }

  public static int minimumNumberOfPizzas()
  {
    return 0;
  }

  public boolean addPizza(Pizza aPizza)
  {
    boolean wasAdded = false;
    if (pizzas.contains(aPizza)) { return false; }
    pizzas.add(aPizza);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePizza(Pizza aPizza)
  {
    boolean wasRemoved = false;
    if (pizzas.contains(aPizza))
    {
      pizzas.remove(aPizza);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPizzaAt(Pizza aPizza, int index)
  {  
    boolean wasAdded = false;
    if(addPizza(aPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPizzas()) { index = numberOfPizzas() - 1; }
      pizzas.remove(aPizza);
      pizzas.add(index, aPizza);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePizzaAt(Pizza aPizza, int index)
  {
    boolean wasAdded = false;
    if(pizzas.contains(aPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPizzas()) { index = numberOfPizzas() - 1; }
      pizzas.remove(aPizza);
      pizzas.add(index, aPizza);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPizzaAt(aPizza, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    pizzas.clear();
  }

}