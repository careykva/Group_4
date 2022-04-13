package com.napier.sem;


import java.sql.*;
import java.util.*;

public class Country {
    public String Code;
    public String Name;
    public String Continent;
    public String Region;
    public String Population;
    public String name;
    public Object capital;
    private String Country;
   /* private Object City;
    private Object city;
    private int id;
*/


    App a = new App();

    /*
    public void countryData(){
        ArrayList<Country> countries = getCountry(52);
        //displayCountry(countries);
    }


    private ArrayList<Country> getCountry(int i) {

    }
*/

    public ArrayList<City> getCity(int ID) {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECTID,Name,CountryCode,District "
                            + " FROM country "
                            + "WHERE ID = " + ID;
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City cty = new City();
                cty.id = rset.getInt("id");
                cty.name = rset.getString("name");
                cty.countryCode = rset.getString("CountryCode");
                cty.district = rset.getString("district");
                cities.add(cty);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }



    public void displayCity(ArrayList<City> cities) {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "id", "name", "countryCode", "district"));
        // Loop over all employees in the list
        for (City cty : cities) {
            String cty_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            cty.id, cty.name, cty.countryCode, cty.district);
            System.out.println(cty_string);
        }
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
/*
    public Object getFirst_name() {
        return id;
    }

    public void setFirst_name(Object first_name) {
        Object city = this.City;
    }

    public Object getCity() {
        return null;
    }

    public void setLast_name(Object last_name) {
        this. City = City;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 */
}
