/**
 * The {@code Card} class will create the framework for a basic greeting card along with the cost to
 * manufacture that card.
 * @author Khamilah Nixon
 */
public class Card {
    private final Double LENGTH, WIDTH;
    private double costPerSqIn;

    public Card(Double length, Double width, Double costPerSqIn) throws InvalidInputException {
        checkCard();
        LENGTH = length;
        WIDTH = width;
        this.costPerSqIn = costPerSqIn;
    }

    /**
     * This method will determine if a card object's attributes contain valid values based on the following
     * parameters:
     * <ol>
     *     <li>Width and length must contain a value</li>
     *     <li>Values for width and length cannot be negative or 0</li>
     *     <li>The cost per square inch much be at least $0.01</li>
     * </ol>
     * @throws InvalidInputException if any of the conditions are not met
     */
    private void checkCard() throws InvalidInputException {
        if(WIDTH == null || LENGTH == null) {
            throw new InvalidInputException("The card width and length must have a value.");
        }
        if(WIDTH <= 0 || LENGTH <= 0) {
            throw new InvalidInputException("The card width and length must be greater than 0.");
        }
        if(costPerSqIn < 0.01) {
            throw new InvalidInputException("The cost per square inch must be at least $0.01");
        }
    }

    /**
     * This method will determine the area of the card object
     * @return area of card
     */
    public double area() {
        return LENGTH * WIDTH;
    }

    /**
     * This method will determine the total price of the card object
     * @return price of card
     */
    public double total() {
        return costPerSqIn * area();
    }
}
