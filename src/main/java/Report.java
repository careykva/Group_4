import com.napier.sem.City;

import java.util.ArrayList;

/**
 * Prints a list of employees.
 */


public class Report {
    public void City(ArrayList<City> City) {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
        // Loop over all employees in the list
        for (com.napier.sem.City cty : City) {
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            cty.getId(), cty.getFirst_name(), cty.getCity(), cty.getId());
            char cty_string = 0;
            System.out.println(cty_string);
        }
    }
}