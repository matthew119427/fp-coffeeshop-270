/**
 * Represents an employee in the coffee shop.
 * @see CostBehavior
 * @version 2
 */
public class Employee implements CostBehavior {
    /**
     * The name of the employee.
     */
    private final String name;
    /**
     * The ID of the employee.
     */
    private final int id;
    /**
     * The hourly rate of the employee.
     */
    private double hourlyRate;

    /**
     * Constructor for the Employee class.
     * @param name the name of the employee
     * @param id the ID of the employee
     * @param hourlyRate the hourly rate of the employee
     * @throws IllegalArgumentException if the name is empty, the ID is negative, or the hourly rate is negative
     */
    public Employee(String name, int id, double hourlyRate) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Employee name must be at least one character long.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("Employee ID must be a positive integer.");
        }
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Employee hourly rate must be a positive number.");
        }
        this.name = name;
        this.id = id;
        this.hourlyRate = hourlyRate;
    }

    /**
     * @return the hourly rate of the employee
     */
    public double getRate() {
        return this.hourlyRate;
    }

    /**
     * @return the name of the employee
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the ID of the employee
     */
    public int getID() {
        return this.id;
    }

    /**
     * @param rate the new hourly rate of the employee
     */
    public void setRate(double rate) {
        this.hourlyRate = rate;
    }

    /**
     * @return the cost of the employee
     * @see Employee#getRate()
     */
    @Override
    public double determineCost() { //TODO: Fully implement this method.
        return this.getRate();
    }

    @Override
    public double determineProfit() { //TODO: Fully implement this method.
        return 0;
    }
}
