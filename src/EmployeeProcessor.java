import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeProcessor {
    /**
     * This function reads the EmployeeInfo.txt file and serializes the data into Employee objects.
     * @return the list of employees
     */
    public static ArrayList<Employee> processEmployees(String filePath) {
        ArrayList<Employee> employees = new ArrayList<>();
        File fileObj = new File(filePath);
        try (Scanner scanner = new Scanner(fileObj)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                // employee fields in text file are delimited by a ':'
                String[] parts = line.split(":");
                if (parts.length != 3) {
                    System.out.println("Incorrect data format: " + line);
                    continue;
                }

                String name = parts[0];
                int id = Integer.parseInt(parts[1]);
                double hourlyRate = Double.parseDouble(parts[2]);

                // instantiate a new Employee object
                Employee employee = new Employee(name, id, hourlyRate);

                // add employee to the ArrayList that we are returning
                employees.add(employee);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Employees file not found");
            e.printStackTrace();
        }
        return employees;
    }
}
