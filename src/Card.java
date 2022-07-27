public class Card {
    private final double LENGTH, WIDTH;
    private double costPerSqIn;

    public Card(double length, double width, double costPerSqIn) throws InvalidInputException {
        LENGTH = length;
        WIDTH = width;
        this.costPerSqIn = costPerSqIn;
        checkCard();
    }

    private void checkCard() throws InvalidInputException {
        if(WIDTH <= 0 && LENGTH <= 0) {
            throw new InvalidInputException("The card width and length must be greater than 0.");
        }
        if(costPerSqIn < 0.01) {
            throw new InvalidInputException("The cost per square inch must be at least $0.01");
        }
    }

    public double area() {
        return LENGTH * WIDTH;
    }

    public double total() {
        return costPerSqIn * area();
    }
    
    public double getLength() {
        return LENGTH;
    }

    public double getWIDTH() {
        return WIDTH;
    }

}
