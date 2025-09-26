package gui;

import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class LetterModel {

    public static final String LETTER = "LETTER";
    private final SwingPropertyChangeSupport support = new SwingPropertyChangeSupport(this);
    private String letter;

    public void setLetter(String newLetter) {
        String oldLetter = this.letter;
        letter = newLetter;

        support.firePropertyChange(LETTER, oldLetter, newLetter);
    }

    // two methods to allow listeners to register with support object
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

}
