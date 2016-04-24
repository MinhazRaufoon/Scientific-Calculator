package GraphicUnit;
import java.awt.Color;
import javax.swing.*;

final class AnswerScreen extends JTextPane
{
    AnswerScreen(String S)
    {
        this.setBounds(80, 150, 465, 60);
        this.setVisible(true);
        this.setEnabled(true);
        this.setForeground(Color.WHITE);
        this.setOpaque(false);
        this.setFont(new java.awt.Font("Calibri", 2, 38));
        this.setText(S);
        this.setEditable(false);
    }   
}

