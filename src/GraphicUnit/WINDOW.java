package GraphicUnit;

import LogicalUnit.*;

import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;
import java.applet.*;

public final class WINDOW extends JFrame implements MouseMotionListener,ActionListener
{
    private AudioClip clip;
    
    
    public void mouseDragged( MouseEvent event )  
    {  
        Rectangle size = getBounds();  
        setBounds( event.getX() + size.x , event.getY() + size.y, size.width, size.height );  
    }         
    public void mouseMoved( MouseEvent event )  {}
        

    private InputScreen OS;
    private Theme T;
    
    
    public WINDOW()
    {
        // Decorating the window ...
        setUndecorated(true);
        addMouseMotionListener( this );
        setSize(580,480);
        setLocation(300,100);
        setLayout(null);
        Container CP = getContentPane();
        CP.setBackground(new java.awt.Color(20,20,20));
        
        //add a sound...
        clip=Applet.newAudioClip(this.getClass().getResource("ding.wav"));
        
        // add all the buttons
        add(new TypicalButton("sin", 0,240,60,40 ,30,153, 0,128,255,0, this));
        add(new TypicalButton("cos", 0,280,60,40 ,30,153, 0,128,255,0, this));
        add(new TypicalButton("tan", 0,320,60,40 ,30,153, 0,128,255,0, this));
        add(new TypicalButton("log", 0,360,60,40 ,30,153, 0,128,255,0, this));
        add(new TypicalButton("ln", 0,400,60,40 ,30,153, 0,128,255,0, this));
        add(new TypicalButton("e", 0,440,60,40 ,30,153, 0,128,255,0, this));
        add(new TypicalButton("UP",new ImageIcon(getClass().getResource("up.png")), 80,240,60,60 , 255,198,0 ,255,255,0, this));
        add(new TypicalButton("DOWN",new ImageIcon(getClass().getResource("dwn.png")), 140,240,60,60 , 255,198,0 ,255,255,0, this));
        add(new TypicalButton("LEFT",new ImageIcon(getClass().getResource("left.png")), 200,240,60,60 , 255,198,0 ,255,255,0, this));
        add(new TypicalButton("RIGHT",new ImageIcon(getClass().getResource("right.png")), 260,240,60,60 , 255,198,0 ,255,255,0, this));
        add(new TypicalButton("+", 260,300,60,60 , this));
        add(new TypicalButton("-", 200,300,60,60 , this));
        add(new TypicalButton("x", 140,300,60,60 , this));
        add(new TypicalButton("/", 80,300,60,60 , this));
        add(new TypicalButton("(", 80,360,120,60 , this));
        add(new TypicalButton(")", 200,360,120,60 ,this));
        add(new TypicalButton("!", 140,420,60,60, this));
        add(new TypicalButton("^", 80,420,60,60, this));
        add(new TypicalButton("ERASE",new ImageIcon(getClass().getResource("back.png")), 200,420,120,60, this));
        add(new TypicalButton("1", 340, 360, 60, 60, this));
        add(new TypicalButton("2", 400, 360, 60, 60, this));
        add(new TypicalButton("3", 460, 360, 60, 60, this));
        add(new TypicalButton("4", 340,300,60,60, this));
        add(new TypicalButton("5", 400,300,60,60, this));
        add(new TypicalButton("6", 460,300,60,60, this));
        add(new TypicalButton("7", 340,240,60,60, this));
        add(new TypicalButton("8", 400,240,60,60, this));
        add(new TypicalButton("9", 460,240,60,60, this));
        add(new TypicalButton(".", 460,420,60,60, this));
        add(new TypicalButton("0", 340,420,120,60, this));
        add(new TypicalButton("AC", 520,240,60,120 , 255,50,50 ,255,0,0, this));
        add(new TypicalButton("SOLVE",new ImageIcon(getClass().getResource("eq.png")), 520,360,60,120 , 255,198,0 ,255,255,0, this));
        
        TypicalButton CLX = new TypicalButton("X", 547, 1, 25, 20 , 0,0,0 , 255,0,0, this);
        CLX.setActionCommand("CLOSE");
        CLX.setFont(new Font("Comic San MS",1, 17));
        add(CLX);
        
        TypicalButton MZ = new TypicalButton("-", 522, 1, 25, 20 , 0,0,0 , 50,50,255, this);
        MZ.setFont(new Font("Tahoma",1, 30));
        MZ.setActionCommand("MIN");
        add(MZ);
        // All Buttons are added .......
        
        // add the title
        JLabel JWL = new JLabel("CALCULATOR");
        JWL.setFont(new Font("Tahoma",1, 14));
        JWL.setOpaque(false);
        JWL.setBounds(250, 0, 470, 20);
        JWL.setForeground(new Color(255,255,255));
        add(JWL);
        
        // display screen theme
        T = new Theme();
        add(T);
        
        // text area to input screen
        OS = new InputScreen();
        
        //add scrollbar
        ScrollBar SC = new ScrollBar(OS);
        SC.getViewport().setOpaque(false);
        SC.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
        T.add(SC);
        T.add(ASC);
        
        // window is visible
        setVisible(true);
    }
    
