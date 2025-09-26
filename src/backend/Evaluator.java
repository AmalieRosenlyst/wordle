package backend;

public class Evaluator {

    public static Result evaluate(Guess guess, String secretWord) {
        if (guess == null) {
            throw new IllegalStateException("You must make a guess before evaluating.");
        }

        LetterStatus[] letters = {
                LetterStatus.ABSENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT,
                LetterStatus.ABSENT};
        String guessWord = guess.getWord();

        if (guessWord.equals(secretWord)) {
            for (int i = 0; i < secretWord.length(); i++) {
                letters[i] = LetterStatus.CORRECT;
            }
            Result result = new Result(true, letters);
            guess.setResult(result);
            return result;
        } else {
            char[] guessChars = guessWord.toCharArray();
            char[] secretChars = secretWord.toCharArray();

            for (int i = 0; i < secretChars.length; i++) {
                if (secretChars[i] == guessChars[i]) {
                    letters[i] = LetterStatus.CORRECT;
                    secretChars[i] = '-';
                }
            }

            for (int i = 0; i < secretChars.length; i++) {
                if (secretChars[i] == '-') {
                    continue;
                }

                for (int j = 0; j < guessChars.length; j++) {
                    if (secretChars[i] == guessChars[j]) {
                        letters[j] = LetterStatus.PRESENT;
                        secretChars[i] = '-';
                        break;
                    }
                }
            }
        }
        Result result = new Result(false, letters);
        guess.setResult(result);
        return result;
    }
}
