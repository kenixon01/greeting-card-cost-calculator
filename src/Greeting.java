import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Greeting {
    private final String GREETING;
    private final HashMap<Character,Integer> charCount;

    private final double
            COST_PER_UPPER = .05,
            COST_PER_LOWER = .02,
            COST_PER_SPECIAL = .03,
            COST_PER_NUMBER = .02;

    public Greeting(String greeting) {
        GREETING = greeting;
        charCount = countChar();
    }
    private double total() {
        double total = 0;
        Iterator<Map.Entry<Character, Integer>> iterator = iterator();
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

    public String getGREETING() {
        return GREETING;
    }

    public HashMap<Character, Integer> getCharCount() {
        return charCount;
    }

    private HashMap<Character,Integer> countChar() {
        for(int i = 0; i < GREETING.length(); i++) {
            char letter = GREETING.charAt(i);
            if(!charCount.containsKey(letter)) {
                charCount.put(letter,1);
            }
            else {
                charCount.replace(letter, charCount.get(letter) + 1);
            }
        }
        return charCount;
    }

    public Iterator<Map.Entry<Character, Integer>> iterator() {
        return charCount.entrySet().iterator();
    }
}
