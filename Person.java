/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 *
 * @author Darkphoenix
 */
public class Person {
    private String fname, lname, address, city, province, postalCode;
    private LocalDate bday;
    
    //A constructor to that should accept the following arguments in order; 
    //first name, last name, street address, city, province, postal code, and birthdate. 
    
    public Person(String first, String last,String address, String city, String province, String postal, LocalDate dob)
    {
        this.fname = first;
        this.lname = last;
        this.address = address;
        this.city = city;
        this.province = province;
        setPostal(postal);
        bday = dob;
    }
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }
    
    /* // The set method for the postalCode must validate that 6 characters were entered.
        //Any number of characters outside of 6, should through an illegal argument exception.
        This method does ^
    */
    public void setPostal(String postal)
    {
         //The postal code should be validated to contain exactly 6 characters.
        //There is 2 bonus marks if you can ensure that the pattern of  [letter][number][letter][number][letter][number] is used.
        String match = "^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$";
        if(postal.length()== 6 && postal.matches(match))
        {
            this.postalCode = postal; 
        }
        //If it does not have 6 characters, an IllegalArgumentException should be thrown.
        else
            throw new IllegalArgumentException("Has to be 6 characters and match --> L9B2K5");
        
        
    }
    //Set methods for each instance variable
    //Get methods for each instance variable
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public LocalDate getBday() {
        return bday;
    }
    
     //A method called getAge that returns the current age of the person in years
    public int getAge()
    {
        LocalDate today = LocalDate.now();
        int age = Period.between(bday, today).getYears();
        
        return age;
    }
       
    //A method called getFullAddress that returns the address in the form of: street address, city, province, postal code
    public String getFullAddress(String address, String city, String province, String postalCode)
    {
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        String fullAddress = address + ", " + city + ", "  + province + ", "  + postalCode;
        return fullAddress;
    }
    public int getYearBorn()
    {
//        Calendar year = Calendar.getInstance();
        //LocalDate today = LocalDate.now();
        int yr = getBday().getYear();
//        
        //int yearborn = yr - getAge() ;
        return yr;
    }

    
}