    private AnswerScreen ASC = new AnswerScreen(null); // ANS display
    
    private boolean flag=true;
    
    public void actionPerformed(ActionEvent ae)
    {
        String S = ae.getActionCommand();
        
        if(S.equals("CLOSE"))
        {
            this.removeAll();
            System.exit(0); // exit
        }
        
        else if(S.equals("MIN")) 
        {
            setState(Frame.ICONIFIED); // minimized
        }
        
        else if(S.equals("ERASE")) // backspace
        {
           flag = true;
           try{
               int pos;
               StringBuffer TXT = new StringBuffer(OS.getText());
               char ch = OS.getText().charAt(OS.getCaretPosition()-1);
               TXT.deleteCharAt(pos = OS.getCaretPosition()-1);
               OS.setText(TXT.toString());
               OS.setCaretPosition(pos);
               
           }
           catch(Exception e)
           {
               
           }
           OS.repaint();
        }
        
        else if(S.equals("SOLVE")) 
        {
            clip.stop();
            clip.play();
            ASC.setText("");
            OS.setCaretPosition(OS.getText().length());
            flag = false;
            
            ExpressionSolver ES = new ExpressionSolver();
            ES.TakeInput(OS.getText());
            //T.remove(ASC);
            
            try{
                ES.CheckError();
                ES.Solve();
                                    
                ASC.setText(ES.TakeOutput()); 
            
            }
            catch(CalculationException e)
            {
                ASC.setText(e.toString());
                return;
            }
            catch(Exception e)
            {
                ASC.setText("Syntax Error");
                return;
            }
        }
       
        else if(S.equals("UP"))
        {
            if(!flag) 
            {
                flag = true;
            }
            try
            {
                OS.setCaretPosition(OS.getCaretPosition()-36);
            }
            catch(IllegalArgumentException e)
            {
                
            }
        }
        
        else if(S=="DOWN") 
        {
            if(!flag) 
            {
                flag = true;
            }
            try
            {
                OS.setCaretPosition(OS.getCaretPosition()+36);
            }
            catch(IllegalArgumentException e)
            {
                
            }
        }
        
        else if(S=="LEFT") 
        {
            if(!flag) 
            {
                flag = true;
            }
            try
            {    
                OS.setCaretPosition(OS.getCaretPosition()-1);
            }
            catch(IllegalArgumentException e)
            {
                
            }
        }
        else if(S=="RIGHT") 
        {
            if(!flag) 
            {
                flag = true;
            }
            try
            {
                OS.setCaretPosition(OS.getCaretPosition()+1);
            }
            catch(IllegalArgumentException e)
            {
                
            }
        }
        
        else if(S.equals("AC")) 
        {
            OS.setText("");
            ASC.setText("");
            flag = false;
            OS.setCaretPosition(OS.getDocument().getLength());
        }
        
        else // for all digit, opeartor and parentheses
        {
            StringBuffer TXT = new StringBuffer(OS.getText());   
            if(!flag) {
                
                OS.setText("");
                flag = true;
                OS.append(S);
            }
            else
            {
                int pos;
                TXT.insert(pos = OS.getCaretPosition(), S);
                OS.setText(TXT.toString());
                OS.setCaretPosition(pos+S.length());
            }
        }   
    }
}
