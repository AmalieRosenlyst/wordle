package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class WordListStrategy implements WordGeneratorStrategy {

    @Override
    public String generateWord() {
        try(BufferedReader br = new BufferedReader(new FileReader("./data/wordle_ord.txt"))){
            Random random = new Random();
            int randomNumber = random.nextInt(2316);
            String line = br.readLine();
            int currentLine = 0;
            while (currentLine != randomNumber) {
                line = br.readLine();
                currentLine++;
            }
            return line;
        } catch (IOException e) {
            System.out.println("Error generating secret word.");
            return null;
        }
    }
}
