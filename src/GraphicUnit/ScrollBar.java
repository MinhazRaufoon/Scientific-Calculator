package GraphicUnit;

import javax.swing.*;

final class ScrollBar extends JScrollPane
{
    ScrollBar(InputScreen F)
    {
        super(F);
        this.setBounds(0, 30, 550, 115);
        this.setVisible(true);
        this.setEnabled(true);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    }
}