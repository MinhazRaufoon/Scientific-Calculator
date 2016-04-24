package GraphicUnit;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

final class TypicalButton extends JButton
implements MouseListener
{
    private int rr,gg,bb;
    private int RR,GG,BB;
        
    public TypicalButton(String name, int X, int Y, int W, int H,  ActionListener AE)
    {
        this.addMouseListener(this);
        this.addActionListener(AE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(new Color(RR = 90,GG = 90,BB = 90));
        this.setVisible(true);
        this.setEnabled(true);
        this.setFont(new Font("Bauhaus 93 Regular", 1, 17));
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setForeground(new Color(255,255,255));
        this.setFocusable(false);
        this.setText(name);
        this.setActionCommand(name);
        this.setBounds(X,Y,W,H);
        
        rr = 120; gg = 120; bb = 120;
    }
    
    public TypicalButton(String name, ImageIcon II, int X, int Y, int W, int H,  ActionListener AE)
    {
        this.addMouseListener(this);
        this.addActionListener(AE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(new Color(RR = 90,GG = 90,BB = 90));
        this.setVisible(true);
        this.setEnabled(true);
        this.setFont(new Font("Tahoma", 1, 17));
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setForeground(new Color(255,255,255));
        this.setFocusable(false);
        this.setIcon(II);
        this.setActionCommand(name);
        this.setBounds(X,Y,W,H);
        
        rr = 120; gg = 120; bb = 120;
    }
    public TypicalButton(String name, int X, int Y, int W, int H, int R,int G,int B,int r,int g,int b,  ActionListener AE)
    {
        this.addMouseListener(this);
        this.addActionListener(AE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(new Color(RR = R,GG = G,BB = B));
        this.setVisible(true);
        this.setEnabled(true);
        this.setFont(new Font("Tahoma", 0, 17));
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setForeground(new Color(255,255,255));
        this.setFocusable(false);
        this.setText(name);
        this.setActionCommand(name);
        this.setBounds(X,Y,W,H);
        
        rr = r; gg = g; bb = b;
    }
    public TypicalButton(String name, ImageIcon II, int X, int Y, int W, int H, int R,int G,int B,int r,int g,int b, ActionListener AE)
    {
        this.addMouseListener(this);
        this.addActionListener(AE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(new Color(RR = R,GG = G,BB = B));
        this.setVisible(true);
        this.setEnabled(true);
        this.setFont(new Font("Tahoma", 1, 17));
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setForeground(new java.awt.Color(255,255,255));
        this.setFocusable(false);
        this.setIcon(II);
        this.setActionCommand(name);
        this.setBounds(X,Y,W,H);
        
        rr = r; gg = g; bb = b;
    }
    
    public void mouseClicked(MouseEvent e)
    {
        setBackground(new Color(rr,gg,bb));
    }
    public void mousePressed(MouseEvent e)
    {
        setBackground(new Color(rr,gg,bb));
       
    }
    public void mouseReleased(MouseEvent e)
    {
        setBackground(new Color(rr,gg,bb));
    }
    
    public void mouseEntered(MouseEvent e)
    {
        setBackground(new Color(rr,gg,bb));
        
    }
    public void mouseExited(MouseEvent e)
    {
        setBackground(new Color(RR,GG,BB));
    }
}
