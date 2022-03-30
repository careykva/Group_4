import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class City {
    private Object first_name;
    public Object last_name;
    public String name;
    public String CountryCode;
    public String district;
    public int id;

    public City(String countryCode) {
        setCountryCode(countryCode);
    }

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
                String countryCode = new String();
                City cty = new City(countryCode);
                cty.setId(rset.getInt("id"));
                cty.setName(rset.getString("name"));
                cty.setCountryCode(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("district"));
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
                    cty.getId() + " "
                            + cty.getName() + " "
                            + cty.getCountryCode() + "\n"
                            + cty.getDistrict() + "\n");
            Object a = null;
            Object a1 = a;
        }
    }

    public Object getFirst_name() {
        return first_name;
    }

    public void setFirst_name(Object first_name) {
        this.first_name = first_name;
    }

    public Object getLast_name() {
        return last_name;
    }

    public void setLast_name(Object last_name) {
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
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
}
