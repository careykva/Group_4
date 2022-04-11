package com.napier.sem;


import java.sql.*;
import java.util.*;

public class CapitalCities {
    public String name;
    public String code;
    public String continent;
    public String population;
    public String region;
    public String capital;
    public String country;
   /* private Object City;
    private Object city;
    private int id;
*/


    App a = new App();

    public void allCapitalCities(){
        ArrayList<CapitalCities> cptl = getCapitalCities();
        displayCapitalCities(cptl);
    }

    public void displayCountry() {
    }


    public ArrayList<CapitalCities> getCapitalCities() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT cptl.Name, cptl.Code, cptl.Continent, cptl.Population, cptl.Region, cptl.Capital "
                            + "FROM country cptl "
                            + "order by cptl.Capital desc ";
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<CapitalCities> cities = new ArrayList<>();
            while (rset.next()) {
                CapitalCities cptl = new CapitalCities();
                cptl.name = rset.getString("name");
                cptl.continent = rset.getString("continent");
               /* cptl.population = rset.getString("population");*/
                cptl.region = rset.getString("region");
                cptl.capital = rset.getString("capital");
                cities.add(cptl);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital details");
            return null;
        }
    }

    public ArrayList<CapitalCities> getCities() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT cptl.Name, cptl.Code, cptl.Continent , cptl.Population, cptl.Region, cptl.Capital"
                            + " FROM country cptl "
                            + " order by cptl.capital desc"
                            + " GROUP BY cty.region";
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<CapitalCities> cities = new ArrayList<>();
            while (rset.next()) {
                CapitalCities cptl = new CapitalCities();
                cptl.name = rset.getString("name");
                cptl.code = rset.getString("code");
                cptl.continent = rset.getString("continent");
                cptl.region = rset.getString("region");
                cptl.country = rset.getString("country");
                cities.add(cptl);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCapitalCities(ArrayList<CapitalCities> cities) {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s", "id", "name", "code", "continent", "Region", "Capital"));
        // Loop over all employees in the list
        for (CapitalCities cptl : cities) {
            String cty_string =
                    String.format("%-10s %-15s %-20s %-8s %-15s",
                            cptl.name, cptl.code, cptl.continent, cptl.region, cptl.country, cptl.capital);
            System.out.println(cty_string);
        }
    }
/*
    public Object getFirst_name() {
        return id;
    }i drop off

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

    public static class Population{
    }
}
