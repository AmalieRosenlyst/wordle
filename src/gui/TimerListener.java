package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TimerListener implements ActionListener {
    private final LetterModel model;

    public TimerListener(LetterModel model) {
        super();
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newLetter = e.paramString();
        model.setLetter(newLetter);
    }
}
