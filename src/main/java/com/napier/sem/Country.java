package com.napier.sem;


import java.sql.*;
import java.util.*;

public class Country {
    public String code;
    public String name;
    public String continent;
    public String region;
    public int population;

    /*private String Country;
    /*private Object country;
    private int id;
*/

    App a = new App();

    public void allCountry(){
        ArrayList<Country> ctry = getCountry();
        displayCountry();
    }

    public void displayCountry() {

    }


    public ArrayList<Country> getCountry() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ctry.code, ctry.name, ctry.continent, ctry.region, ctry.population ";
                new StringBuilder()
                        .append("FROM country")
                        .append("Order by ctrl.Region desc ").toString();
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new contry if valid.
             Check one is returned
            */
            ArrayList<Country> country = new ArrayList<>();
            while (rset.next()) {
                Country ctry = new Country();
                ctry.code = rset.getString("code");
                        ctry.name = rset.getString("name");
                ctry.continent = rset.getString("continent");
                ctry.region = rset.getString("region");
                ctry.population = rset.getInt("population");
                country.add(ctry);
            }
            return country;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<Country> getCountryInRegion() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT cty.ID, cty.Name, cty.CountryCode, cty.District "
                            + "FROM city cty "
                            + "order by cty.population desc"
                            + "GROUP BY cty.region";
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new country if valid.
             Check one is returned
            */
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country ctry = new Country();
                ctry.code = rset.getString("code");
                        ctry.name = rset.getString("name");
                ctry.continent = rset.getString("continent");
                ctry.region = rset.getString("region");
                ctry.population = rset.getInt("population");
                countries.add(ctry);

            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountry(ArrayList<Country>ctry){
        /* Print header */
        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s", "country.code", "country.name", "country.continent", "country.region", "country.population"));
        // Loop over all employees in the list
        for (Country cptl : ctry) {
            String cty_string;
            cty_string = String.format("%-10s %-15s %-20s %-8s %-15s",
                    getCountry());
            System.out.println(getCountryInRegion());
        }
    }
/*
    public Object getCountry.Code() {
        return Country.Code;
    }

    public void set Country.Code(Object country.code) {
        this.Country.code = Country.Code;
    }

    public String get Country.Name() {
        return Country.Name;
    }

    public void setCountry.Name(Object country.name) {
        this. Country.Name = Country.Name;
    }

    public String getCountry.Continent() {
        return Country.Continent;
    }

    public void setCountry.Continent(String country.continent) {
        this.country.continent = country.continent;
    }

    public String getCountry.Region() {
        return country.region;
    }

    public void setCountry.Region(String country.region) {
        this.country.region = country.region;
    }

    public Int getCountry.Population() {
        return country.population;
    }

    public void setCountry.Population(Int country.population) {
        this.country.population = country.population;
    }


 */

    public static class Population{
    }
}

