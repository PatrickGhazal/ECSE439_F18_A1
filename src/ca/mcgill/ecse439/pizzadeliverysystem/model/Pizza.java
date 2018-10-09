/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse439.pizzadeliverysystem.model;
import java.io.Serializable;
import java.util.*;

// line 5 "../../../../../PDS.ump"
public class Pizza implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Pizza Attributes
  private String name;
  private int calorieCount;
  private int price;

  //Pizza Associations
  private List<Ingredient> ingredients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Pizza(String aName, int aCalorieCount, int aPrice)
  {
    // line 18 "../../../../../PDS.ump"
    if (aName == null || aName.trim().equals("")) {
      		throw new RuntimeException("Please provide a valid name.");
      	}
      	if (aCalorieCount <= 0) {
      		throw new RuntimeException("Please provide a valid calorie count (non-zero positive integer).");
      	}
      	if (aPrice <= 0) {
      		throw new RuntimeException("Please provide a valid price (non-zero positive integer).");
      	}
    // END OF UMPLE BEFORE INJECTION
    name = aName;
    calorieCount = aCalorieCount;
    price = aPrice;
    ingredients = new ArrayList<Ingredient>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    // line 30 "../../../../../PDS.ump"
    if (aName == null || aName.trim().equals("")) {
      		return false;
      	}
    // END OF UMPLE BEFORE INJECTION
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCalorieCount(int aCalorieCount)
  {
    boolean wasSet = false;
    // line 35 "../../../../../PDS.ump"
    if (aCalorieCount <= 0) {
      		return false;
      	}
    // END OF UMPLE BEFORE INJECTION
    calorieCount = aCalorieCount;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(int aPrice)
  {
    boolean wasSet = false;
    // line 40 "../../../../../PDS.ump"
    if (aPrice <= 0) {
      		return false;
      	}
    // END OF UMPLE BEFORE INJECTION
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getCalorieCount()
  {
    return calorieCount;
  }

  public int getPrice()
  {
    return price;
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

  public void delete()
  {
    ingredients.clear();
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "calorieCount" + ":" + getCalorieCount()+ "," +
            "price" + ":" + getPrice()+ "]";
  }
}