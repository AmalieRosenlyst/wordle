package backend;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String secretWord;
    private final List<Guess> guesses;
    private int round;

    public Game(WordGeneratorStrategy wordGeneratorStrategy) {
        this.secretWord = wordGeneratorStrategy.generateWord();
        this.guesses = new ArrayList<>();
        this.round = 0;
    }

    public void play() {
        for (int i = 1; i <= 6; i++) {
            Guess guess = new Guess(i);
            guess.makeGuess();
            guesses.add(guess);
            Result result = Evaluator.evaluate(guess, secretWord);
            if (result.isCorrect()) {
                System.out.println("Correct guess!!!!: " + guess.getWord());
                return;
            }
            printState();
        }
        System.out.println("You just lost the game :(");
    }

    public void makeAGuess(String string) {
        Guess guess = new Guess(round);
        guess.makeGuess(string);
        guesses.add(guess);
    }

    public List<Guess> getGuesses() {
        return guesses;
    }

    private void printState() {
        int numberOfGuesses = guesses.size();

        for (int i = 0; i < numberOfGuesses; i++) {
            printGuess(guesses.get(i));
        }

    }

    private void printGuess(Guess guess) {
        StringBuilder sbWord = new StringBuilder();
        StringBuilder sbStatuses = new StringBuilder();
        LetterStatus[] letterStatuses = guess.getResult().letterStatuses();

        for (int i = 0; i < 5; i++) {
            char letter = guess.getWord().charAt(i);
            sbWord.append(letter + " ");

            LetterStatus status = letterStatuses[i];
            if (status == LetterStatus.ABSENT) {
                sbStatuses.append("___ ");
            } else if (status == LetterStatus.PRESENT) {
                sbStatuses.append("ppp ");
            } else {
                sbStatuses.append("ccc ");
            }


        }

        System.out.println(sbWord + "| " + sbStatuses);
    }

}
