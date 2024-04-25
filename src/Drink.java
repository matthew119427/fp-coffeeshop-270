
public abstract class Drink implements CostBehavior {
	// Data members
	 char size;
	 boolean milk;
	 boolean iced;
	 boolean syrup;
	 
	 // constructor taking all parameters for Drink class (as these will be read from a file)
	 public Drink(char S, boolean M, boolean I, boolean Y) {
		 size = S;
		 milk = M;
		 iced= I;
		 syrup = Y;
	 }
	 
	 // generate getters and setters	 
	 public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public boolean getMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	public boolean getIced() {
		return iced;
	}

	public void setIced(boolean iced) {
		this.iced = iced;
	}

	public boolean getSyrup() {
		return syrup;
	}

	public void setSyrup(boolean syrup) {
		this.syrup = syrup;
	}

	
	// create abstract method that will need to be overridden in all of its concrete subclasses
	
	public abstract double determinePrice();

	protected abstract String getDescription();
	 
	 // abstract methods in interface do not yet have to be overridden (will happen in the concrete subclasses)
	 
	 

}
