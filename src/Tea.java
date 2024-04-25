
public class Tea extends Drink {

    // additional Data Members
    int numBags;
    final double baseCost = 0.5;
    final double basePrice = 3;

    // constructor and constructor chaining
    public Tea(char S, boolean M, boolean I, boolean Y, int num) {
        super(S, M, I, Y);
        numBags = num;
    }

    // Getters & Setters

    public int getNumBags() {
        return this.numBags;
    }

    public void setNumBags(int numShots) {
        this.numBags = numShots;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // override abstract methods in interface
    public double determineCost() {
        double cost = baseCost;
        // as if statements following each other as these statements are not exclusive
        if (size == 'M') {
            cost += 0.3;
        } else if (size == 'L') {
            cost += 0.4;
        }
        if (numBags > 0) {
            cost += numBags * 0.4;
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
        if (size == 'M') {
            price += 1.25;
        } else if (size == 'L') {
            price += 2.25;
        }
        if (numBags > 0) {
            price += numBags * 0.9;
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
        description.append("Tea: ");
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
        description.append(", " + numBags + " tea bags");
        return description.toString();
    }

}
