package GraphicUnit;
import java.awt.Color;
import javax.swing.*;

class InputScreen extends JTextArea
{
    public InputScreen()
    {
        
        this.setBounds(0, 30, 530, 115);
        this.setVisible(true);
        this.setEnabled(true);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(true);
        this.setOpaque(false);
        this.setFont(new java.awt.Font("Courier New Regular",0, 30));
        this.setForeground(Color.WHITE);
        this.getCaret().setVisible(true);
        this.getCaret().setBlinkRate(300);
        this.setCaretColor(Color.white);
        this.setCaretPosition(getDocument().getLength());      
    }
}

