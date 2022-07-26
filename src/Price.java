import java.util.Iterator;
import java.util.Map;

public class Price {
    private Greeting greeting;
    private GreetingCard card;

    private final double
            COST_PER_UPPER = .05,
            COST_PER_LOWER = .02,
            COST_PER_SPECIAL = .03,
            COST_PER_NUMBER = .02,
            COST_PER_SQ_IN = .2;

    public Price(Greeting greeting, GreetingCard card) {
        this.greeting = greeting;
        this.card = card;
    }

    private double greetingPrice() {
        double total = 0;
        Iterator<Map.Entry<Character, Integer>> iterator = greeting.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Character,Integer> next = iterator.next();
            char letter = next.getKey();
            int count = next.getValue();
            if(Character.isUpperCase(letter)) {
                total += COST_PER_UPPER * count;
            }
            else if(Character.isLowerCase(letter)) {
                total += COST_PER_LOWER * count;
            }
            else if(Character.isDigit(letter)) {
                total += COST_PER_NUMBER * count;
            }
            else {
                total += COST_PER_SPECIAL * count;
            }
        }
        return total;
    }

    private double cardPrice() {
        return card.area() * COST_PER_SQ_IN;
    }

    private double greetingCardTotal() {
        return cardPrice() + greetingPrice();
    }

    @Override
    public String toString() {
        return "Price{" +
                "greeting=" + greeting +
                ", card=" + card +
                ", COST_PER_UPPER=" + COST_PER_UPPER +
                ", COST_PER_LOWER=" + COST_PER_LOWER +
                ", COST_PER_SPECIAL=" + COST_PER_SPECIAL +
                ", COST_PER_NUMBER=" + COST_PER_NUMBER +
                '}';
    }
}
