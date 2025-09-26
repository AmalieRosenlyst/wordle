package gui;

import backend.Game;
import backend.Guess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class GuessAction extends AbstractAction {

    private InputPanel inputPanel;
    private Game game;

    public GuessAction(InputPanel inputPanel, Game game) {
        this.inputPanel = inputPanel;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inputPanel.hasAllInputs()) {
            System.out.println("Guess was registered");

            List<InputLetter> inputLetterList = inputPanel.getInputLetters();
            StringBuilder sb = new StringBuilder();
            for (InputLetter letter : inputLetterList) {
                sb.append(letter.getLetter());
            }

            game.makeAGuess(sb.toString());

            System.out.println(sb);
            // make a guess
        }
    }
}
