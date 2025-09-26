package gui;

import backend.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class InputLetter {

    private final InputPanel parent;
    private final Game game;
    private final JTextField textField = new JTextField(1);

    public InputLetter(InputPanel parent, Game game) {
        this.parent = parent;
        this.game = game;
    }

    public JPanel create() {
        JPanel panel = new JPanel(new GridLayout());

        styleTextField();

        textField.setDocument(new TextFieldSingleCharLimit());
        textField.addActionListener(new GuessAction(parent, game));

        panel.setBorder(new EmptyBorder(5,7,5,7));
        panel.setBackground(new Color(252, 234, 217));

        panel.add(textField);

        return panel;
    }

    private void styleTextField() {
        textField.setForeground(new Color(97, 72, 50));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setEditable(true);
        textField.setFont(new Font("Source Code Pro", Font.PLAIN, 42));
        textField.setBorder(new LineBorder(new Color(235, 202, 171), 5, true));
        textField.setBackground(new Color(252, 234, 217));
    }

    public boolean hasInput() {
        return textField.getText().length() == 1;
    }

    public String getLetter() {
        return textField.getText();
    }
}
