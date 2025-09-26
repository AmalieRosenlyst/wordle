package gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldSingleCharLimit extends PlainDocument {

    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
        if ((getLength() + str.length()) <= 1) {
            str= str.toUpperCase();
            super.insertString(offset, str, set);
        }
    }
}
