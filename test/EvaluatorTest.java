import backend.Evaluator;
import backend.Guess;
import backend.LetterStatus;
import backend.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

/**
 * Test class.
 */
public class EvaluatorTest {

    /**
     * A correct guess should evaluate as correct.
     */
    @Test
    public void evaluateCorrectGuessAsCorrect() {
        Guess guess = makeGuess("fixed");
        Result result = Evaluator.evaluate(guess, "fixed");

        Assertions.assertTrue(result.isCorrect());
    }

    /**
     * A correct guess should only contain correct letter statuses.
     */
    @Test
    public void evaluatingCorrectGuessShouldOnlyHaveCorrectLetterStatuses() {
        Guess guess = makeGuess("fixed");
        Result result = Evaluator.evaluate(guess, "fixed");

        LetterStatus[] expected = {
                LetterStatus.CORRECT,
                LetterStatus.CORRECT,
                LetterStatus.CORRECT,
                LetterStatus.CORRECT,
                LetterStatus.CORRECT};

        Assertions.assertArrayEquals(expected, result.letterStatuses());
    }

    /**
     * A guess with a correctly placed letter should result in a correct letter status for the letter.
     */
    @Test
    public void correctlyPlacedLetterShouldOnlyHaveCorrectLetterStatus() {
        Guess guess = makeGuess("shone");
        Result result = Evaluator.evaluate(guess, "quote");

        LetterStatus[] expected = {
                LetterStatus.ABSENT,
                LetterStatus.ABSENT,
                LetterStatus.CORRECT,
                LetterStatus.ABSENT,
                LetterStatus.CORRECT};

        Assertions.assertFalse(result.isCorrect());
        Assertions.assertArrayEquals(expected, result.letterStatuses());
    }

    /**
     * A guess with a present letter incorrectly placed should result in a present letter status for that letter.
     */
    @Test
    public void presentLetterShouldHavePresentLetterStatus() {
        Guess guess = makeGuess("corny");
        Result result = Evaluator.evaluate(guess, "quote");

        LetterStatus[] expected = {
                LetterStatus.ABSENT,
                LetterStatus.PRESENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT};

        Assertions.assertFalse(result.isCorrect());
        Assertions.assertArrayEquals(expected, result.letterStatuses());
    }

    /**
     * Incorrect guess should only contain absent letter statuses.
     */
    @Test
    public void incorrectGuessShouldOnlyHaveIncorrectLetterStatuses() {
        Guess guess = makeGuess("hihih");
        Result result = Evaluator.evaluate(guess, "quote");

        LetterStatus[] expected = {
                LetterStatus.ABSENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT};

        Assertions.assertFalse(result.isCorrect());
        Assertions.assertArrayEquals(expected, result.letterStatuses());
    }

    /**
     * A guess with both a correctly placed letter and a present letter should have both letter statuses.
     */
    @Test
    public void guessWithCorrectAndPresentLettersShouldHaveBothLetterStatuses() {
        Guess guess = makeGuess("thief");
        Result result = Evaluator.evaluate(guess, "shake");

        LetterStatus[] expected = {
                LetterStatus.ABSENT,
                LetterStatus.CORRECT,
                LetterStatus.ABSENT,
                LetterStatus.PRESENT,
                LetterStatus.ABSENT};

        Assertions.assertFalse(result.isCorrect());
        Assertions.assertArrayEquals(expected, result.letterStatuses());
    }

    /**
     * A guess with two of the same letter where only one is present in the secret word should only result in a present letter status for the first letter.
     */
    @Test
    public void guessContainingTwoOfSameLetterShouldOnlyHaveFirstLetterStatusPresent() {
        Guess guess = makeGuess("kebab");
        Result result = Evaluator.evaluate(guess, "bowel");

        LetterStatus[] expected = {
                LetterStatus.ABSENT,
                LetterStatus.PRESENT,
                LetterStatus.PRESENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT};

        Assertions.assertFalse(result.isCorrect());
        Assertions.assertArrayEquals(expected, result.letterStatuses());
    }

    /**
     * Evaluating a null will throw an error.
     */
    @Test
    public void evaluatingNullWillThrowError() {
        Assertions.assertThrows(
                IllegalStateException.class,
                () -> Evaluator.evaluate(null, "words"),
                "You must make a guess before evaluating.");
    }

    private Guess makeGuess(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        Guess guess = new Guess(1);
        guess.makeGuess();
        return guess;
    }

}
