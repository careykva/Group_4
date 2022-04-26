package com.napier.sem;


import java.sql.*;
import java.util.*;

public class PopulatedCites {
    public String name;
    public String district;
    public String Population;
    public String region;
    public int id;
   /* private Object PopulatedCities;
    private Object PopulatedCites;
    private int id;
*/

    App a = new App();

    public void populatedcitiesData(){
        ArrayList<PopulatedCities> pcty = getPopulatedCities();
        displayPopulatedCities (pcty);
    }

    public void populatedcities(){
        ArrayList<Popluatedcitiesy> pcty = getPopulatedCites();
        displayPopulatedCites(pcty);
    }


    public ArrayList<City> getCity() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT cities.ID, cities.Name, cities.CountryCode, cities.District, cities.Population "
                            + "FROM city cities"
                            + "order by cities.population desc";
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new city if valid.
             Check one is returned
            */
            ArrayList<City> cities = new ArrayList();
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

    public ArrayList<City> getCityInRegion() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT cty.ID, cty.Name, cty.CountryCode, cty.District, cty.Population "
                            + "FROM city cty "
                            + "order by cty.population desc"
                            + "GROUP BY cty.region";
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<City> cities = new ArrayList();
            while (rset.next()) {
                City cty = new City();
                cty.id = rset.getInt("id");
                cty.name = rset.getString("name");
                cty.countryCode = rset.getString("CountryCode");
                cty.district = rset.getString("district");
                cty.region = rset.getString("region");
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
        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s", "id", "name", "countryCode", "district", "Region"));
        // Loop over all employees in the list
        for (City cty : cities) {
            String cty_string =
                    String.format("%-10s %-15s %-20s %-8s %-15s",
                            cty.id, cty.name, cty.countryCode, cty.district, cty.region);
            System.out.println(cty_string);
        }
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

    public static class Population{
    }
}
