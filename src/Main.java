import backend.Game;
import backend.WordListStrategy;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new WordListStrategy());
        game.play();
    }

}
