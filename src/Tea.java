/**
 * Tea class that extends Drink
 * @see Drink
 * @version 4
 */
public class Tea extends Drink {
    /**
     * The number of tea bags in this drink.
     */
    final int numBags;
    /**
     * The base cost of the drink.
     */
    final double baseCost = 0.5;
    /**
     * The base price of the drink.
     */
    final double basePrice = 3;

    /**
     * @param S size of the drink
     * @param M if the drink has milk
     * @param I if the drink is iced
     * @param Y if the drink has syrup
     * @param num number of tea bags
     */
    public Tea(char S, boolean M, boolean I, boolean Y, int num) {
        super(S, M, I, Y);
        numBags = num;
    }

    /**
     * @return the number of tea bags
     */
    public int getNumBags() {
        return this.numBags;
    }

    /**
     * @return the base cost of the drink
     */
    public double getBaseCost() {
        return baseCost;
    }

    /**
     * @return the base price of the drink
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * @return the cost of the drink
     */
    public double determineCost() {
        double cost = baseCost;
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

    /**
     * @return the profit of the drink
     */
    public double determineProfit() {
        return this.determinePrice() - this.determineCost();
    }

    /**
     * @return the price of the drink
     */
    @Override
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

    /**
     * Returns a String representation of the drink
     * @return the description of the drink
     */
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
        description.append(", ").append(numBags).append(" tea bags");
        return description.toString();
    }
}
