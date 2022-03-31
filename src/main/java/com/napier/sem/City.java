package com.napier.sem;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class City {
    public String name;
    public String countryCode;
    public String district;
    public int id;
    private Object City;
    private Object city;


    public City getCity(int ID) {
        try {
            // Create an SQL statement
            Connection con = null;
            Statement stmt = (Statement) con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT id, name, CountryCode, district"
                            + "FROM city"
                            + "WHERE id = " + ID;
            // Execute SQL statement
            ResultSet rset = ((java.sql.Statement) stmt).executeQuery(strSelect);
            /*
             Return new employee if valid.
             Check one is returned
            */
            if (rset.next()) {
                City cty = new City();
                cty.id = rset.getInt("id");
                cty.name = rset.getString("name");
                cty.countryCode = rset.getString("CountryCode");
                cty.district = rset.getString("district");
                return cty;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public void displayCity(City cty) {
        if (cty != null) {
            System.out.println(
                    cty.id  + " "
                            + cty.name + " "
                            + cty.countryCode + "\n"
                            + cty.district + "\n");
            Object a = null;
            Object a1 = a;
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
}
