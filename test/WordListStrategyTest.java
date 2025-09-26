import backend.WordListStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Test class. */
public class WordListStrategyTest{

    /** Should generate a 5-letter word. */
    @Test
    public void shouldGenerateFiveLetterWord() {
        WordListStrategy wordListStrategy = new WordListStrategy();
        String word = wordListStrategy.generateWord();

        Assertions.assertNotNull(word);
        Assertions.assertEquals(5, word.length());
    }

    /** Should not generate same word. */
    @Test
    public void shouldGenerateFourLetterWord() {
        WordListStrategy wordListStrategy = new WordListStrategy();
        String firstWord = wordListStrategy.generateWord();
        String secondWord = wordListStrategy.generateWord();

        Assertions.assertNotEquals(firstWord, secondWord);
    }

    /** Should not generate same word upon initialisation. */
    @Test
    public void shouldGenerateThreeLetterWord() {
        WordListStrategy firstWordListStrategy = new WordListStrategy();
        String firstWord = firstWordListStrategy.generateWord();

        WordListStrategy secondWordListStrategy = new WordListStrategy();
        String secondWord = secondWordListStrategy.generateWord();

        Assertions.assertNotEquals(firstWord, secondWord);
    }
}