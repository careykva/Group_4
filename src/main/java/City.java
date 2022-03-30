import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class City {
    public Object first_name;
    public Object last_name;
    int id;
    private String name;
    private String CountryCode;
    private String district;
    private int id;

    public City(String countryCode) {
        CountryCode = countryCode;
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
                cty.id = rset.getInt("id");
                cty.name = rset.getString("name");
                cty.CountryCode = rset.getString("CountryCode");
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
                    cty.id + " "
                            + cty.name + " "
                            + cty.CountryCode + "\n"
                            + cty.district + "\n");
            Object a = null;
            Object a1 = a;
        }
    }
}