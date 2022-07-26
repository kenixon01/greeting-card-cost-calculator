
import java.util.HashMap;

public class Greeting {
    private final String GREETING;

    public Greeting(String greeting) {
        GREETING = greeting;
    }

    public String getGREETING() {
        return GREETING;
    }

    public HashMap<Character,Integer> countChar() {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < GREETING.length(); i++) {
            char letter = GREETING.charAt(i);
            if(!map.containsKey(letter)) {
                map.put(letter,1);
            }
            else {
                map.replace(letter,map.get(letter) + 1);
            }
        }
        return map;
    }
}
