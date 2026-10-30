import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        HangmanOptions hangmanOptions = new HangmanOptions();
        String randomWord = Objects.requireNonNull(hangmanOptions.chooseOption(), "Could not retrieve the word");
        HangmanStage hangmanStage = new HangmanStage(randomWord);
        HangmanChecker hangmanChecker = new HangmanChecker(randomWord, hangmanStage);
        HangmanRunner hangmanRunner = new HangmanRunner(hangmanStage, hangmanChecker);
        hangmanRunner.run();
    }
}
