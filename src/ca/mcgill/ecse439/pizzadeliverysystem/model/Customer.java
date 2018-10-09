/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse439.pizzadeliverysystem.model;
import java.io.Serializable;

// line 67 "../../../../../PDS.ump"
public class Customer implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String name;
  private String delAddress;
  private String contact;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aName, String aDelAddress, String aContact)
  {
    name = aName;
    delAddress = aDelAddress;
    contact = aContact;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDelAddress(String aDelAddress)
  {
    boolean wasSet = false;
    delAddress = aDelAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setContact(String aContact)
  {
    boolean wasSet = false;
    contact = aContact;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getDelAddress()
  {
    return delAddress;
  }

  public String getContact()
  {
    return contact;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "delAddress" + ":" + getDelAddress()+ "," +
            "contact" + ":" + getContact()+ "]";
  }
}