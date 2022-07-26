import java.util.Iterator;
import java.util.Map;

public class Price {
    private Greeting greeting;
    private GreetingCard card;

    public Price(Greeting greeting, GreetingCard card) {
        this.greeting = greeting;
        this.card = card;
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
