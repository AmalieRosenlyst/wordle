package gui;

import backend.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class InputPanel {

    private final List<InputLetter> inputLetters;
    private final Game game;

    public InputPanel(Game game) {
        this.game = game;
        this.inputLetters = new ArrayList<>();
    }

    public JPanel create() {
        JPanel panel = new JPanel(new GridLayout());

        panel.setBorder(new EmptyBorder(5,10,5,10));
        panel.setBackground(new Color(252, 234, 217));
        panel.setVisible(true);

        createInputLetters(panel);

        return panel;
    }

    private void createInputLetters(JPanel panel) {
        for (int i = 0; i < 5; i++) {
            InputLetter letter = new InputLetter(this, game);
            JPanel letterPanel = letter.create();
            inputLetters.add(letter);
            panel.add(letterPanel);
        }
    }

    public boolean hasAllInputs() {
        for (InputLetter inputLetter : inputLetters) {
            if (!inputLetter.hasInput()) {
                return false;
            }
        }
        return true;
    }

    public List<InputLetter> getInputLetters() {
        return inputLetters;
    }

}
