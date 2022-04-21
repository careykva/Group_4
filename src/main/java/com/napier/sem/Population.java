package com.napier.sem;


import java.sql.*;
import java.util.*;

public class Population {
    public String code;
    public String name;
    public String continent;
    public String region;
    public int population;


    App a = new App();

    public void PopulationData() {
        ArrayList<Population> pop = getPopulation();
        displayPopulation(pop);
    }

    public  void displayAllPopulation () {
        ArrayList<Population> pop = getAllPopulation();
        displayPopulation(pop);
    }



    public ArrayList<Population> getPopulation() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT pop.code, pop.Name, pop.continent, pop.Region, pop.Population "
                            + "FROM population pop "
                            + "Order by pop.Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<Population> population = new ArrayList<>();
            while (rset.next()) {
                Population popl = new Population();
                popl.code = rset.getString("code");
                popl.name = rset.getString("name");
                popl.continent = rset.getString("continent");
                popl.region = rset.getString("region");
                popl.population = rset.getInt("population");
                population.add(popl);
            }
            return population;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<Population> getAllPopulation() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT popl.code, popl.name, popl.Continent, popl.Region, popl.Population "
                            + "FROM country popl "
                            + "ORDER BY popl.Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<Population> population = new ArrayList<>();
            while (rset.next()) {
                Population popl = new Population();
                popl.code = String.valueOf(rset.getInt("Code"));
                popl.name = rset.getString("Name");
                popl.continent = rset.getString("Continent");
                popl.region = rset.getString("Region");
                popl.population = rset.getInt("Population");
                population.add(popl);
            }
            return population;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public void displayPopulation(ArrayList<Population> popl) {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s", "code", "name", "continent", "region", "population"));
        // Loop over all employees in the list
        for (Population pop : popl) {
            String pop_string =
                    String.format("%-10s %-15s %-20s %-8s %-15s",
                            pop.code, pop.name, pop.continent, pop.region, pop.population);
            System.out.println(pop_string);
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

    public static class population {
    }
}