package GraphicUnit;

import javax.swing.*;

final class Theme extends JLabel
{
    Theme()
    {       
        this.setVisible(true);
        this.setBounds(15, 20, 550, 210);
        this.setEnabled(true);
        this.setOpaque(false);
        ImageIcon z = new ImageIcon(getClass().getResource("back2_2.png"));
        this.setIcon(z);  
    }
}

