package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GuessLetter {

    private LetterModel model = new LetterModel();
    private JLabel label;

    public JPanel create() {
        model.addPropertyChangeListener(LetterModel.LETTER, new LetterListener(this));

        JPanel panel = new JPanel();
        stylePanel(panel);

        label = new JLabel();
        styleLabel(label);

        panel.add(label);

        Timer timer = new Timer(1000, new TimerListener(model));
        timer.start();

        return panel;
    }

    private void stylePanel(JPanel panel) {
        panel.setLayout(new GridLayout());
        panel.setBackground(new Color(252, 234, 217));
        Border roundedMargin = new EmptyBorder(5,7,5,7);
        panel.setBorder(roundedMargin);
    }

    private void styleLabel(JLabel label) {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Source Code Pro", Font.PLAIN, 42));
        label.setForeground(new Color(97, 72, 50));
        Border lineBorder = new LineBorder(new Color(235, 202, 171), 5, true);
        label.setBorder(lineBorder);
    }

    public void setLabelText(String text) {
        label.setText("W");
        System.out.println("text " + text);
    }
}
