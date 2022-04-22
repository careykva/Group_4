package com.napier.sem;


import java.sql.*;
import java.util.*;

public class Region {
    public String name;
    public String CountryCode;
    public String district;
    public String Population;
    public int id;
   /* private Object City;
    private Object city;
    private int id;
*/


    App a = new App();

    public void Regiondata(){
        ArrayList<Region> regn = getRegion();
        displayRegion(regn);
    }

    public void Region(){
        ArrayList<Region> regn = getRegion();
        displayRegion(regn);
    }


    public ArrayList<Region> getRegion() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT regn.Name, regn.country, regn.population "
                            + "FROM city cty "
                            + "order by regn.population desc";
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<Region> regn = new ArrayList<>();
            while (rset.next()) {
                Region reg = new Region();
                reg.ID = rset.getInt("id");
                reg.name = rset.getString("name");
                reg.countryCode = rset.getString("CountryCode");
                reg.district = rset.getString("district");
                regn.add(reg);
            }
            return reg;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get regn details");
            return null;
        }
    }

    public ArrayList<Region> getRegion() {
        try {
            // Create an SQL statement
            Connection con = a.connect();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT regn.id, regn.name, regn.countryCode, regn.District "
                            + "FROM city "
                            + "order by region desc"
                            + "GROUP BY regn.region";
            // Execute SQL statement
            ResultSet rset =  stmt.executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            ArrayList<Region> reg = new ArrayList<>();
            while (rset.next()) {
                Region regn = new Region();
                regn.id = rset.getInt("id");
                regn.name = rset.getString("name");
                regn.countryCode = rset.getString("CountryCode");
                regn.district = rset.getString("district");
                reg.add(regn);
            }
            return reg;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get regn details");
            return null;
        }
    }

    public void displayRegion(ArrayList<Region> reg) {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s", "id", "name", "countryCode", "district", "Region"));
        // Loop over all employees in the list
        for (Region regn : reg) {
            String reg_string =
                    String.format("%-10s %-15s %-20s %-8s %-15s",
                            regn.id, regn.name, regn.countryCode, regn.district);
            System.out.println(reg_string);
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

    public static class Region{
    }
}
