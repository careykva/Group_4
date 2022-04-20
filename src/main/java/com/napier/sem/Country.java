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
        displayCountry(ctry);
    }

    public void displayCountry() {

    }


    public ArrayList<Country> getCountry() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String s = "FROM `country`";
            String strSelect =
                    "SELECT ctry.code, ctry.name, ctry.continent,    ctry.region, ctry.population ";
                             "`Where` `country`.`Region` = “Caribbean”
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

    public void displayCountries(ArrayList<Country> ctry {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s", "country.code", "country.name", "country.continent", "country.region", "country.population"));
        // Loop over all employees in the list
        for (CapitalCities cptl : cities) {
            String cty_string =
                    String.format("%-10s %-15s %-20s %-8s %-15s",
                            ctry.code, ctry.name, ctry.continent, ctry.region, ctry.population;
            System.out.println(cty_string);
        }
    }
/*
    public Object getCode() {
        return Code;
    }

    public void setCode(Object code) {
        this.code = Code;
    }

    public Object get Country() {
        return null;
    }

    public void setName(Object name) {
        this. Name = Name;
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

