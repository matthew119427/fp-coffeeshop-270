import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

/**
 * Represents a processor for reading and processing drink orders from a file and serializing data into Transaction objects.
 */
public class DrinkProcessor {
    /**
     * This method reads the Orders.txt file and serializes the data into Drink objects.
     * Drink objects are then used to create Transaction objects which hold the drinks and the employee who processed the transaction.
     * @param filePath the path to the Orders.txt file
     * @param employees the list of employees
     * @return the list of transactions
     */
    public static ArrayList<Transaction> processOrders(String filePath, ArrayList<Employee> employees) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        File fileObj = new File(filePath);
        try (Scanner scanner = new Scanner(fileObj)) {
            int numTransactions = 0;
            int transactionLines = 0;
            if (scanner.hasNextLine()) {
                numTransactions = Integer.parseInt(scanner.nextLine().trim());
                System.out.printf("Number of transactions: %d\n", numTransactions);
            }
            for (int i = 0; i < numTransactions; i++) {
                if (scanner.hasNextLine()) transactionLines = Integer.parseInt(scanner.nextLine().trim());
                int employeeID = Integer.parseInt(scanner.nextLine().trim());
                String calloutName = scanner.nextLine();
                Employee employee = null;
                for (Employee emp : employees) {
                    if (emp.getID() == employeeID) {
                        employee = emp;
                        break;
                    }
                }
                if (employee == null) {
                    System.out.printf("Employee ID %s was not located.\n", employeeID);
                    continue;
                }
                ArrayList<Drink> drinks = new ArrayList<>();
                for (int j = 0; j < transactionLines - 2; j++) {
                    String[] lines = scanner.nextLine().split(":");
                    char drinkType = lines[0].charAt(0);
                    char size = lines[1].charAt(0);
                    int numShotsOrBags = Integer.parseInt(lines[2].trim());
                    boolean milk = lines[3].equals("Y");
                    boolean iced = lines[4].equals("Y");
                    boolean syrup = lines[5].equals("Y");
                    Drink drink;
                    if (drinkType == 'C') {
                        drink = new Coffee(size, milk, iced, syrup, numShotsOrBags);
                    } else {
                        drink = new Tea(size, milk, iced, syrup, numShotsOrBags);
                    }
                    drinks.add(drink);
                }
                Transaction transaction = new Transaction(calloutName, (int) Math.round(Math.random()), employee, drinks);
                transactions.add(transaction);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
          return transactions;
    }
}
