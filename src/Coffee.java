
public class Coffee extends Drink {
    /**
     * The number of shots in this drink.
     */
    final int numShots;
    /**
     * The base cost of the drink.
     */
    final double baseCost = 1;
    /**
     * The base price of the drink.
     */
    final double basePrice = 4;

    /**
     * @param S size of the drink
     * @param M if the drink has milk
     * @param I if the drink is iced
     * @param Y if the drink has syrup
     * @param num number of shots
     */
    public Coffee(char S, boolean M, boolean I, boolean Y, int num) {
        super(S, M, I, Y);
        numShots = num;
    }

    /**
     * Getter for Coffee#numShots
     * @return the number of shots
     */
    public int getNumShots() {
        return this.numShots;
    }

    /**
     * @return the cost of the drink
     */
    public double determineCost() {
        double cost = baseCost;
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

    /**
     * @return the profit of the drink
     */
    public double determineProfit() {
        return this.determinePrice() - this.determineCost();
    }

    /**
     * @return the number of shots
     */
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

    /**
     * @return the description of the drink
     */
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
}
