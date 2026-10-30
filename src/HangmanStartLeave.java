import java.util.List;
import java.util.Random;

public class HangmanStartLeave {
    public static String start() {
        List<String> words = HangmanWordLoader.wordLoader("src/words.txt").stream().filter(word -> word.length() >= 4 && word.length() <= 10).toList();
        if (words.isEmpty()) return null;
        return words.get(new Random().nextInt(words.size()));
    }

    public static void leave() {
        System.out.println("Exiting...");
    }
}
