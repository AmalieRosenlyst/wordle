import backend.Game;
import backend.Guess;
import backend.WordListStrategy;
import gui.GuessPanel;
import gui.InputPanel;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    private static Game game;

    private static void createUIComponents() {
        // TODO: place custom component creation code here

        JFrame frame = new JFrame();
        frame.setSize(1000,1000);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6,1));

        JPanel topPanel = new InputPanel(game).create();
        mainPanel.add(topPanel);

        // TODO: make a divider

        ArrayList<Guess> guesses = (ArrayList<Guess>) game.getGuesses();
        int numberOfGuesses = guesses.size();

        for (int i = 0; i < numberOfGuesses; i++) {
            JPanel secondTopMostPanel = new GuessPanel(guesses.get(numberOfGuesses - i - 1)).create();
            mainPanel.add(secondTopMostPanel);
        }

        for (int i = 0; i < 5 - numberOfGuesses; i++) {
            JPanel thirdTopMostPanel = new GuessPanel().create();
            mainPanel.add(thirdTopMostPanel);
        }





        //JPanel thirdBottomMostPanel = new GuessPanel().create();
        //mainPanel.add(thirdBottomMostPanel);

        //JPanel secondBottomMostPanel = new GuessPanel().create();
        //mainPanel.add(secondBottomMostPanel);

        //JPanel bottomPanel = new GuessPanel().create();
        //mainPanel.add(bottomPanel);




        frame.add(mainPanel);
        frame.setPreferredSize(new Dimension(390, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        game = new Game(new WordListStrategy());

        createUIComponents();

        game.play();

    }

    // TODO: use BorderFactory.createEmptyBorder()to create borders
    //  Look for other factories.

}