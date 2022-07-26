import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Greeting {
    private final String GREETING;
    private final HashMap<Character,Integer> charCount;

    public Greeting(String greeting) {
        GREETING = greeting;
        charCount = countChar();
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

    @Override
    public String toString() {
        return "Greeting: " + GREETING;
    }

}
