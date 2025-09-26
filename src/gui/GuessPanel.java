package gui;

import backend.Guess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuessPanel {

    private final List<GuessLetter> guessLetters = new ArrayList<>();
    private Guess guess;

    public GuessPanel() {}

    public GuessPanel(Guess guess) {
        this.guess = guess;
    }

    public JPanel create() {
        JPanel panel = new JPanel();

        panel.setBorder(new EmptyBorder(5,10,5,10));
        panel.setBackground(new Color(252, 234, 217));

        createGuessLetters(panel);

        panel.setLayout(new GridLayout(1,5));
        panel.setVisible(true);

        return panel;
    }

    private void createGuessLetters(JPanel panel) {
        String word = "     ";
        if (guess != null) {
            word = guess.getWord();
        }
        for (int i = 0; i < 5; i++) {
            GuessLetter letter = new GuessLetter();
            JPanel letterPanel = letter.create();
            letter.setLabelText(String.valueOf(word.charAt(i)));
            guessLetters.add(letter);
            panel.add(letterPanel);
        }
    }
}
