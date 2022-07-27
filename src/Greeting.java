import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Greeting {
    private final String GREETING;
    private final HashMap<Character,Integer> charCount;

    private double costPerUpper, costPerLower, costPerSpecial, costPerNumber;

    public Greeting(String GREETING, double costPerUpper, double costPerLower, double costPerSpecial, double costPerNumber) {
        this.GREETING = GREETING;
        this.costPerUpper = costPerUpper;
        this.costPerLower = costPerLower;
        this.costPerSpecial = costPerSpecial;
        this.costPerNumber = costPerNumber;
        charCount = new HashMap<>();
    }

    public double total() {
        double total = 0;
        Iterator<Map.Entry<Character, Integer>> iterator = iterator();
        while(iterator.hasNext()) {
            Map.Entry<Character,Integer> next = iterator.next();
            char letter = next.getKey();
            int count = next.getValue();
            total = letterCost(letter,count);
        }
        return total;
    }

    public double letterCost(char letter, int count) {
        double total = 0;
        if(Character.isUpperCase(letter)) {
            total += costPerUpper * count;
        }
        else if(Character.isLowerCase(letter)) {
            total += costPerLower * count;
        }
        else if(Character.isDigit(letter)) {
            total += costPerNumber * count;
        }
        else {
            total += costPerSpecial * count;
        }
        return total;
    }

    public String getGREETING() {
        return GREETING;
    }

    public HashMap<Character, Integer> getCharCount() {
        return charCount;
    }

    public void countChar() {
        for(int i = 0; i < GREETING.length(); i++) {
            char letter = GREETING.charAt(i);
            if(!charCount.containsKey(letter)) {
                charCount.put(letter,1);
            }
            else {
                charCount.replace(letter, charCount.get(letter) + 1);
            }
        }
    }

    public Iterator<Map.Entry<Character, Integer>> iterator() {
        return charCount.entrySet().iterator();
    }
}
