import java.util.ArrayList;
import java.lang.Math;

/**
 * Represents a transaction entered by an employee at the coffee shop.
 * @see CostBehavior
 * @version 2
 */
public class Transaction implements CostBehavior {
    /**
     * The name of the customer who made the transaction.
     */
    private final String calloutName;
    /**
     * The employee who processed the transaction.
     */
    private final Employee tenderedBy;
    /**
     * The unique identifier of the transaction.
     */
    private final int id;
    /**
     * The drinks associated with the transaction.
     */
    private final ArrayList<Drink> associatedItems;

    /**
     * Constructor for the Transaction class.
     * @param customerName the name of the customer who made the transaction
     * @param id the unique identifier of the transaction
     * @param tenderingEmployee the employee who processed the transaction
     * @param associatedItems the drink objects associated with the transaction
     * @throws IllegalArgumentException if the customer name is empty, the ID is negative, or the associated items array is empty
     */
    public Transaction(String customerName, int id, Employee tenderingEmployee, ArrayList<Drink> associatedItems) {
        if (customerName.isEmpty()) {
            throw new IllegalArgumentException("Customer name must be at least one character long.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("Transaction ID must be a positive integer.");
        }
        if (associatedItems.isEmpty()) {
            throw new IllegalArgumentException("Transaction must have at least one associated drink.");
        }
        this.calloutName = customerName;
        this.tenderedBy = tenderingEmployee;
        this.id = id;
        this.associatedItems = associatedItems;
    }

    /**
     * @return the name of the customer who made the transaction
     */
    public String getCalloutName() {
        return this.calloutName;
    }

    /**
     * @return the employee who processed the transaction
     */
    public Employee getTenderedBy() {
        return this.tenderedBy;
    }

    /**
     * @return the unique identifier of the transaction
     */
    public int getID() {
        return this.id;
    }

    /**
     * @return the drinks associated with the transaction
     */
    public ArrayList<Drink> getAssociatedItems() {
        return this.associatedItems;
    }

    /**
     * This method determines the operational cost, or total cost to the company, for producing this transaction.
     * @return the operational cost of the transaction
     */
    @Override
    public double determineCost() {
        double cost = 0;
        for (Drink drink : this.associatedItems) {
            cost += drink.determineCost();
        }
        return cost;
    }

    /**
     * This method determines the profit for the company from this transaction.
     * @return the profit of the transaction
     */
    @Override
    public double determineProfit() {
        double cost = 0;
        for (Drink drink : this.associatedItems) {
            cost += drink.determineProfit();
        }
        return Math.round(cost);
    }

    public double determinePrice() {
        double price = 0;
        for (Drink drink : this.associatedItems) {
            price += drink.determinePrice();
        }
        return Math.round(price);
    }
}
