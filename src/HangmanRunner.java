import java.util.Objects;
import java.util.Scanner;

public class HangmanRunner {
    private final Scanner scanner = new Scanner(System.in);
    private HangmanStage hangmanStage;
    private HangmanChecker hangmanChecker;

    public HangmanRunner(HangmanStage hangmanStage, HangmanChecker hangmanChecker) {
        this.hangmanStage = hangmanStage;
        this.hangmanChecker = hangmanChecker;
    }

    public void run() {
        printStatistics();
        while (true) {
            while (true) {
                System.out.print("\nEnter a letter: ");
                String letter = scanner.next().trim().toLowerCase();
                if (letter.equals("2")) return;
                if (!hangmanChecker.checkIfAppropriate(letter)) continue;
                if (hangmanChecker.addIfNotUsed(letter)) continue;
                if (hangmanChecker.addIfMistake(letter)) hangmanStage.decreaseAttempts();
                if (hangmanChecker.checkIfFinalAttempt()) break;
                hangmanChecker.openLetter(letter);
                if (hangmanChecker.checkIfCompleted()) break;
                printStatistics();
            }
            if (!reset()) return;
        }
    }

    private void printStatistics() {
        hangmanStage.printHangmanState();
        hangmanStage.printMistakes();
        hangmanStage.printWordStage();
    }

    private boolean reset() {
        String randomWord = Objects.requireNonNull(HangmanStartLeave.start(), "Could not retrieve the word");
        this.hangmanStage = new HangmanStage(randomWord);
        this.hangmanChecker = new HangmanChecker(randomWord, hangmanStage);
        printStatistics();
        return true;
    }
}