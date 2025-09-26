package backend;

public class FixedWordStrategy implements WordGeneratorStrategy {

    private final String word;

    public FixedWordStrategy(String word) {
        this.word = word;
    }

    @Override
    public String generateWord() {
        return word;
    }
}
