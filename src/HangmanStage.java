import java.util.ArrayList;
import java.util.List;

public class HangmanStage {
    private StringBuilder wordStage;
    private final List<String> mistakes;
    private final List<Character> usedLetters;
    private int attempts;
    private final HangmanRenderer hangmanRenderer;

    public HangmanStage(String word) {
        this.wordStage = new StringBuilder("_".repeat(word.length()));
        this.usedLetters = new ArrayList<>();
        this.mistakes = new ArrayList<>();
        this.attempts = 6;
        this.hangmanRenderer = new HangmanRenderer();
    }

    public void decreaseAttempts() {
        attempts--;
    }

    public void useLetter(String letter) {
        getUsedLetters().add(letter.charAt(0));
    }

    public void setWordStage(StringBuilder wordStage) {
        this.wordStage = wordStage;
    }

    public void printMistakes() {
        System.out.print("Mistakes: ");
        getMistakes().forEach(m -> System.out.print(m + " "));
    }

    public void printHangmanState() {
        hangmanRenderer.renderStage(getAttempts());
    }

    public void printCompletedWordMessage() {
        System.out.println("=======================================");
        System.out.println("You have successfully guessed the word");
        System.out.println("Starting a new game...");
        System.out.println("=======================================\n");
    }

    public void printFinalAttemptMessage(String word){
        System.out.println("\n=======================================");
        System.out.println("You have used up all your attempts");
        System.out.println("The word - " + word);
        System.out.println("Starting a new game...");
        System.out.println("=======================================\n");
    }

    public void printWordStage() {
        System.out.println("\nThe word: " + getWordStage());
    }

    public List<Character> getUsedLetters() {
        return usedLetters;
    }

    public List<String> getMistakes() {
        return mistakes;
    }

    public int getAttempts() {
        return attempts;
    }

    public StringBuilder getWordStage() {
        return this.wordStage;
    }
}

