/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse439.pizzadeliverysystem.model;
import java.util.*;

// line 64 "../../../../../PDS.ump"
public class DeliveryManager
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static DeliveryManager theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DeliveryManager Associations
  private List<Order> orders;
  private List<Ingredient> ingredients;
  private Menu menu;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private DeliveryManager()
  {
    orders = new ArrayList<Order>();
    ingredients = new ArrayList<Ingredient>();
    // line 73 "../../../../../PDS.ump"
    menu = new Menu();
    // END OF UMPLE AFTER INJECTION
  }

  public static DeliveryManager getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new DeliveryManager();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public Ingredient getIngredient(int index)
  {
    Ingredient aIngredient = ingredients.get(index);
    return aIngredient;
  }

  public List<Ingredient> getIngredients()
  {
    List<Ingredient> newIngredients = Collections.unmodifiableList(ingredients);
    return newIngredients;
  }

  public int numberOfIngredients()
  {
    int number = ingredients.size();
    return number;
  }

  public boolean hasIngredients()
  {
    boolean has = ingredients.size() > 0;
    return has;
  }

  public int indexOfIngredient(Ingredient aIngredient)
  {
    int index = ingredients.indexOf(aIngredient);
    return index;
  }

  public Menu getMenu()
  {
    return menu;
  }

  public boolean hasMenu()
  {
    boolean has = menu != null;
    return has;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    orders.add(aOrder);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    if (orders.contains(aOrder))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfIngredients()
  {
    return 0;
  }

  public boolean addIngredient(Ingredient aIngredient)
  {
    boolean wasAdded = false;
    if (ingredients.contains(aIngredient)) { return false; }
    ingredients.add(aIngredient);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIngredient(Ingredient aIngredient)
  {
    boolean wasRemoved = false;
    if (ingredients.contains(aIngredient))
    {
      ingredients.remove(aIngredient);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIngredientAt(Ingredient aIngredient, int index)
  {  
    boolean wasAdded = false;
    if(addIngredient(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredients()) { index = numberOfIngredients() - 1; }
      ingredients.remove(aIngredient);
      ingredients.add(index, aIngredient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIngredientAt(Ingredient aIngredient, int index)
  {
    boolean wasAdded = false;
    if(ingredients.contains(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredients()) { index = numberOfIngredients() - 1; }
      ingredients.remove(aIngredient);
      ingredients.add(index, aIngredient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIngredientAt(aIngredient, index);
    }
    return wasAdded;
  }

  public boolean setMenu(Menu aNewMenu)
  {
    boolean wasSet = false;
    menu = aNewMenu;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    orders.clear();
    ingredients.clear();
    menu = null;
  }

}