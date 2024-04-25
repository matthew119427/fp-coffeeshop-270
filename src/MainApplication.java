import java.util.ArrayList;
import java.util.List;


public class MainApplication {
    public static void main(String[] args) {
        ArrayList<Employee> employees = EmployeeProcessor.processEmployees("EmployeeInfo.txt");

        System.out.println("==List of Employees==");
        for (Employee employee : employees) {
            System.out.printf("Employee Name: %s\n Employee ID: %d\n Employee Hourly Rate: $%.2f\n\n", employee.getName(), employee.getID(), employee.getRate());
        }

        System.out.println("\n==List of Transactions==");

        ArrayList<Transaction> transactions = DrinkProcessor.processOrders("Orders.txt", employees);

        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getID());
            System.out.println("Customer Name: " + transaction.getCalloutName());
            System.out.println("Employee Name: " + transaction.getTenderedBy().getName());
            System.out.println("Total Price: $" + transaction.determinePrice());
            System.out.println("Total Profit: $" + transaction.determineProfit());
            System.out.println("Total Cost: $" + transaction.determineCost());
            System.out.println("Drinks: ");
            for (Drink drink : transaction.getAssociatedItems()) {
                System.out.println("- " + drink.getDescription());
            }
            System.out.println();
        }
    }
}
