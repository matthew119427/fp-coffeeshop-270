/**
 * This class is the parent class for all drinks. It implements the CostBehavior interface and has abstract methods that will be overridden in its concrete subclasses.
 */
public abstract class Drink implements CostBehavior {
	/**
	 * The size of the drink.
	 */
	 char size;
	/**
	 * If the drink has milk.
	 */
	 boolean milk;
	/**
	 * If the drink is iced.
	 */
	 boolean iced;
	/**
	 * If the drink has syrup.
	 */
	 boolean syrup;

	/**
	 * @param S size of the drink
	 * @param M if the drink has milk
	 * @param I if the drink is iced
	 * @param Y if the drink has syrup
	 */
	 public Drink(char S, boolean M, boolean I, boolean Y) {
		 size = S;
		 milk = M;
		 iced= I;
		 syrup = Y;
	 }

	/**
	 * Getter for Drink#size
	 * @return the size of the drink
	 */
	public char getSize() {
		return size;
	}

	/**
	 * Setter for Drink#size
	 * @param size the size of the drink
	 */
	public void setSize(char size) {
		this.size = size;
	}

	/**
	 * Getter for Drink#milk
	 * @return if the drink has milk
	 */
	public boolean getMilk() {
		return milk;
	}

	/**
	 * Setter for Drink#milk
	 * @param milk if the drink has milk
	 */
	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	/**
	 * Getter for Drink#iced
	 * @return if the drink is iced
	 */
	public boolean getIced() {
		return iced;
	}

	/**
	 * Setter for Drink#iced
	 * @param iced if the drink is iced
	 */
	public void setIced(boolean iced) {
		this.iced = iced;
	}

	/**
	 * Getter for Drink#syrup
	 * @return if the drink has syrup
	 */
	public boolean getSyrup() {
		return syrup;
	}

	/**
	 * Setter for Drink#syrup
	 * @param syrup if the drink has syrup
	 */
	public void setSyrup(boolean syrup) {
		this.syrup = syrup;
	}

	
	// create abstract method that will need to be overridden in all of its concrete subclasses
	
	public abstract double determinePrice();

	protected abstract String getDescription();
}
