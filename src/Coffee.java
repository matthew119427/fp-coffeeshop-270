
public class Coffee extends Drink {

    // additional Data Members
    int numShots;
    final double baseCost = 1;
    final double basePrice = 4;

    // constructor and constructor chaining
    public Coffee(char S, boolean M, boolean I, boolean Y, int num) {
        super(S, M, I, Y);
        numShots = num;
    }

    // override abstract methods in interface
    public double determineCost() {
        double cost = baseCost;
        // as if statements following each other as these statements are not exclusive
        if (size == 'M') {
            cost += 0.3;
        } else if (size == 'L') {
            cost += 0.5;
        }
        if (numShots > 0) {
            cost += numShots *0.4;
        }
        if (milk) {
            cost += 0.1;
        }
        if (syrup) {
            cost += 0.2;
        }
        return cost;
    }

    public double determineProfit() {
        return this.determinePrice() - this.determineCost();
    }

    // override abstract method from parent class
    public double determinePrice() {
        double price = basePrice;
        // as if statements following each other as these statements are not exclusive
        if (size == 'M') {
            price += 1.5;
        } else if (size == 'L') {
            price += 2.5;
        }
        if (numShots > 0) {
            price += numShots *0.9;
        }
        if (milk) {
            price += 0.7;
        }
        if (syrup) {
            price += 0.8;
        }
        return price;
    }
    
    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Coffee: ");
        description.append(size == 'L' ? "Large" : "Medium");
        if (milk) {
            description.append(" with Milk");
        }
        if (iced) {
            description.append(" Iced");
        }
        if (syrup) {
            description.append(" with Syrup");
        }
        description.append(", ").append(numShots).append(" shots");
        return description.toString();


    }

	public Object getNumShots() {
        return this.numShots;
	}
}
