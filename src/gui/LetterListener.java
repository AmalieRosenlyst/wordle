package gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LetterListener implements PropertyChangeListener {

    private final GuessLetter guessLetter;

    public LetterListener(GuessLetter guessLetter) {
        super();
        this.guessLetter = guessLetter;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String newLetter = (String) evt.getNewValue();
        guessLetter.setLabelText(newLetter);
    }
}
