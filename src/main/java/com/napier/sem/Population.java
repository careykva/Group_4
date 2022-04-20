package com.napier.sem;


import java.sql.*;
import java.util.*;

public class Country {
    public String Code;
    public String Name;
    public String Continent;
    public String Region;
    public int Population;


    App a = new App();

    public void countryData() {
        ArrayList<Country> cnty = getCountry();
        displayCountry(cnty);
    }

    public void countryInRegion() {
        ArrayList<Country> cnty = getCountryInRegion();
        displayCountry(cnty);
    }


    public ArrayList<Country> getCountry() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT cnty.Code, cnty.Name, cnty.Continent, cnty.Region, cnty.Population "
                            + "FROM country cnty "
                            + "order by cnty.population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<Country> Countries = new ArrayList<>();
            while (rset.next()) {
                Country cnty = new Country();
                cnty.Code = rset.getString("Code");
                cnty.Name = rset.getString("Name");
                cnty.Continent = rset.getString("Continent");
                cnty.Region = rset.getString("Region");
                cnty.Population = rset.getInt("Population");
                Countries.add(cnty);
            }
            return Countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
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
                    "SELECT cnty.Code, cnty.Name, cnty.Continent, cnty.Region, cnty.Population "
                            + "FROM country cnty "
                            + "order by cnty.population desc"
                            + "GROUP BY cnty.Population";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<Country> Countries = new ArrayList<>();
            while (rset.next()) {
                Country cnty = new Country();
                cnty.Code = String.valueOf(rset.getInt("Code"));
                cnty.Name = rset.getString("Name");
                cnty.Continent = rset.getString("Continent");
                cnty.Region = rset.getString("Region");
                cnty.Population = rset.getInt("Population");
                Countries.add(cnty);
            }
            ArrayList<Country> cnty;
            return Countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cnty details");
            return null;
        }
    }

    public void displayCountry(ArrayList<Country> cnty) {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s", "code", "name", "continent", "region", "population"));
        // Loop over all employees in the list
        for (Country countries : cnty) {
            String cnty_string =
                    String.format("%-10s %-15s %-20s %-8s %-15s",
                            countries.Code, countries.Name, countries.Continent, countries.Region, countries.Population);
            System.out.println(cnty_string);
        }
    }
/*
    public Object getFirst_name() {
        return id;
    }

    public void setFirst_name(Object first_name) {
        Object country = this.Country;
    }

    public Object getCountry() {
        return null;
    }

    public void setLast_name(Object last_name) {
        this. Country = Country;
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

    public static class Population {
    }
}