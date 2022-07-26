public class Card {
    private final int LENGTH, WIDTH;
    private final String COLOR;
    private final double COST_PER_SQ_IN = .2;

    public Card(int length, int width, String color) {
        LENGTH = length;
        WIDTH = width;
        COLOR = color;
    }

    public int area() {
        return LENGTH * WIDTH;
    }

    public double total() {
        return COST_PER_SQ_IN * area();
    }
    
    public int getLength() {
        return LENGTH;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public String getCOLOR() {
        return COLOR;
    }
}
