package backend;

import java.util.Scanner;

public class Guess {

    private final Scanner scanner;
    private final int attempt;
    private String word;
    private Result result;

    public Guess(int attempt) {
        this.scanner = new Scanner(System.in);
        this.attempt = attempt;
    }

    public void makeGuess() {
        do {
            System.out.println("Guess a word: ");
            word = scanner.nextLine();
        } while (!word.matches("[a-zA-Z]{5}"));
    }

    public void makeGuess(String guess) {
        if (guess.matches("[a-zA-Z]{5}")) {
            word = guess;
        }
    }

    public String getWord() {
        return word;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }
}
