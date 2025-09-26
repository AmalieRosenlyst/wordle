import backend.Guess;
import backend.LetterStatus;
import backend.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

/** Test class. */
public class GuessTest {

    /** Should be able to make a guess. */
    @Test
    public void shouldBeAbleToMakeGuess() {
        provideInput("guess");
        Guess guess = new Guess(1);
        guess.makeGuess();

        Assertions.assertNotNull(guess.getWord());
        Assertions.assertEquals("guess", guess.getWord());
        Assertions.assertEquals(1, guess.getAttempt());
    }

    /** Should not be able to make a 6-letter guess. */
    @Test
    public void notAbleToMakeSixLetterGuess() {
        provideInput("wrongg\nright");
        Guess guess = new Guess(1);
        guess.makeGuess();

        Assertions.assertNotNull(guess.getWord());
        Assertions.assertEquals("right", guess.getWord());
    }


    /** Should not be able to make a 4-letter guess. */
    @Test
    public void notAbleToMakeFourLetterGuess() {
        provideInput("wron\nright");
        Guess guess = new Guess(1);
        guess.makeGuess();

        Assertions.assertNotNull(guess.getWord());
        Assertions.assertEquals("right", guess.getWord());
    }

    /** Should not be able to make a guess containing digits. */
    @Test
    public void notAbleToMakeDigitGuess() {
        provideInput("12345\nr1ght\nright");
        Guess guess = new Guess(1);
        guess.makeGuess();

        Assertions.assertNotNull(guess.getWord());
        Assertions.assertEquals("right", guess.getWord());
    }

    /** Should be able to set the result. */
    @Test
    public void shouldBeAbleToSetResult() {
        Guess guess = new Guess(1);
        Result result = new Result(true, new LetterStatus[5]);
        guess.setResult(result);

        Assertions.assertEquals(result, guess.getResult());
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
