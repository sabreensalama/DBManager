/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

/**
 *
 * @author hp
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Employee {

    int id;
    String firstName, middleName, lastName;
    String email, phone;
    public Employee()
    {
        
    }

    public Employee(int id, String firstName, String middleName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    

    void setId(int i) {
        id = i;

    }

    void setFirstName(String f) {
        firstName = f;

    }

    void setMiddleName(String f) {
        middleName = f;

    }

    void setLastName(String f) {
        lastName = f;

    }

    void setEmail(String f) {
        email = f;

    }

    void setPhone(String f) {
        phone = f;

    }
    
int getId()
{
  return id;
}
String getFirstName()
{
  return firstName;
}

String getMiddleName()
{
  return middleName;
}
String getLastName()
{
  return lastName;
}
String getEmail()
{
  return email;
}
String getPhone()
{
  return phone;
}

}
