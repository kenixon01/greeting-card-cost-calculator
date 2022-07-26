public class Card {
    private final int LENGTH, WIDTH;
    private double costPerSqIn = .02;

    public Card(int length, int width, double costPerSqIn) {
        LENGTH = length;
        WIDTH = width;
        this.costPerSqIn = costPerSqIn;
    }

    public int area() {
        return LENGTH * WIDTH;
    }

    public double total() {
        return costPerSqIn * area();
    }
    
    public int getLength() {
        return LENGTH;
    }

    public int getWIDTH() {
        return WIDTH;
    }

}
